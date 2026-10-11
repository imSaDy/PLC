// start: Phase 3 reachability engine analyzer
package main.visitor.reachability;

import main.visitor.reachability.ReachabilityGraphAnalyzer.Graph;
import main.visitor.reachability.ReachabilityGraphAnalyzer.Node;
import main.visitor.reachability.ReachabilityResult.UnreachableDeclaration;
import main.ast.core.Program;
import main.ast.declarations.TopLevelDecl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

public final class ReachabilityEngineAnalyzer {
    public ReachabilityResult analyze(Program program) {
        Graph graph = new ReachabilityGraphAnalyzer().analyze(program);
        Set<Node> reachableNodes =
                Collections.newSetFromMap(new IdentityHashMap<>());
        Deque<Node> workList = new ArrayDeque<>();

        for (Node node : graph.nodes()) {
            if (node.hasMainMethod() || "Main".equals(node.name())) {
                reachableNodes.add(node);
                workList.addLast(node);
            }
        }
        while (!workList.isEmpty()) {
            Node node = workList.removeFirst();
            for (String reference : node.references()) {
                Node referencedNode =
                        graph.nodeNamed(reference);
                if (referencedNode != null
                        && reachableNodes.add(referencedNode)) {
                    workList.addLast(referencedNode);
                }
            }
        }
        return createResult(program, graph, reachableNodes);
    }

    private ReachabilityResult createResult(
            Program program,
            Graph graph,
            Set<Node> reachableNodes
    ) {
        Set<TopLevelDecl> reachableDeclarations =
                Collections.newSetFromMap(new IdentityHashMap<>());
        List<UnreachableDeclaration> unreachableDeclarations =
                new ArrayList<>();

        for (Node node : graph.nodes()) {
            if (reachableNodes.contains(node)) {
                reachableDeclarations.add(node.declaration());
            } else {
                unreachableDeclarations.add(new UnreachableDeclaration(
                        node.name(),
                        node.line()
                ));
            }
        }
        return new ReachabilityResult(
                program.getTopLevelDeclarations(),
                reachableDeclarations,
                unreachableDeclarations,
                true
        );
    }
}
// end: Phase 3 reachability engine analyzer
