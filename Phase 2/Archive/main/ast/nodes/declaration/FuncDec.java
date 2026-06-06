package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.Stmt.Stmt;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FuncDec extends Node {
    private String funcName;

    private ArrayList<Stmt> stmts = new ArrayList<Stmt>();

    public FuncDec(String funcName) {
        this.funcName = funcName;
    }

    public void addStmt(Stmt stmt) {
        this.stmts.add(stmt);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public ArrayList<Stmt> getStmts() {
        return stmts;
    }

    public void setStmts(ArrayList<Stmt> stmts) {
        this.stmts = stmts;
    }

}
