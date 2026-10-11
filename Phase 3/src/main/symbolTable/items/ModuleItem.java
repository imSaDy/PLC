package main.symbolTable.items;

import main.symbolTable.SymbolTable;

public class ModuleItem extends SymbolTableItem {
    private SymbolTable moduleSymbolTable;

    public ModuleItem(String name) {
        this.name = name;
        this.moduleSymbolTable = new SymbolTable();
    }

    public SymbolTable getModuleSymbolTable() { return moduleSymbolTable; }
}