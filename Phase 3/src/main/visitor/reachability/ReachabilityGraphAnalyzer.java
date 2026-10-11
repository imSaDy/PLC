// start: Phase 3 reachability graph analyzer
package main.visitor.reachability;

import main.ast.core.Program;
import main.ast.declarations.Member;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.ModuleDecl;
import main.ast.declarations.Struct;
import main.ast.declarations.StructDecl;
import main.ast.declarations.TopLevelDecl;
import main.ast.types.Identifier;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ReachabilityGraphAnalyzer extends Visitor<Void> {
    private enum Phase {
        TOP_LEVELS,
        METHODS
    }

    private final Graph graph = new Graph();
    private Phase phase;
    private Node currentNode;

    Graph analyze(Program program) {
        phase = Phase.TOP_LEVELS;
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }

        phase = Phase.METHODS;
        for (Node node : graph.nodes()) {
            currentNode = node;
            for (Member member : node.members()) {
                member.accept(this);
            }
        }

        for (Node node : graph.nodes()) {
            new ReachabilityReferenceAnalyzer(graph, node).analyze();
        }
        currentNode = null;
        return graph;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        if (phase != Phase.TOP_LEVELS) {
            return null;
        }
        Module module = moduleDecl.getModule();
        List<String> includedNames = new ArrayList<>();
        for (Identifier include : module.getIncludes()) {
            includedNames.add(include.getName());
        }
        graph.addNode(new Node(
                module.getName().getName(),
                module.getLine(),
                moduleDecl,
                module.getMembers(),
                includedNames
        ));
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        if (phase != Phase.TOP_LEVELS) {
            return null;
        }
        Struct struct = structDecl.getStruct();
        graph.addNode(new Node(
                struct.getName().getName(),
                struct.getLine(),
                structDecl,
                struct.getMembers(),
                List.of()
        ));
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        if (phase != Phase.METHODS) {
            return null;
        }
        String methodName = methodDecl.getMethod().getName().getName();
        graph.registerMethod(methodName, currentNode.name());
        if ("main".equals(methodName)) {
            currentNode.markMainMethod();
        }
        return null;
    }

    static final class Graph {
        private final List<Node> nodes = new ArrayList<>();
        private final Map<String, Node> nodeByName =
                new LinkedHashMap<>();
        private final Map<String, Set<String>> methodContainers =
                new LinkedHashMap<>();

        void addNode(Node node) {
            nodes.add(node);
            nodeByName.putIfAbsent(node.name(), node);
        }

        List<Node> nodes() {
            return nodes;
        }

        Node nodeNamed(String name) {
            return nodeByName.get(name);
        }

        boolean containsNode(String name) {
            return nodeByName.containsKey(name);
        }

        void registerMethod(String methodName, String containerName) {
            methodContainers
                    .computeIfAbsent(
                            methodName,
                            ignored -> new LinkedHashSet<>()
                    )
                    .add(containerName);
        }

        Set<String> containersForMethod(String methodName) {
            return methodContainers.get(methodName);
        }
    }

    static final class Node {
        private final String name;
        private final int line;
        private final TopLevelDecl declaration;
        private final List<Member> members;
        private final List<String> includedNames;
        private final Set<String> references = new LinkedHashSet<>();
        private boolean hasMainMethod;

        Node(
                String name,
                int line,
                TopLevelDecl declaration,
                List<Member> members,
                List<String> includedNames
        ) {
            this.name = name;
            this.line = line;
            this.declaration = declaration;
            this.members = members;
            this.includedNames = includedNames;
        }

        String name() {
            return name;
        }

        int line() {
            return line;
        }

        TopLevelDecl declaration() {
            return declaration;
        }

        List<Member> members() {
            return members;
        }

        List<String> includedNames() {
            return includedNames;
        }

        Set<String> references() {
            return references;
        }

        boolean hasMainMethod() {
            return hasMainMethod;
        }

        void markMainMethod() {
            hasMainMethod = true;
        }
    }
}
// end: Phase 3 reachability graph analyzer
