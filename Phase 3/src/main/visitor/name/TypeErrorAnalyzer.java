// start: Phase 3 type and call error analyzer
package main.visitor.name;

import main.visitor.name.SemanticContext.ResolvedLocation;
import main.visitor.name.SemanticContext.TypeSystem;
import main.ast.expressions.BinaryExpression;
import main.ast.expressions.ConstructorCall;
import main.ast.expressions.Expression;
import main.ast.expressions.MemberLoc;
import main.ast.expressions.MethodCall;
import main.ast.expressions.MethodCallLoc;
import main.ast.expressions.ParanthesisExpr;
import main.ast.expressions.SimpleLoc;
import main.ast.expressions.ThisLoc;
import main.ast.expressions.UnaryExpression;
import main.ast.expressions.UnaryOpExpr;
import main.ast.expressions.literals.BoolLiteral;
import main.ast.expressions.literals.CharLiteral;
import main.ast.expressions.literals.DoubleLiteral;
import main.ast.expressions.literals.FloatLiteral;
import main.ast.expressions.literals.IntLiteral;
import main.ast.expressions.operators.BinaryOperator;
import main.ast.types.Identifier;
import main.ast.types.PrimitiveType;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

final class TypeErrorAnalyzer extends Visitor<Type> {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final LocationAnalyzer locations;
    private final InitializationErrorAnalyzer initialization;

    TypeErrorAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            LocationAnalyzer locations,
            InitializationErrorAnalyzer initialization
    ) {
        this.context = context;
        this.names = names;
        this.locations = locations;
        this.initialization = initialization;
    }

    void checkInitializer(Type declared, Type actual, int line) {
        if (declared != null
                && actual != null
                && !TypeSystem.same(declared, actual)) {
            context.report(
                    line,
                    "Type mismatch in assignment. Cannot assign "
                            + actual.getStr()
                            + " to " + declared.getStr()
            );
        }
    }

    boolean checkAssignment(
            ResolvedLocation left,
            Type right,
            int line
    ) {
        boolean mismatch = left != null
                && left.type() != null
                && right != null
                && !TypeSystem.same(left.type(), right);
        if (mismatch) {
            context.report(
                    line,
                    "Type mismatch in assignment. Cannot assign "
                            + right.getStr()
                            + " to " + left.type().getStr()
            );
        }
        return mismatch;
    }

    void checkReturn(Type actual, int line) {
        Type expected = context.currentMethod() == null
                ? null
                : context.currentMethod().getReturnType();
        if (expected != null
                && actual != null
                && !TypeSystem.same(expected, actual)) {
            context.report(
                    line,
                    "Return type mismatch. Expected "
                            + expected.getStr()
                            + ", got " + actual.getStr()
            );
        }
    }

    void requireBoolean(Type condition, int line) {
        if (condition != null && !TypeSystem.isBoolean(condition)) {
            context.report(line, "Condition type must be bool");
        }
    }

    Type voidType() {
        return TypeSystem.primitive(PrimitiveType.Primitive.VOID);
    }

    @Override
    public Type visit(MethodCall methodCall) {
        MethodItem method;
        ResolvedLocation instance = null;
        String methodName = methodCall.getCallee().getName();
        if (methodCall.getInstance() == null) {
            method = names.findUnqualifiedMethod(
                    methodName
            );
        } else {
            instance = locations.resolve(
                    methodCall.getInstance(),
                    false,
                    this
            );
            if (instance == null) {
                analyzeArguments(methodCall);
                return null;
            }
            SymbolTableItem target = locations.containerFor(instance.type());
            if (target == null) {
                context.report(
                        methodCall.getLine(),
                        methodName + " not declared"
                );
                analyzeArguments(methodCall);
                return null;
            }
            method = names.findMethod(
                    target,
                    methodName
            );
        }

        if (method == null) {
            context.report(
                    methodCall.getLine(),
                    methodName + " not declared"
            );
            analyzeArguments(methodCall);
            return null;
        }
        names.checkPrivate(method, methodCall.getLine());

        List<Type> argumentTypes = analyzeArguments(methodCall);

        boolean initializerCall = instance != null
                && initialization.methodInitializesReceiver(method);
        if (instance != null
                && instance.variable() != null
                && !instance.variable().isInitialized()
                && !initializerCall) {
            context.report(
                    methodCall.getLine(),
                    instance.variable().getName() + " is uninitialized"
            );
        }

        List<Type> parameterTypes = method.getParameterTypes();
        if (parameterTypes.size() != argumentTypes.size()) {
            context.report(
                    methodCall.getLine(),
                    "Argument count mismatch for method " + methodName
                            + ". Expected " + parameterTypes.size()
                            + ", got " + argumentTypes.size()
            );
            return allTypesKnown(argumentTypes)
                    ? method.getReturnType()
                    : null;
        }

        boolean argumentsKnown = allTypesKnown(argumentTypes);
        boolean argumentsMatch = checkArgumentTypes(
                methodCall,
                methodName,
                parameterTypes,
                argumentTypes
        );
        if (initializerCall
                && argumentsMatch
                && instance.variable() != null) {
            instance.variable().setInitialized(true);
        }
        return argumentsKnown ? method.getReturnType() : null;
    }

    private List<Type> analyzeArguments(MethodCall methodCall) {
        List<Type> argumentTypes = new ArrayList<>();
        for (Expression argument : methodCall.getArguments()) {
            argumentTypes.add(argument.accept(this));
        }
        return argumentTypes;
    }

    private boolean allTypesKnown(List<Type> types) {
        for (Type type : types) {
            if (type == null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkArgumentTypes(
            MethodCall methodCall,
            String methodName,
            List<Type> parameterTypes,
            List<Type> argumentTypes
    ) {
        boolean match = true;
        for (int index = 0; index < parameterTypes.size(); index++) {
            Type expected = parameterTypes.get(index);
            Type actual = argumentTypes.get(index);
            if (expected == null || actual == null) {
                match = false;
                continue;
            }
            if (!TypeSystem.same(expected, actual)) {
                context.report(
                        methodCall.getLine(),
                        "Argument type mismatch for method " + methodName
                                + ", parameter " + (index + 1)
                                + ". Expected " + expected.getStr()
                                + ", got " + actual.getStr()
                );
                return false;
            }
        }
        return match;
    }

    @Override
    public Type visit(ConstructorCall constructorCall) {
        String name = constructorCall.getName().getName();
        StructItem struct = context.findStruct(name);
        if (struct == null) {
            context.report(
                    constructorCall.getLine(),
                    name + " not declared"
            );
        }

        List<Type> argumentTypes = new ArrayList<>();
        for (Expression argument : constructorCall.getArguments()) {
            argumentTypes.add(argument.accept(this));
        }
        if (struct != null) {
            initializePositionalFields(struct, argumentTypes);
        }
        return new UserDefinedType(constructorCall.getName());
    }

    private void initializePositionalFields(
            StructItem struct,
            List<Type> argumentTypes
    ) {
        int count = Math.min(
                struct.getFields().size(),
                argumentTypes.size()
        );
        for (int index = 0; index < count; index++) {
            Optional<VarItem> field = struct.getFields().get(index);
            if (field.isPresent()
                    && TypeSystem.same(
                            field.get().getType(),
                            argumentTypes.get(index)
                    )) {
                field.get().setInitialized(true);
            }
        }
    }

    @Override
    public Type visit(SimpleLoc simpleLoc) {
        return resolvedType(locations.resolve(simpleLoc, true, this));
    }

    @Override
    public Type visit(MemberLoc memberLoc) {
        return resolvedType(locations.resolve(memberLoc, true, this));
    }

    @Override
    public Type visit(ThisLoc thisLoc) {
        return resolvedType(locations.resolve(thisLoc, true, this));
    }

    private Type resolvedType(ResolvedLocation location) {
        return location == null ? null : location.type();
    }

    @Override
    public Type visit(MethodCallLoc methodCallLoc) {
        return methodCallLoc.getMethodCall().accept(this);
    }

    @Override
    public Type visit(ParanthesisExpr paranthesisExpr) {
        return paranthesisExpr.getExpression().accept(this);
    }

    @Override
    public Type visit(UnaryOpExpr unaryOpExpr) {
        Type operandType = unaryOpExpr.getOperand().accept(this);
        if (unaryOpExpr.getOperator() == UnaryOpExpr.Operator.NOT) {
            return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
        }
        return operandType;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        Type leftType = binaryExpression.getLeftOperand().accept(this);
        Type rightType = binaryExpression.getRightOperand().accept(this);
        BinaryOperator operator = binaryExpression.getOperator();
        if (operator == BinaryOperator.ADDITION
                || operator == BinaryOperator.SUBTRACTION
                || operator == BinaryOperator.MULTIPLICATION
                || operator == BinaryOperator.DIVISION) {
            if (leftType == null || rightType == null) {
                return null;
            }
            if (isNumeric(leftType)
                    && TypeSystem.same(leftType, rightType)) {
                return leftType;
            }
            context.report(
                    binaryExpression.getLine(),
                    "wrong operand types for " + operator.getSymbol()
            );
            return leftType != null ? leftType : rightType;
        }
        if (operator == BinaryOperator.LESS_THAN
                || operator == BinaryOperator.GREATER_THAN
                || operator == BinaryOperator.LESS_THAN_OR_EQUAL_TO
                || operator == BinaryOperator.GREATER_THAN_OR_EQUAL_TO) {
            if (leftType == null || rightType == null) {
                return null;
            }
            if (isNumeric(leftType)
                    && TypeSystem.same(leftType, rightType)) {
                return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
            }
            context.report(
                    binaryExpression.getLine(),
                    "wrong operand types for " + operator.getSymbol()
            );
            return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
        }
        if (operator == BinaryOperator.EQUALITY
                || operator == BinaryOperator.INEQUALITY) {
            if (leftType == null || rightType == null) {
                return null;
            }
            if (!TypeSystem.same(leftType, rightType)) {
                context.report(
                        binaryExpression.getLine(),
                        "wrong operand types for " + operator.getSymbol()
                );
            }
            return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
        }
        if (operator == BinaryOperator.AND
                || operator == BinaryOperator.OR) {
            if (leftType == null || rightType == null) {
                return null;
            }
            if (!TypeSystem.isBoolean(leftType)
                    || !TypeSystem.isBoolean(rightType)) {
                context.report(
                        binaryExpression.getLine(),
                        "wrong operand types for " + operator.getSymbol()
                );
            }
            return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
        }
        return TypeSystem.same(leftType, rightType) ? leftType : null;
    }

    private boolean isNumeric(Type type) {
        if (!(type instanceof PrimitiveType primitiveType)) {
            return false;
        }
        return primitiveType.getPrimitive() == PrimitiveType.Primitive.INT
                || primitiveType.getPrimitive()
                        == PrimitiveType.Primitive.FLOAT
                || primitiveType.getPrimitive()
                        == PrimitiveType.Primitive.DOUBLE;
    }

    @Override
    public Type visit(IntLiteral intLiteral) {
        return TypeSystem.primitive(PrimitiveType.Primitive.INT);
    }

    @Override
    public Type visit(FloatLiteral floatLiteral) {
        return TypeSystem.primitive(PrimitiveType.Primitive.FLOAT);
    }

    @Override
    public Type visit(DoubleLiteral doubleLiteral) {
        return TypeSystem.primitive(PrimitiveType.Primitive.DOUBLE);
    }

    @Override
    public Type visit(CharLiteral charLiteral) {
        return TypeSystem.primitive(PrimitiveType.Primitive.CHAR);
    }

    @Override
    public Type visit(BoolLiteral boolLiteral) {
        return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
    }

    @Override
    public Type visit(Identifier identifier) {
        return null;
    }

    @Override
    public Type visit(PrimitiveType primitiveType) {
        return primitiveType;
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        Type expressionType = unaryExpression.getExpression().accept(this);
        return unaryExpression.getOperand().getSymbol().equals("not")
                ? TypeSystem.primitive(PrimitiveType.Primitive.BOOL)
                : expressionType;
    }

    @Override
    public Type visit(UserDefinedType userDefinedType) {
        String name = userDefinedType.getId().getName();
        if (context.findTopLevel(name) == null) {
            context.report(
                    userDefinedType.getLine(),
                    name + " not declared"
            );
            return null;
        }
        return userDefinedType;
    }
}
// end: Phase 3 type and call error analyzer
