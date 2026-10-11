#!/usr/bin/env python3
"""Rebuild Phases 2–4 and check their supplied reference samples."""
import argparse
import json
from pathlib import Path
import shutil
import subprocess
import tempfile


def run(command, cwd):
    result = subprocess.run(command, cwd=cwd, text=True, capture_output=True)
    if result.returncode:
        raise RuntimeError(f"Command failed: {command}\n{result.stdout}\n{result.stderr}")
    return result


def normalized(value):
    return value.replace("\r\n", "\n").expandtabs(8).strip()


def verify(root):
    results = []
    with tempfile.TemporaryDirectory(prefix="plc-verify-") as temporary:
        temporary = Path(temporary)
        for phase_number in (2, 3, 4):
            phase = root / f"Phase {phase_number}"
            work = temporary / f"phase{phase_number}"
            generated = work / "generated"
            classes = work / "classes"
            generated.mkdir(parents=True)
            classes.mkdir()
            jar = phase / "utilities/antlr-4.13.1-complete.jar"
            grammar = phase / "src/main/grammar/SimpleLang.g4"
            run(["java", "-jar", str(jar), "-visitor", "-Xexact-output-dir",
                 "-o", str(generated), str(grammar)], work)
            sources = sorted(path for path in (phase / "src").rglob("*.java")
                             if not path.is_relative_to(phase / "src/main/grammar"))
            sources.extend(sorted(generated.glob("*.java")))
            source_list = work / "sources.txt"
            source_list.write_text("\n".join('"' + str(path) + '"' for path in sources))
            # The compiler module also works in JDK installations without a javac launcher.
            run(["java", "-m", "jdk.compiler/com.sun.tools.javac.Main",
                 "-encoding", "UTF-8", "-cp", str(jar), "-d", str(classes),
                 "@" + str(source_list)], work)
            fixture_directory = phase / ("Sample" if phase_number == 4 else "samples")
            fixtures = work / "fixtures"
            shutil.copytree(fixture_directory, fixtures)
            expected_files = sorted(fixtures.rglob("*.out")) if phase_number != 4 else [fixtures / "sample.mol"]
            for expected in expected_files:
                sample = expected if phase_number == 4 else expected.with_suffix(".mol")
                process = run(["java", "-cp", str(classes) + ":" + str(jar),
                               "SimpleLang", str(sample)], work)
                if process.stderr.strip():
                    raise AssertionError(f"Phase {phase_number}, {sample.name}: {process.stderr}")
                if phase_number != 4:
                    if normalized(process.stdout) != normalized(expected.read_text()):
                        raise AssertionError(f"Phase {phase_number}, {sample.name}: output differs\n"
                                             f"Expected:\n{expected.read_text()}\nActual:\n{process.stdout}")
                else:
                    output = work / "codeGenOutput"
                    reference = sorted(fixtures.glob("*.j"))
                    if sorted(path.name for path in output.glob("*.j")) != [path.name for path in reference]:
                        raise AssertionError("Phase 4: generated class files differ from the reference set")
                    for path in reference:
                        if normalized((output / path.name).read_text()) != normalized(path.read_text()):
                            raise AssertionError(f"Phase 4: generated assembly differs for {path.name}")
                results.append({"phase": phase_number, "sample": str(sample.relative_to(fixtures)),
                                "status": "passed"})
    return results


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument("--report", type=Path)
    arguments = parser.parse_args()
    results = verify(arguments.root.resolve())
    if arguments.report:
        arguments.report.write_text(json.dumps(results, indent=2) + "\n")
    for phase in (2, 3, 4):
        count = sum(result["phase"] == phase for result in results)
        print(f"Phase {phase}: {count} supplied samples passed")
