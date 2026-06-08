package main.ast.types;

import main.visitor.IVisitor;

public class PrimitiveType extends Type {
    public enum Primitive {
        INT("int"),
        FLOAT("float"),
        DOUBLE("double"),
        CHAR("char"),
        VOID("void"),
        BOOL("bool");

        private final String text;

        Primitive(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    private Primitive primitive;

    public PrimitiveType(Primitive primitive) {
        this.primitive = primitive;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getStr() {
        return primitive.getText();
    }

    @Override
    public String toString() {
        return getStr();
    }

    public Primitive getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Primitive primitive) {
        this.primitive = primitive;
    }
}
