package main.ast;
import main.visitor.IVisitor;
import java.util.ArrayList;

public class Program extends Node{

    public Program() {
      // constructor  
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
