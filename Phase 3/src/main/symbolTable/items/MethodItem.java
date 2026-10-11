package main.symbolTable.items;

import main.ast.types.Type;
import java.util.ArrayList;

public class MethodItem extends SymbolTableItem {
    private Type returnType;
    private ArrayList<Type> parameterTypes;
    private String visibility; 

    public MethodItem(String name, Type returnType, String visibility) {
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = new ArrayList<>();
        this.visibility = visibility;
    }

    public void addParameterType(Type type) {
        this.parameterTypes.add(type);
    }

    
    public Type getReturnType() { return returnType; }
    public ArrayList<Type> getParameterTypes() { return parameterTypes; }
    public String getVisibility() { return visibility; }
}