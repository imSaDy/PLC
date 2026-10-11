// start: Phase 3 shared semantic context and values
package main.visitor.name;

import main.ast.declarations.Method;
import main.ast.declarations.Module;
import main.ast.declarations.Struct;
import main.ast.declarations.Var;
import main.ast.types.PrimitiveType;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class SemanticContext {
    private final DiagnosticCollector diagnostics = new DiagnosticCollector();
    private final Map<Module, ModuleItem> moduleItems =
            new IdentityHashMap<>();
    private final Map<Struct, StructItem> structItems =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, SymbolTableItem>
            declarationContainers =
            new IdentityHashMap<>();
    private final Map<MethodItem, Method> methodDeclarations =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, SymbolTable> memberTables =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, List<String>> includedNames =
            new IdentityHashMap<>();
    private final List<SymbolTableItem> topLevelItems = new ArrayList<>();
    private final List<VarItem> trackedVariables = new ArrayList<>();

    private final SymbolTable globalTable;
    private SymbolTable currentScope;
    private SymbolTableItem currentContainer;
    private Method currentMethod;

    SemanticContext() {
        globalTable = new SymbolTable();
        SymbolTable.root = globalTable;
        SymbolTable.top = globalTable;
    }

    void report(int line, String message) {
        diagnostics.report(line, message);
    }

    List<String> messages() {
        return diagnostics.messages();
    }

    SymbolTable globalTable() {
        return globalTable;
    }

    SymbolTable currentScope() {
        return currentScope;
    }

    void setCurrentScope(SymbolTable currentScope) {
        this.currentScope = currentScope;
    }

    SymbolTableItem currentContainer() {
        return currentContainer;
    }

    void setCurrentContainer(SymbolTableItem currentContainer) {
        this.currentContainer = currentContainer;
    }

    Method currentMethod() {
        return currentMethod;
    }

    void setCurrentMethod(Method currentMethod) {
        this.currentMethod = currentMethod;
    }

    void bind(Module module, ModuleItem item) {
        moduleItems.put(module, item);
        memberTables.put(item, item.getModuleSymbolTable());
        List<String> names = new ArrayList<>();
        module.getIncludes().forEach(
                include -> names.add(include.getName())
        );
        includedNames.put(item, List.copyOf(names));
    }

    void bind(Struct struct, StructItem item) {
        structItems.put(struct, item);
        memberTables.put(item, item.getStructSymbolTable());
        includedNames.put(item, List.of());
    }

    void registerTopLevel(SymbolTableItem item) {
        topLevelItems.add(item);
    }

    List<SymbolTableItem> topLevelItems() {
        return List.copyOf(topLevelItems);
    }

    void trackVariable(VarItem variable) {
        trackedVariables.add(variable);
    }

    Map<VarItem, Boolean> snapshotInitialization() {
        Map<VarItem, Boolean> snapshot = new IdentityHashMap<>();
        for (VarItem variable : trackedVariables) {
            snapshot.put(variable, variable.isInitialized());
        }
        return snapshot;
    }

    void restoreInitialization(Map<VarItem, Boolean> snapshot) {
        for (Map.Entry<VarItem, Boolean> entry : snapshot.entrySet()) {
            entry.getKey().setInitialized(entry.getValue());
        }
    }

    void mergeBranchInitialization(
            Map<VarItem, Boolean> before,
            Map<VarItem, Boolean> thenState,
            Map<VarItem, Boolean> elseState
    ) {
        for (Map.Entry<VarItem, Boolean> entry : before.entrySet()) {
            VarItem variable = entry.getKey();
            boolean wasInitialized = entry.getValue();
            boolean initializedInBothBranches =
                    Boolean.TRUE.equals(thenState.get(variable))
                            && Boolean.TRUE.equals(elseState.get(variable));
            variable.setInitialized(
                    wasInitialized || initializedInBothBranches
            );
        }
    }

    SymbolTable memberTable(SymbolTableItem item) {
        return memberTables.get(item);
    }

    List<String> includedNames(SymbolTableItem item) {
        return includedNames.getOrDefault(item, List.of());
    }

    ModuleItem itemFor(Module module) {
        return moduleItems.get(module);
    }

    StructItem itemFor(Struct struct) {
        return structItems.get(struct);
    }

    void bindDeclaration(
            SymbolTableItem declaration,
            SymbolTableItem container
    ) {
        declarationContainers.put(declaration, container);
    }

    SymbolTableItem declarationContainer(SymbolTableItem declaration) {
        return declarationContainers.get(declaration);
    }

    boolean isMember(SymbolTableItem declaration) {
        return declarationContainers.containsKey(declaration);
    }

    void bindMethod(MethodItem item, Method declaration) {
        methodDeclarations.put(item, declaration);
    }

    Method declarationFor(MethodItem item) {
        return methodDeclarations.get(item);
    }

    VarItem lookupVariable(String name) {
        if (currentScope == null) {
            return null;
        }
        try {
            return (VarItem) currentScope.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    SymbolTableItem findTopLevel(String name) {
        try {
            return globalTable.get(name);
        } catch (ItemNotFoundException exception) {
            return null;
        }
    }

    ModuleItem findModule(String name) {
        try {
            return (ModuleItem) globalTable.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    StructItem findStruct(String name) {
        try {
            return (StructItem) globalTable.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    private static final class DiagnosticCollector {
        private final List<Diagnostic> diagnostics = new ArrayList<>();
        private int nextOrder;

        void report(int line, String message) {
            diagnostics.add(new Diagnostic(line, nextOrder++, message));
        }

        List<String> messages() {
            diagnostics.sort(Comparator
                    .comparingInt(DiagnosticCollector::priority)
                    .thenComparingInt(Diagnostic::line)
                    .thenComparingInt(Diagnostic::order));

            List<String> messages = new ArrayList<>();
            for (Diagnostic diagnostic : diagnostics) {
                messages.add(
                        "Line " + diagnostic.line() + ": "
                                + diagnostic.message()
                );
            }
            return messages;
        }

        private record Diagnostic(int line, int order, String message) {
        }

        private static int priority(Diagnostic diagnostic) {
            String message = diagnostic.message();
            if (message.endsWith(" is uninitialized")) {
                return 2;
            }
            if (message.startsWith("Type mismatch")
                    || message.startsWith("Condition type")
                    || message.startsWith("Return type")
                    || message.startsWith("Cannot modify immutable")
                    || message.startsWith("Argument count mismatch")
                    || message.startsWith("Argument type mismatch")
                    || message.startsWith("wrong operand types")) {
                return 0;
            }
            return 1;
        }
    }

    static final class TypeSystem {
        private TypeSystem() {
        }

        static PrimitiveType primitive(
                PrimitiveType.Primitive primitive
        ) {
            return new PrimitiveType(primitive);
        }

        static boolean isBoolean(Type type) {
            return type != null && "bool".equals(type.getStr());
        }

        static boolean same(Type first, Type second) {
            return first != null
                    && second != null
                    && first.getStr() != null
                    && first.getStr().equals(second.getStr());
        }
    }

    static final class DeclaredTypeResolver {
        private DeclaredTypeResolver() {
        }

        static Type typeOf(Var var) {
            if (var.getType() != null) {
                return var.getType();
            }
            if (var.getConstructorCall() != null) {
                return new UserDefinedType(
                        var.getConstructorCall().getName()
                );
            }
            return null;
        }
    }

    static final class ResolvedLocation {
        private final Type type;
        private final VarItem variable;

        ResolvedLocation(Type type, VarItem variable) {
            this.type = type;
            this.variable = variable;
        }

        Type type() {
            return type;
        }

        VarItem variable() {
            return variable;
        }
    }

    static final class TopLevelTypeAnalyzer
            extends Visitor<SymbolTableItem> {
        private final SemanticContext context;

        TopLevelTypeAnalyzer(SemanticContext context) {
            this.context = context;
        }

        @Override
        public SymbolTableItem visit(UserDefinedType userDefinedType) {
            return context.findTopLevel(
                    userDefinedType.getId().getName()
            );
        }
    }
}
// end: Phase 3 shared semantic context and values
