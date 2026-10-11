// start: Phase 3 name and access error analyzer
package main.visitor.name;

import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;

import java.util.HashSet;
import java.util.Set;

final class NameErrorAnalyzer {
    private final SemanticContext context;

    NameErrorAnalyzer(SemanticContext context) {
        this.context = context;
    }

    VarItem findField(SymbolTableItem container, String name) {
        return findField(container, name, new HashSet<>());
    }

    private VarItem findField(
            SymbolTableItem container,
            String name,
            Set<String> visited
    ) {
        if (container == null || !visited.add(container.getName())) {
            return null;
        }
        VarItem direct = memberVariable(container, name);
        if (direct != null) {
            return direct;
        }
        for (String includedName : context.includedNames(container)) {
            VarItem included = findField(
                    context.findTopLevel(includedName),
                    name,
                    visited
            );
            if (included != null) {
                return included;
            }
        }
        return null;
    }

    MethodItem findMethod(SymbolTableItem container, String name) {
        return findMethod(container, name, new HashSet<>());
    }

    private MethodItem findMethod(
            SymbolTableItem container,
            String name,
            Set<String> visited
    ) {
        if (container == null || !visited.add(container.getName())) {
            return null;
        }
        MethodItem direct = memberMethod(container, name);
        if (direct != null) {
            return direct;
        }
        for (String includedName : context.includedNames(container)) {
            MethodItem included = findMethod(
                    context.findTopLevel(includedName),
                    name,
                    visited
            );
            if (included != null) {
                return included;
            }
        }
        return null;
    }

    MethodItem findUnqualifiedMethod(String name) {
        return findMethod(context.currentContainer(), name);
    }

    boolean checkPrivate(VarItem item, int line) {
        return checkPrivate(item, item.getVisibility(), line);
    }

    boolean checkPrivate(MethodItem item, int line) {
        return checkPrivate(item, item.getVisibility(), line);
    }

    private boolean checkPrivate(
            SymbolTableItem item,
            String visibility,
            int line
    ) {
        SymbolTableItem declarationContainer =
                context.declarationContainer(item);
        if (declarationContainer != null
                && declarationContainer != context.currentContainer()
                && "private".equals(visibility)) {
            context.report(line, item.getName() + " is private");
            return true;
        }
        return false;
    }

    private VarItem memberVariable(SymbolTableItem container, String name) {
        try {
            return (VarItem) context.memberTable(container).get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    private MethodItem memberMethod(SymbolTableItem container, String name) {
        try {
            return (MethodItem) context.memberTable(container).get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }
}
// end: Phase 3 name and access error analyzer
