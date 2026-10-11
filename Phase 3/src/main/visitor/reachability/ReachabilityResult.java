// start: Phase 3 reachability result
package main.visitor.reachability;

import main.ast.declarations.TopLevelDecl;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

public final class ReachabilityResult {
    private final List<TopLevelDecl> declarations;
    private final Set<TopLevelDecl> reachableDeclarations;
    private final List<UnreachableDeclaration> unreachableDeclarations;
    private final boolean hasEntryPoint;

    ReachabilityResult(
            List<TopLevelDecl> declarations,
            Set<TopLevelDecl> reachableDeclarations,
            List<UnreachableDeclaration> unreachableDeclarations,
            boolean hasEntryPoint
    ) {
        this.declarations = new ArrayList<>(declarations);
        this.reachableDeclarations = reachableDeclarations;
        this.unreachableDeclarations = unreachableDeclarations;
        this.hasEntryPoint = hasEntryPoint;
    }

    static ReachabilityResult withoutEntryPoint(
            List<TopLevelDecl> declarations
    ) {
        Set<TopLevelDecl> allDeclarations =
                Collections.newSetFromMap(new IdentityHashMap<>());
        allDeclarations.addAll(declarations);
        return new ReachabilityResult(
                declarations,
                allDeclarations,
                Collections.emptyList(),
                false
        );
    }

    public List<String> warnings() {
        List<String> warnings = new ArrayList<>();
        for (UnreachableDeclaration declaration
                : unreachableDeclarations) {
            warnings.add(
                    "Warning Line " + declaration.line() + " : "
                            + declaration.name() + " is unreachable"
            );
        }
        return warnings;
    }

    public boolean hasUnreachableDeclarations() {
        return hasEntryPoint && !unreachableDeclarations.isEmpty();
    }

    public Path writeOptimizedSource(
            Path inputPath,
            List<? extends ParserRuleContext> declarationContexts
    ) throws IOException {
        if (!hasUnreachableDeclarations()) {
            return null;
        }
        if (declarations.size() != declarationContexts.size()) {
            throw new IllegalArgumentException(
                    "AST and parse-tree declaration counts differ"
            );
        }

        String source = Files.readString(
                inputPath,
                StandardCharsets.UTF_8
        );
        String lineSeparator = source.contains("\r\n") ? "\r\n" : "\n";
        List<String> retainedDeclarations = new ArrayList<>();
        for (int index = 0; index < declarations.size(); index++) {
            TopLevelDecl declaration = declarations.get(index);
            if (!reachableDeclarations.contains(declaration)) {
                continue;
            }
            ParserRuleContext context = declarationContexts.get(index);
            int start = context.getStart().getStartIndex();
            int end = context.getStop().getStopIndex() + 1;
            retainedDeclarations.add(
                    source.substring(start, end).strip()
            );
        }

        String optimizedSource = String.join(
                lineSeparator + lineSeparator,
                retainedDeclarations
        );
        if (!optimizedSource.isEmpty()) {
            optimizedSource += lineSeparator;
        }

        Path outputPath = optimizedPath(inputPath);
        Files.writeString(
                outputPath,
                optimizedSource,
                StandardCharsets.UTF_8
        );
        return outputPath;
    }

    private Path optimizedPath(Path inputPath) {
        String fileName = inputPath.getFileName().toString();
        int extensionIndex = fileName.lastIndexOf('.');
        String baseName = extensionIndex < 0
                ? fileName
                : fileName.substring(0, extensionIndex);
        String extension = extensionIndex < 0
                ? ""
                : fileName.substring(extensionIndex);
        return inputPath.resolveSibling(
                baseName + "_optimized" + extension
        );
    }

    static record UnreachableDeclaration(String name, int line) {
    }
}
// end: Phase 3 reachability result
