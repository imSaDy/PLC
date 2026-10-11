// start: Phase 3 struct symbol item
package main.symbolTable.items;

import main.symbolTable.SymbolTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StructItem extends SymbolTableItem {
    private final SymbolTable structSymbolTable;
    private final List<Optional<VarItem>> fields = new ArrayList<>();

    public StructItem(String name) {
        this.name = name;
        this.structSymbolTable = new SymbolTable();
    }

    public void addField(VarItem field) {
        fields.add(Optional.of(field));
    }

    public void addInvalidFieldSlot() {
        fields.add(Optional.empty());
    }

    public List<Optional<VarItem>> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public SymbolTable getStructSymbolTable() {
        return structSymbolTable;
    }
}
// end: Phase 3 struct symbol item
