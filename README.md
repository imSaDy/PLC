# MOL compiler

Staged compiler implementations for a modular language with structs, fields,
methods, scoped variables, expressions, and control flow.

| Directory | Implementation |
| --- | --- |
| Phase 1 | Original lexical and syntax analysis submission. |
| Phase 2 | Parsing and abstract syntax tree construction, with reference AST outputs. |
| Phase 3 | Symbol and type analysis, initialization checks, and reachability analysis that removes unreachable top-level declarations from an optimized source copy. |
| Phase 4 | Stack-based virtual-machine assembly generation for classes, constructors, methods, expressions, and control flow. |

Each directory preserves its own submission. The later phases are separate
snapshots, rather than a single integrated compiler pipeline. Original sources,
grammars, generated parser files, samples, reports, and supplied utilities are
retained. Local build outputs and editor caches from the uploaded archives are
excluded; existing repository files are retained.

## Verify the supplied samples

Requirements: Python 3.9+ and a Java 17+ JDK with the compiler module. The supplied
parser generator is included in each phase's `utilities` directory.

```sh
python3 scripts/verify_phases.py
```

The script regenerates each parser, compiles the corresponding source tree, and
runs the samples in temporary directories. It checks nine Phase 2 AST outputs,
eleven Phase 3 diagnostic outputs, and the Phase 4 sample's two assembly files.
It excludes duplicate generated editor caches from compilation and leaves
submitted fixtures untouched.

Verified on 11 October 2026: all 21 supplied sample checks passed. Phase 4
validation compares generated assembly against the submitted reference; it does
not assemble or execute that assembly. Passing these samples does not establish
complete language conformance. The Phase 3 report records broader diagnostic
compatibility limitations; the Phase 4 input-statement generator is a stub.

## Submission synchronization

On 11 October 2026, compared the user-provided archives
`PLC_CA2_810102588.zip`, `CA3_PLC_810102588.zip`, and
`PLC-PH4-810102588.zip` with the existing repository. Updated the five changed
Phase 2 files and added the source and supporting files for Phases 3 and 4.
Unchanged Phase 2 files and all earlier repository content were preserved.
