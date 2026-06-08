package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.Member;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.Parameter;
import main.ast.declarations.Struct;
import main.ast.declarations.TopLevelDecl;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
import main.ast.types.AccessModifier;
import main.ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class PrintVisitor extends Visitor<Void> {
    private int level = 0;

    @Override
    public Void visit(Program program) {
        int moduleCount = 0;
        int structCount = 0;

        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            if (declaration instanceof Module) {
                moduleCount++;
            } else if (declaration instanceof Struct) {
                structCount++;
            }
        }

        System.out.println("program [modules:" + moduleCount + " structs:" + structCount + "]");
        
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Module module) {
        int methodCount = 0;
        int fieldCount = 0;

        for (Member member : module.getMembers()) {
            if (member instanceof MethodDecl) {
                methodCount++;
            } else if (member instanceof VarDecl) {
                fieldCount++;
            }
        }

        level++;
        System.out.println(indent() + "module " + module.getName().getName()
                + " [methods:" + methodCount + " fields:" + fieldCount + "]");
        level++;
        
        for (Member member : module.getMembers()) {
            member.accept(this);
        }
        
        level -= 2;
        return null;
    }

    @Override
    public Void visit(Struct struct) {
        int fieldCount = 0;
        for (Member member : struct.getMembers()) {
            if (member instanceof VarDecl) {
                fieldCount++;
            }
        }

        level++;
        System.out.println(indent() + "struct " + struct.getName().getName()
                + " [fields:" + fieldCount + "]");
        level++;
        
        for (Member member : struct.getMembers()) {
            member.accept(this);
        }
        
        level -= 2;
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        Method method = methodDecl.getMethod();
        int statementCount = 0;
        if (method.getBody() != null) {
            statementCount = method.getBody().getStatements().size();
        }

        String accessStr = "";
        if (methodDecl.getAccessModifier() != null) {
            accessStr = ":" + methodDecl.getAccessModifier().name().toLowerCase();
        }

        System.out.println(indent() + "method " + method.getName().getName() + " "
                + methodType(method) + accessStr + " [statements:" + statementCount + "]");
        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        Var var = varDecl.getVar();
        
        String accessStr = "";
        if (varDecl.getAccessModifier() != null) {
            accessStr = ":" + varDecl.getAccessModifier().name().toLowerCase();
        }

        System.out.println(indent() + "field " + var.getName().getName() + " "
                + varType(var) + accessStr);
        return null;
    }

    private String methodType(Method method) {
        List<String> parameterTypes = new ArrayList<>();
        for (Parameter parameter : method.getParameters()) {
            parameterTypes.add(typeName(parameter.getType()));
        }

        String inputTypes = parameterTypes.isEmpty() ? "void" : String.join("*", parameterTypes);
        return "(" + inputTypes + " -> " + typeName(method.getReturnType()) + ")";
    }

    private String varType(Var var) {
        if (var.getType() != null) {
            return typeName(var.getType());
        }
        if (var.getConstructorCall() != null) {
            return var.getConstructorCall().getName().getName();
        }
        return "unknown";
    }

    private String typeName(Type type) {
        return type == null ? "void" : type.getStr();
    }

    private String indent() {
        return "\t".repeat(level);
    }
}