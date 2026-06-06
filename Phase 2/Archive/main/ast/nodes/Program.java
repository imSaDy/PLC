package main.ast.nodes;

import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Program extends Node{
    private Main main;
    private ArrayList<FuncDec> funcDecs = new ArrayList<>();
    
    public Program() {}
    public void addFuncDec(FuncDec funcDec) {
        this.funcDecs.add(funcDec);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ArrayList<FuncDec> getFuncDecs() {
        return funcDecs;
    }

    public void setFuncDecs(ArrayList<FuncDec> funcDecs) {
        this.funcDecs = funcDecs;
    }
}
