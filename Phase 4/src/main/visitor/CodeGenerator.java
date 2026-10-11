package main.visitor;

import main.ast.core.Program;
import main.ast.declarations.Member;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.ModuleDecl;
import main.ast.declarations.Parameter;
import main.ast.declarations.Struct;
import main.ast.declarations.StructDecl;
import main.ast.declarations.TopLevelDecl;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
import main.ast.expressions.BinaryExpression;
import main.ast.expressions.ConstantExpression;
import main.ast.expressions.ConstructorCall;
import main.ast.expressions.Expression;
import main.ast.expressions.Location;
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
import main.ast.expressions.operators.UnaryOperator;
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.BreakJump;
import main.ast.statements.ContinueJump;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.MethodCallStmt;
import main.ast.statements.OutputStmt;
import main.ast.statements.ReturnStmt;
import main.ast.statements.Statement;
import main.ast.statements.VarDeclStmt;
import main.ast.statements.WhileStmt;
import main.ast.types.AccessModifier;
import main.ast.types.Identifier;
import main.ast.types.PrimitiveType;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CodeGenerator extends Visitor<String> {
    private static final String MAIN_CLASS_NAME = "Main";
    private static final String OBJECT_CLASS_NAME = "java/lang/Object";

    private final String outputPath;
    private FileWriter writer;
    private Program currentProgram;
    private ClassInfo currentClass;
    private MethodInfo currentMethod;
    private int nextSlot;
    private int labelCounter;

    private final Map<String, ClassInfo> classes = new LinkedHashMap<>();
    private final Map<String, SlotInfo> slots = new LinkedHashMap<>();
    private final Deque<LoopLabels> loopLabels = new ArrayDeque<>();

    public CodeGenerator() {
        this.outputPath = "./codeGenOutput/";
        prepareOutputDirectory();
    }

    private static class ClassInfo {
        private final String name;
        private final String superName;
        private final List<String> includeNames;
        private final List<Member> members;
        private final Map<String, FieldInfo> fields = new LinkedHashMap<>();
        private final List<MethodInfo> methods = new ArrayList<>();
        private final Set<Integer> constructorArities = new TreeSet<>();

        private ClassInfo(String name, String superName, List<String> includeNames, List<Member> members) {
            this.name = name;
            this.superName = superName;
            this.includeNames = includeNames;
            this.members = members;
        }
    }

    private static class FieldInfo {
        private final String owner;
        private final String name;
        private final String descriptor;
        private final AccessModifier accessModifier;

        private FieldInfo(String owner, String name, String descriptor, AccessModifier accessModifier) {
            this.owner = owner;
            this.name = name;
            this.descriptor = descriptor;
            this.accessModifier = accessModifier;
        }
    }

    private static class MethodInfo {
        private final String owner;
        private final String name;
        private final String returnDescriptor;
        private final List<String> parameterDescriptors;
        private final AccessModifier accessModifier;
        private final Method source;

        private MethodInfo(String owner, String name, String returnDescriptor,
                           List<String> parameterDescriptors, AccessModifier accessModifier,
                           Method source) {
            this.owner = owner;
            this.name = name;
            this.returnDescriptor = returnDescriptor;
            this.parameterDescriptors = parameterDescriptors;
            this.accessModifier = accessModifier;
            this.source = source;
        }

        private String descriptor() {
            StringBuilder descriptor = new StringBuilder("(");
            for (String parameterDescriptor : parameterDescriptors) {
                descriptor.append(parameterDescriptor);
            }
            descriptor.append(")").append(returnDescriptor);
            return descriptor.toString();
        }
    }

    private static class SlotInfo {
        private final int index;
        private final String descriptor;
        private final boolean parameter;

        private SlotInfo(int index, String descriptor, boolean parameter) {
            this.index = index;
            this.descriptor = descriptor;
            this.parameter = parameter;
        }
    }

    private static class LocationTarget {
        private final boolean local;
        private final int slot;
        private final boolean parameterLocal;
        private final String owner;
        private final String name;
        private final String descriptor;

        private LocationTarget(int slot, String descriptor, boolean parameterLocal) {
            this.local = true;
            this.slot = slot;
            this.parameterLocal = parameterLocal;
            this.owner = null;
            this.name = null;
            this.descriptor = descriptor;
        }

        private LocationTarget(String owner, String name, String descriptor) {
            this.local = false;
            this.slot = -1;
            this.parameterLocal = false;
            this.owner = owner;
            this.name = name;
            this.descriptor = descriptor;
        }
    }

    private static class LoopLabels {
        private final String breakLabel;
        private final String continueLabel;

        private LoopLabels(String breakLabel, String continueLabel) {
            this.breakLabel = breakLabel;
            this.continueLabel = continueLabel;
        }
    }

    private void prepareOutputDirectory() {
        File dir = new File(outputPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".j")) {
                file.delete();
            }
        }
    }

    @Override
    public String visit(Program program) {
        currentProgram = program;
        classes.clear();
        labelCounter = 0;
        collectClassInfo(program);

        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public String visit(ModuleDecl moduleDecl) {
        if (moduleDecl.getModule() != null) {
            moduleDecl.getModule().accept(this);
        }
        return null;
    }

    @Override
    public String visit(StructDecl structDecl) {
        if (structDecl.getStruct() != null) {
            structDecl.getStruct().accept(this);
        }
        return null;
    }

    @Override
    public String visit(Module module) {
        ClassInfo previousClass = currentClass;
        currentClass = classes.get(module.getName().getName());
        try {
            initializeWriter();
            writeClassHeader();
            writeStaticFields(currentProgram);
            generateBody();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate module " + module.getName().getName(), e);
        } finally {
            closeWriterQuietly();
            currentClass = previousClass;
        }
        return null;
    }

    @Override
    public String visit(Struct struct) {
        ClassInfo previousClass = currentClass;
        currentClass = classes.get(struct.getName().getName());
        try {
            initializeWriter();
            writeClassHeader();
            writeStaticFields(currentProgram);
            generateBody();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate struct " + struct.getName().getName(), e);
        } finally {
            closeWriterQuietly();
            currentClass = previousClass;
        }
        return null;
    }

    private void initializeWriter() throws IOException {
        writer = new FileWriter(outputPath + currentClass.name + ".j");
    }

    private void writeClassHeader() throws IOException {
        writer.write(".class public " + currentClass.name + "\n");
        writer.write(".super " + currentClass.superName + "\n\n");
    }

    private void writeStaticFields(Program program) throws IOException {
        for (FieldInfo field : currentClass.fields.values()) {
            writer.write(".field " + accessFlag(field.accessModifier) + " "
                    + field.name + " " + field.descriptor + "\n");
        }
        if (!currentClass.fields.isEmpty()) {
            writer.write("\n");
        }
    }

    private void writeMainMethodHeader() throws IOException {
        writer.write(".method public static main([Ljava/lang/String;)V\n");
        writer.write("    .limit stack 128\n");
        writer.write("    .limit locals 128\n");
    }

    private void generateBody() throws IOException {
        writeDefaultConstructor();
        writeFieldConstructors();
        for (MethodInfo methodInfo : currentClass.methods) {
            writeRaw("\n");
            emitMethod(methodInfo);
        }
        if (MAIN_CLASS_NAME.equals(currentClass.name)) {
            writeJvmMainWrapper();
        }
    }

    private void writeMainMethodFooter() throws IOException {
        writer.write("    return\n");
        writer.write(".end method\n");
    }

    private void closeWriter() throws IOException {
        writer.close();
        trimTrailingNewlines(new File(outputPath + currentClass.name + ".j").toPath());
    }

    private void trimTrailingNewlines(Path path) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        int end = bytes.length;
        while (end > 0 && (bytes[end - 1] == '\n' || bytes[end - 1] == '\r')) {
            end--;
        }
        if (end != bytes.length) {
            Files.write(path, Arrays.copyOf(bytes, end));
        }
    }

    private void closeWriterQuietly() {
        if (writer == null) {
            return;
        }
        try {
            closeWriter();
        } catch (IOException ignored) {
        } finally {
            writer = null;
        }
    }

    private void collectClassInfo(Program program) {
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            if (declaration instanceof ModuleDecl) {
                collectModuleInfo(((ModuleDecl) declaration).getModule());
            } else if (declaration instanceof StructDecl) {
                collectStructInfo(((StructDecl) declaration).getStruct());
            }
        }
        collectConstructorUsages(program);
        applyIncludedMembers();
    }

    private void collectModuleInfo(Module module) {
        if (module == null) {
            return;
        }
        String name = module.getName().getName();
        String superName = OBJECT_CLASS_NAME;
        List<String> includeNames = new ArrayList<>();
        for (Identifier include : module.getIncludes()) {
            includeNames.add(include.getName());
        }
        if (!module.getIncludes().isEmpty()) {
            superName = module.getIncludes().get(0).getName();
        }
        ClassInfo info = new ClassInfo(name, superName, includeNames, module.getMembers());
        collectMembers(info, module.getMembers());
        classes.put(name, info);
    }

    private void collectStructInfo(Struct struct) {
        if (struct == null) {
            return;
        }
        String name = struct.getName().getName();
        ClassInfo info = new ClassInfo(name, OBJECT_CLASS_NAME, new ArrayList<>(), struct.getMembers());
        collectMembers(info, struct.getMembers());
        classes.put(name, info);
    }

    private void collectMembers(ClassInfo info, List<Member> members) {
        for (Member member : members) {
            if (member instanceof VarDecl) {
                Var var = ((VarDecl) member).getVar();
                if (var != null && var.getName() != null) {
                    String descriptor = descriptorOfVar(var);
                    info.fields.put(var.getName().getName(),
                            new FieldInfo(info.name, jvmFieldName(var.getName().getName()), descriptor, member.getAccessModifier()));
                }
            } else if (member instanceof MethodDecl) {
                Method method = ((MethodDecl) member).getMethod();
                if (method != null && method.getName() != null) {
                    List<String> parameterDescriptors = new ArrayList<>();
                    for (Parameter parameter : method.getParameters()) {
                        parameterDescriptors.add(descriptorOf(parameter.getType()));
                    }
                    info.methods.add(new MethodInfo(
                            info.name,
                            method.getName().getName(),
                            descriptorOf(method.getReturnType()),
                            parameterDescriptors,
                            member.getAccessModifier(),
                            method
                    ));
                }
            }
        }
    }

    private void collectConstructorUsages(Program program) {
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            List<Member> members = null;
            if (declaration instanceof ModuleDecl) {
                Module module = ((ModuleDecl) declaration).getModule();
                members = module == null ? null : module.getMembers();
            } else if (declaration instanceof StructDecl) {
                Struct struct = ((StructDecl) declaration).getStruct();
                members = struct == null ? null : struct.getMembers();
            }
            if (members == null) {
                continue;
            }
            for (Member member : members) {
                if (member instanceof MethodDecl) {
                    Method method = ((MethodDecl) member).getMethod();
                    if (method != null) {
                        collectConstructorUsages(method.getBody());
                    }
                }
            }
        }
    }

    private void collectConstructorUsages(Statement statement) {
        if (statement == null) {
            return;
        }
        if (statement instanceof Block) {
            for (Statement child : ((Block) statement).getStatements()) {
                collectConstructorUsages(child);
            }
        } else if (statement instanceof VarDeclStmt) {
            VarDeclStmt varDeclStmt = (VarDeclStmt) statement;
            Var var = varDeclStmt.getVar();
            if (var != null) {
                collectConstructorUsages(var.getConstructorCall());
            }
            collectConstructorUsages(varDeclStmt.getInitial());
        } else if (statement instanceof AssignStmt) {
            AssignStmt assignStmt = (AssignStmt) statement;
            collectConstructorUsages(assignStmt.getLeft());
            collectConstructorUsages(assignStmt.getRight());
        } else if (statement instanceof MethodCallStmt) {
            collectConstructorUsages(((MethodCallStmt) statement).getMethodCall());
        } else if (statement instanceof ReturnStmt) {
            collectConstructorUsages(((ReturnStmt) statement).getValue());
        } else if (statement instanceof IfStmt) {
            IfStmt ifStmt = (IfStmt) statement;
            collectConstructorUsages(ifStmt.getCondition());
            collectConstructorUsages(ifStmt.getThenBranch());
            collectConstructorUsages(ifStmt.getElseBranch());
        } else if (statement instanceof ForStmt) {
            ForStmt forStmt = (ForStmt) statement;
            for (Statement initializer : forStmt.getInitializers()) {
                collectConstructorUsages(initializer);
            }
            collectConstructorUsages(forStmt.getCondition());
            for (AssignStmt updater : forStmt.getUpdaters()) {
                collectConstructorUsages(updater);
            }
            collectConstructorUsages(forStmt.getBody());
        } else if (statement instanceof WhileStmt) {
            WhileStmt whileStmt = (WhileStmt) statement;
            collectConstructorUsages(whileStmt.getCondition());
            collectConstructorUsages(whileStmt.getBody());
        } else if (statement instanceof OutputStmt) {
            collectConstructorUsages(((OutputStmt) statement).getValue());
        } else if (statement instanceof InputStmt) {
            collectConstructorUsages(((InputStmt) statement).getLoc());
        }
    }

    private void collectConstructorUsages(Expression expression) {
        if (expression == null) {
            return;
        }
        if (expression instanceof ConstructorCall) {
            ConstructorCall constructorCall = (ConstructorCall) expression;
            ClassInfo classInfo = classes.get(constructorCall.getName().getName());
            if (classInfo != null) {
                classInfo.constructorArities.add(constructorCall.getArguments().size());
            }
            for (Expression argument : constructorCall.getArguments()) {
                collectConstructorUsages(argument);
            }
        } else if (expression instanceof MethodCall) {
            MethodCall methodCall = (MethodCall) expression;
            if (methodCall.getInstance() == null) {
                ClassInfo classInfo = classes.get(methodCall.getCallee().getName());
                if (classInfo != null) {
                    classInfo.constructorArities.add(methodCall.getArguments().size());
                }
            }
            collectConstructorUsages(methodCall.getInstance());
            for (Expression argument : methodCall.getArguments()) {
                collectConstructorUsages(argument);
            }
        } else if (expression instanceof MethodCallLoc) {
            collectConstructorUsages(((MethodCallLoc) expression).getMethodCall());
        } else if (expression instanceof MemberLoc) {
            collectConstructorUsages(((MemberLoc) expression).getLoc());
        } else if (expression instanceof ThisLoc) {
            collectConstructorUsages(((ThisLoc) expression).getLoc());
        } else if (expression instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) expression;
            collectConstructorUsages(binaryExpression.getLeftOperand());
            collectConstructorUsages(binaryExpression.getRightOperand());
        } else if (expression instanceof UnaryExpression) {
            collectConstructorUsages(((UnaryExpression) expression).getExpression());
        } else if (expression instanceof UnaryOpExpr) {
            collectConstructorUsages(((UnaryOpExpr) expression).getOperand());
        } else if (expression instanceof ParanthesisExpr) {
            collectConstructorUsages(((ParanthesisExpr) expression).getExpression());
        }
    }

    private void applyIncludedMembers() {
        for (ClassInfo classInfo : classes.values()) {
            copyIncludedMembersInto(classInfo, new ArrayDeque<>());
        }
    }

    private void copyIncludedMembersInto(ClassInfo target, Deque<String> includeStack) {
        if (includeStack.contains(target.name)) {
            return;
        }
        includeStack.push(target.name);
        for (int i = 0; i < target.includeNames.size(); i++) {
            String includeName = target.includeNames.get(i);
            ClassInfo included = classes.get(includeName);
            if (included == null) {
                continue;
            }

            copyIncludedMembersInto(included, includeStack);
            if (i == 0) {
                continue;
            }
            copyAvailableMembersFrom(target, included, new ArrayDeque<>());
        }
        includeStack.pop();
    }

    private void copyAvailableMembersFrom(ClassInfo target, ClassInfo source, Deque<String> sourceStack) {
        if (sourceStack.contains(source.name)) {
            return;
        }
        sourceStack.push(source.name);
        for (Map.Entry<String, FieldInfo> entry : source.fields.entrySet()) {
            if (findField(target.name, entry.getKey()) == null) {
                target.fields.put(entry.getKey(), new FieldInfo(
                        target.name,
                        entry.getValue().name,
                        entry.getValue().descriptor,
                        entry.getValue().accessModifier
                ));
            }
        }
        for (MethodInfo methodInfo : source.methods) {
            if (findMethod(target.name, methodInfo.name, methodInfo.parameterDescriptors) == null) {
                target.methods.add(new MethodInfo(
                        target.name,
                        methodInfo.name,
                        methodInfo.returnDescriptor,
                        methodInfo.parameterDescriptors,
                        methodInfo.accessModifier,
                        methodInfo.source
                ));
            }
        }
        ClassInfo primaryInclude = classes.get(source.superName);
        if (primaryInclude != null && !OBJECT_CLASS_NAME.equals(source.superName)) {
            copyAvailableMembersFrom(target, primaryInclude, sourceStack);
        }
        sourceStack.pop();
    }

    private void writeDefaultConstructor() {
        writeRaw(".method public <init>()V\n");
        writeLimits();
        emit("aload_0");
        emit("invokespecial " + currentClass.superName + "/<init>()V");
        emit("return");
        writeRaw(".end method\n");
    }

    private void writeFieldConstructors() {
        List<FieldInfo> fields = new ArrayList<>(currentClass.fields.values());
        for (Integer count : currentClass.constructorArities) {
            if (count == null || count <= 0 || count > fields.size()) {
                continue;
            }
            StringBuilder descriptor = new StringBuilder("(");
            for (int i = 0; i < count; i++) {
                descriptor.append(fields.get(i).descriptor);
            }
            descriptor.append(")V");

            writeRaw("\n.method public <init>" + descriptor + "\n");
            writeLimits();
            emit("aload_0");
            emit("invokespecial " + currentClass.superName + "/<init>()V");

            int slot = 1;
            for (int i = 0; i < count; i++) {
                FieldInfo field = fields.get(i);
                emit("aload_0");
                emit(loadLocalInstruction(field.descriptor, slot, false));
                emit("putfield " + field.owner + "/" + field.name + " " + field.descriptor);
                slot += slotSize(field.descriptor);
            }

            emit("return");
            writeRaw(".end method\n");
        }
    }

    private void writeJvmMainWrapper() throws IOException {
        MethodInfo languageMain = findMethodByNameAndCount(currentClass.name, "main", 0);
        if (languageMain == null) {
            return;
        }
        writeRaw("\n");
        writeMainMethodHeader();
        emit("new " + currentClass.name);
        emit("dup");
        emit("invokespecial " + currentClass.name + "/<init>()V");
        emit("invokevirtual " + currentClass.name + "/main" + languageMain.descriptor());
        discardTopValue(languageMain.returnDescriptor);
        writeMainMethodFooter();
    }

    @Override
    public String visit(MethodDecl methodDecl) {
        if (methodDecl.getMethod() != null) {
            MethodInfo methodInfo = findMethodInfoForNode(methodDecl.getMethod());
            if (methodInfo != null) {
                emitMethod(methodInfo);
            }
        }
        return null;
    }

    @Override
    public String visit(Method method) {
        MethodInfo methodInfo = findMethodInfoForNode(method);
        if (methodInfo == null) {
            throw generationError("Unknown method " + method.getName().getName());
        }
        emitMethod(methodInfo);
        return null;
    }

    private void emitMethod(MethodInfo methodInfo) {
        MethodInfo previousMethod = currentMethod;
        currentMethod = methodInfo;
        Method method = methodInfo.source;

        slots.clear();
        nextSlot = 1;
        for (Parameter parameter : method.getParameters()) {
            slotOf(parameter.getName().getName(), descriptorOf(parameter.getType()), true);
        }

        writeRaw(".method " + accessFlag(methodInfo.accessModifier) + " "
                + methodInfo.name + methodInfo.descriptor() + "\n");
        writeLimits();
        method.getBody().accept(this);
        if (statementFallsThrough(method.getBody())) {
            emitDefaultReturn(methodInfo.returnDescriptor);
        }
        writeRaw(".end method\n");

        slots.clear();
        currentMethod = previousMethod;
    }

    @Override
    public String visit(Parameter parameter) {
        return descriptorOf(parameter.getType());
    }

    @Override
    public String visit(VarDecl varDecl) {
        return varDecl.getVar() == null ? null : descriptorOfVar(varDecl.getVar());
    }

    @Override
    public String visit(Var var) {
        return descriptorOfVar(var);
    }

    @Override
    public String visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
            if (!statementFallsThrough(statement)) {
                break;
            }
        }
        return null;
    }

    @Override
    public String visit(VarDeclStmt varDeclStmt) {
        Var var = varDeclStmt.getVar();
        String descriptor = descriptorOfVar(var);
        int slot = slotOf(var.getName().getName(), descriptor);

        if (varDeclStmt.getInitial() != null) {
            String actualDescriptor = varDeclStmt.getInitial().accept(this);
            emitCast(actualDescriptor, descriptor);
        } else if (var.getConstructorCall() != null) {
            String actualDescriptor = var.getConstructorCall().accept(this);
            emitCast(actualDescriptor, descriptor);
        } else {
            emitDefaultValue(descriptor);
        }

        emit(storeLocalInstruction(descriptor, slot, false));
        return null;
    }

    @Override
    public String visit(AssignStmt assignStmt) {
        emitAssignment(assignStmt.getLeft(), assignStmt.getRight());
        return null;
    }

    @Override
    public String visit(MethodCallStmt methodCallStmt) {
        String returnDescriptor = methodCallStmt.getMethodCall().accept(this);
        discardTopValue(returnDescriptor);
        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        if (returnStmt.getValue() == null) {
            if ("V".equals(currentMethod.returnDescriptor)) {
                emit("return");
            } else {
                emitDefaultValue(currentMethod.returnDescriptor);
                emit(returnOpcode(currentMethod.returnDescriptor));
            }
            return null;
        }

        String actualDescriptor = returnStmt.getValue().accept(this);
        emitCast(actualDescriptor, currentMethod.returnDescriptor);
        emit(returnOpcode(currentMethod.returnDescriptor));
        return null;
    }

    @Override
    public String visit(IfStmt ifStmt) {
        String endLabel = newLabel("if_end");

        ifStmt.getCondition().accept(this);

        if (ifStmt.getElseBranch() == null) {
            emit("ifeq " + endLabel);
            ifStmt.getThenBranch().accept(this);
            emitLabel(endLabel);
            return null;
        }

        String elseLabel = newLabel("if_else");
        boolean thenFallsThrough = statementFallsThrough(ifStmt.getThenBranch());
        boolean elseFallsThrough = statementFallsThrough(ifStmt.getElseBranch());
        boolean needsEndLabel = thenFallsThrough || elseFallsThrough;

        emit("ifeq " + elseLabel);
        ifStmt.getThenBranch().accept(this);
        if (thenFallsThrough) {
            emit("goto " + endLabel);
        }
        emitLabel(elseLabel);
        ifStmt.getElseBranch().accept(this);
        if (needsEndLabel) {
            emitLabel(endLabel);
        }
        return null;
    }

    @Override
    public String visit(ForStmt forStmt) {
        for (Statement initializer : forStmt.getInitializers()) {
            initializer.accept(this);
        }

        String conditionLabel = newLabel("for_condition");
        String updateLabel = newLabel("for_update");
        String endLabel = newLabel("for_end");

        emitLabel(conditionLabel);
        if (forStmt.getCondition() != null) {
            forStmt.getCondition().accept(this);
            emit("ifeq " + endLabel);
        }

        loopLabels.push(new LoopLabels(endLabel, updateLabel));
        if (forStmt.getBody() != null) {
            forStmt.getBody().accept(this);
        }
        loopLabels.pop();

        emitLabel(updateLabel);
        for (AssignStmt updater : forStmt.getUpdaters()) {
            updater.accept(this);
        }
        emit("goto " + conditionLabel);
        emitLabel(endLabel);
        return null;
    }

    @Override
    public String visit(WhileStmt whileStmt) {
        String conditionLabel = newLabel("while_condition");
        String endLabel = newLabel("while_end");

        emitLabel(conditionLabel);
        whileStmt.getCondition().accept(this);
        emit("ifeq " + endLabel);

        loopLabels.push(new LoopLabels(endLabel, conditionLabel));
        whileStmt.getBody().accept(this);
        loopLabels.pop();

        emit("goto " + conditionLabel);
        emitLabel(endLabel);
        return null;
    }

    @Override
    public String visit(BreakJump breakJump) {
        if (!loopLabels.isEmpty()) {
            emit("goto " + loopLabels.peek().breakLabel);
        }
        return null;
    }

    @Override
    public String visit(ContinueJump continueJump) {
        if (!loopLabels.isEmpty()) {
            emit("goto " + loopLabels.peek().continueLabel);
        }
        return null;
    }

    @Override
    public String visit(InputStmt inputStmt) {
        return null;
    }

    @Override
    public String visit(OutputStmt outputStmt) {
        emit("getstatic java/lang/System/out Ljava/io/PrintStream;");
        String valueDescriptor = outputStmt.getValue().accept(this);
        emit("invokevirtual java/io/PrintStream/println(" + printlnDescriptor(valueDescriptor) + ")V");
        return null;
    }

    @Override
    public String visit(MethodCall methodCall) {
        if (methodCall.getInstance() == null && classes.containsKey(methodCall.getCallee().getName())) {
            return emitConstructorCall(methodCall.getCallee().getName(), methodCall.getArguments());
        }

        String receiverDescriptor;
        String receiverOwner;
        if (methodCall.getInstance() == null) {
            emit("aload_0");
            receiverOwner = currentClass.name;
            receiverDescriptor = classDescriptor(receiverOwner);
        } else {
            receiverDescriptor = methodCall.getInstance().accept(this);
            receiverOwner = classNameFromDescriptor(receiverDescriptor);
        }

        List<String> inferredArguments = new ArrayList<>();
        for (Expression argument : methodCall.getArguments()) {
            inferredArguments.add(inferExpressionDescriptor(argument));
        }

        MethodInfo methodInfo = findMethod(receiverOwner, methodCall.getCallee().getName(), inferredArguments);
        if (methodInfo == null) {
            throw generationError("Unknown method " + receiverOwner + "." + methodCall.getCallee().getName());
        }

        for (int i = 0; i < methodCall.getArguments().size(); i++) {
            String actualDescriptor = methodCall.getArguments().get(i).accept(this);
            emitCast(actualDescriptor, methodInfo.parameterDescriptors.get(i));
        }

        String invokeOpcode = methodInfo.accessModifier == AccessModifier.PRIVATE ? "invokespecial" : "invokevirtual";
        emit(invokeOpcode + " " + receiverOwner + "/" + methodCall.getCallee().getName() + methodInfo.descriptor());
        return methodInfo.returnDescriptor;
    }

    @Override
    public String visit(ConstructorCall constructorCall) {
        return emitConstructorCall(constructorCall.getName().getName(), constructorCall.getArguments());
    }

    @Override
    public String visit(SimpleLoc simpleLoc) {
        return emitLoadLocation(simpleLoc);
    }

    @Override
    public String visit(MemberLoc memberLoc) {
        return emitLoadLocation(memberLoc);
    }

    @Override
    public String visit(ThisLoc thisLoc) {
        return emitLoadLocation(thisLoc);
    }

    @Override
    public String visit(MethodCallLoc methodCallLoc) {
        return methodCallLoc.getMethodCall().accept(this);
    }

    @Override
    public String visit(ParanthesisExpr paranthesisExpr) {
        return paranthesisExpr.getExpression().accept(this);
    }

    @Override
    public String visit(UnaryOpExpr unaryOpExpr) {
        String operandDescriptor = unaryOpExpr.getOperand().accept(this);
        if (unaryOpExpr.getOperator() == UnaryOpExpr.Operator.MINUS) {
            emitNegation(operandDescriptor);
            return numericStackDescriptor(operandDescriptor);
        }
        emitBooleanNot();
        return "Z";
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        String operandDescriptor = unaryExpression.getExpression().accept(this);
        if (unaryExpression.getOperand() == UnaryOperator.MINUS) {
            emitNegation(operandDescriptor);
            return numericStackDescriptor(operandDescriptor);
        }
        emitBooleanNot();
        return "Z";
    }

    @Override
    public String visit(BinaryExpression binaryExpression) {
        BinaryOperator operator = binaryExpression.getOperator();
        if (operator == BinaryOperator.AND || operator == BinaryOperator.OR) {
            binaryExpression.getLeftOperand().accept(this);
            binaryExpression.getRightOperand().accept(this);
            emit(operator == BinaryOperator.AND ? "iand" : "ior");
            return "Z";
        }
        if (isComparison(operator)) {
            return emitComparison(binaryExpression);
        }
        return emitArithmetic(binaryExpression);
    }

    @Override
    public String visit(IntLiteral intLiteral) {
        emit("ldc " + intLiteral.getValue());
        return "I";
    }

    @Override
    public String visit(FloatLiteral floatLiteral) {
        emit("ldc " + Float.toString((float) floatLiteral.getValue()));
        return "F";
    }

    @Override
    public String visit(DoubleLiteral doubleLiteral) {
        emit("ldc2_w " + Double.toString(doubleLiteral.getValue()));
        return "D";
    }

    @Override
    public String visit(CharLiteral charLiteral) {
        emit("ldc " + (int) charLiteral.getValue());
        return "C";
    }

    @Override
    public String visit(BoolLiteral boolLiteral) {
        emit("ldc " + (boolLiteral.getValue() ? 1 : 0));
        return "Z";
    }

    @Override
    public String visit(ConstantExpression constantExpression) {
        Object value = constantExpression.getValue();
        if (value instanceof Integer) {
            emit("ldc " + value);
            return "I";
        }
        if (value instanceof Float) {
            emit("ldc " + Float.toString((Float) value));
            return "F";
        }
        if (value instanceof Double) {
            emit("ldc2_w " + Double.toString((Double) value));
            return "D";
        }
        if (value instanceof Character) {
            emit("ldc " + (int) ((Character) value));
            return "C";
        }
        if (value instanceof Boolean) {
            emit("ldc " + ((Boolean) value ? 1 : 0));
            return "Z";
        }
        throw generationError("Unsupported constant literal");
    }

    @Override
    public String visit(Identifier identifier) {
        return identifier.getName();
    }

    @Override
    public String visit(PrimitiveType primitiveType) {
        return descriptorOf(primitiveType);
    }

    @Override
    public String visit(UserDefinedType userDefinedType) {
        return descriptorOf(userDefinedType);
    }

    private void writeLimits() {
        writeRaw("    .limit stack 128\n");
        writeRaw("    .limit locals 128\n");
    }

    private void writeRaw(String text) {
        try {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write Jasmin output", e);
        }
    }

    private void emit(String instruction) {
        writeRaw("    " + instruction + "\n");
    }

    private void emitLabel(String label) {
        writeRaw(label + ":\n");
    }

    private String newLabel(String prefix) {
        return prefix + "_" + labelCounter++;
    }

    private int slotOf(String name, String descriptor) {
        return slotOf(name, descriptor, false);
    }

    private int slotOf(String name, String descriptor, boolean parameter) {
        SlotInfo existingSlot = slots.get(name);
        if (existingSlot != null) {
            return existingSlot.index;
        }
        int index = nextSlot;
        slots.put(name, new SlotInfo(index, descriptor, parameter));
        nextSlot += slotSize(descriptor);
        return index;
    }

    private void emitAssignment(Location location, Expression value) {
        LocationTarget target = emitStoreTarget(location);
        String actualDescriptor = value.accept(this);
        emitCast(actualDescriptor, target.descriptor);

        if (target.local) {
            emit(storeLocalInstruction(target.descriptor, target.slot, target.parameterLocal));
        } else {
            emit("putfield " + target.owner + "/" + target.name + " " + target.descriptor);
        }
    }

    private String emitLoadLocation(Location location) {
        if (location instanceof SimpleLoc) {
            return emitLoadSimpleLocation((SimpleLoc) location);
        }
        if (location instanceof ThisLoc) {
            return emitLoadThisLocation((ThisLoc) location);
        }
        if (location instanceof MemberLoc) {
            return emitLoadMemberLocation((MemberLoc) location);
        }
        if (location instanceof MethodCallLoc) {
            return ((MethodCallLoc) location).getMethodCall().accept(this);
        }
        throw generationError("Unsupported location");
    }

    private String emitLoadSimpleLocation(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        SlotInfo slot = slots.get(name);
        if (slot != null) {
            emit(loadLocalInstruction(slot));
            return slot.descriptor;
        }

        FieldInfo field = findField(currentClass.name, name);
        if (field == null) {
            throw generationError("Unknown variable or field " + name);
        }
        emit("aload_0");
        emit("getfield " + field.owner + "/" + field.name + " " + field.descriptor);
        return field.descriptor;
    }

    private String emitLoadThisLocation(ThisLoc thisLoc) {
        emit("aload_0");
        if (thisLoc.getLoc() == null) {
            return classDescriptor(currentClass.name);
        }
        return emitLoadFieldChain(currentClass.name, thisLoc.getLoc());
    }

    private String emitLoadMemberLocation(MemberLoc memberLoc) {
        String rootDescriptor = emitLoadRoot(memberLoc.getMemberName().getName());
        return emitLoadFieldChain(classNameFromDescriptor(rootDescriptor), memberLoc.getLoc());
    }

    private String emitLoadRoot(String name) {
        SlotInfo slot = slots.get(name);
        if (slot != null) {
            emit(loadLocalInstruction(slot));
            return slot.descriptor;
        }

        FieldInfo field = findField(currentClass.name, name);
        if (field == null) {
            throw generationError("Unknown member root " + name);
        }
        emit("aload_0");
        emit("getfield " + field.owner + "/" + field.name + " " + field.descriptor);
        return field.descriptor;
    }

    private String emitLoadFieldChain(String owner, Location location) {
        if (location instanceof SimpleLoc) {
            FieldInfo field = requireField(owner, ((SimpleLoc) location).getId().getName());
            emit("getfield " + field.owner + "/" + field.name + " " + field.descriptor);
            return field.descriptor;
        }
        if (location instanceof MemberLoc) {
            MemberLoc memberLoc = (MemberLoc) location;
            FieldInfo field = requireField(owner, memberLoc.getMemberName().getName());
            emit("getfield " + field.owner + "/" + field.name + " " + field.descriptor);
            return emitLoadFieldChain(classNameFromDescriptor(field.descriptor), memberLoc.getLoc());
        }
        if (location instanceof ThisLoc) {
            ThisLoc thisLoc = (ThisLoc) location;
            if (thisLoc.getLoc() == null) {
                return classDescriptor(owner);
            }
            return emitLoadFieldChain(owner, thisLoc.getLoc());
        }
        throw generationError("Unsupported field chain");
    }

    private LocationTarget emitStoreTarget(Location location) {
        if (location instanceof SimpleLoc) {
            String name = ((SimpleLoc) location).getId().getName();
            SlotInfo slot = slots.get(name);
            if (slot != null) {
                return new LocationTarget(slot.index, slot.descriptor, slot.parameter);
            }
            FieldInfo field = requireField(currentClass.name, name);
            emit("aload_0");
            return new LocationTarget(field.owner, field.name, field.descriptor);
        }
        if (location instanceof ThisLoc) {
            ThisLoc thisLoc = (ThisLoc) location;
            if (thisLoc.getLoc() == null) {
                throw generationError("Cannot assign to this");
            }
            emit("aload_0");
            return emitStoreFieldChain(currentClass.name, thisLoc.getLoc());
        }
        if (location instanceof MemberLoc) {
            MemberLoc memberLoc = (MemberLoc) location;
            String rootDescriptor = emitLoadRoot(memberLoc.getMemberName().getName());
            return emitStoreFieldChain(classNameFromDescriptor(rootDescriptor), memberLoc.getLoc());
        }
        throw generationError("Unsupported assignment target");
    }

    private LocationTarget emitStoreFieldChain(String owner, Location location) {
        if (location instanceof SimpleLoc) {
            FieldInfo field = requireField(owner, ((SimpleLoc) location).getId().getName());
            return new LocationTarget(field.owner, field.name, field.descriptor);
        }
        if (location instanceof MemberLoc) {
            MemberLoc memberLoc = (MemberLoc) location;
            FieldInfo field = requireField(owner, memberLoc.getMemberName().getName());
            emit("getfield " + field.owner + "/" + field.name + " " + field.descriptor);
            return emitStoreFieldChain(classNameFromDescriptor(field.descriptor), memberLoc.getLoc());
        }
        if (location instanceof ThisLoc) {
            ThisLoc thisLoc = (ThisLoc) location;
            if (thisLoc.getLoc() == null) {
                throw generationError("Cannot assign to this");
            }
            return emitStoreFieldChain(owner, thisLoc.getLoc());
        }
        throw generationError("Unsupported assignment field chain");
    }

    private String emitArithmetic(BinaryExpression binaryExpression) {
        String leftDescriptor = inferExpressionDescriptor(binaryExpression.getLeftOperand());
        String rightDescriptor = inferExpressionDescriptor(binaryExpression.getRightOperand());
        String resultDescriptor = arithmeticResultDescriptor(leftDescriptor, rightDescriptor);

        String actualLeft = binaryExpression.getLeftOperand().accept(this);
        emitCast(actualLeft, resultDescriptor);
        String actualRight = binaryExpression.getRightOperand().accept(this);
        emitCast(actualRight, resultDescriptor);

        switch (binaryExpression.getOperator()) {
            case ADDITION:
                emit(arithmeticPrefix(resultDescriptor) + "add");
                break;
            case SUBTRACTION:
                emit(arithmeticPrefix(resultDescriptor) + "sub");
                break;
            case MULTIPLICATION:
                emit(arithmeticPrefix(resultDescriptor) + "mul");
                break;
            case DIVISION:
                emit(arithmeticPrefix(resultDescriptor) + "div");
                break;
            default:
                throw generationError("Unsupported arithmetic operator");
        }
        return resultDescriptor;
    }

    private String emitComparison(BinaryExpression binaryExpression) {
        String trueLabel = newLabel("cmp_true");
        String endLabel = newLabel("cmp_end");
        String leftDescriptor = inferExpressionDescriptor(binaryExpression.getLeftOperand());
        String rightDescriptor = inferExpressionDescriptor(binaryExpression.getRightOperand());

        if (isReference(leftDescriptor) || isReference(rightDescriptor)) {
            binaryExpression.getLeftOperand().accept(this);
            binaryExpression.getRightOperand().accept(this);
            emit(referenceComparisonOpcode(binaryExpression.getOperator()) + " " + trueLabel);
        } else {
            String compareDescriptor = arithmeticResultDescriptor(leftDescriptor, rightDescriptor);
            String actualLeft = binaryExpression.getLeftOperand().accept(this);
            emitCast(actualLeft, compareDescriptor);
            String actualRight = binaryExpression.getRightOperand().accept(this);
            emitCast(actualRight, compareDescriptor);
            if ("D".equals(compareDescriptor)) {
                emit("d" + floatingCompareInstruction(binaryExpression.getOperator()));
                emit(singleValueComparisonOpcode(binaryExpression.getOperator()) + " " + trueLabel);
            } else if ("F".equals(compareDescriptor)) {
                emit("f" + floatingCompareInstruction(binaryExpression.getOperator()));
                emit(singleValueComparisonOpcode(binaryExpression.getOperator()) + " " + trueLabel);
            } else {
                emit(integerComparisonOpcode(binaryExpression.getOperator()) + " " + trueLabel);
            }
        }

        emit("ldc 0");
        emit("goto " + endLabel);
        emitLabel(trueLabel);
        emit("ldc 1");
        emitLabel(endLabel);
        return "Z";
    }

    private void emitNegation(String descriptor) {
        String numericDescriptor = numericStackDescriptor(descriptor);
        if ("D".equals(numericDescriptor)) {
            emit("dneg");
        } else if ("F".equals(numericDescriptor)) {
            emit("fneg");
        } else {
            emit("ineg");
        }
    }

    private void emitBooleanNot() {
        emit("ldc 1");
        emit("ixor");
    }

    private void emitDefaultValue(String descriptor) {
        if ("D".equals(descriptor)) {
            emit("ldc2_w 0.0");
        } else if ("F".equals(descriptor)) {
            emit("ldc 0.0");
        } else if (isReference(descriptor)) {
            emit("aconst_null");
        } else {
            emit("ldc 0");
        }
    }

    private void emitDefaultReturn(String descriptor) {
        if ("V".equals(descriptor)) {
            emit("return");
            return;
        }
        emitDefaultValue(descriptor);
        emit(returnOpcode(descriptor));
    }

    private void emitCast(String fromDescriptor, String toDescriptor) {
        if (fromDescriptor == null || toDescriptor == null || fromDescriptor.equals(toDescriptor)) {
            return;
        }
        if (isIntLike(fromDescriptor) && isIntLike(toDescriptor)) {
            return;
        }
        if (isIntLike(fromDescriptor) && "F".equals(toDescriptor)) {
            emit("i2f");
        } else if (isIntLike(fromDescriptor) && "D".equals(toDescriptor)) {
            emit("i2d");
        } else if ("F".equals(fromDescriptor) && "D".equals(toDescriptor)) {
            emit("f2d");
        } else if ("D".equals(fromDescriptor) && "F".equals(toDescriptor)) {
            emit("d2f");
        } else if ("D".equals(fromDescriptor) && isIntLike(toDescriptor)) {
            emit("d2i");
        } else if ("F".equals(fromDescriptor) && isIntLike(toDescriptor)) {
            emit("f2i");
        }
    }

    private void discardTopValue(String descriptor) {
        if (descriptor == null || "V".equals(descriptor)) {
            return;
        }
        emit("D".equals(descriptor) ? "pop2" : "pop");
    }

    private String emitConstructorCall(String className, List<Expression> arguments) {
        List<String> parameterDescriptors = constructorParameterDescriptors(className, arguments);

        emit("new " + className);
        emit("dup");
        for (int i = 0; i < arguments.size(); i++) {
            String actualDescriptor = arguments.get(i).accept(this);
            emitCast(actualDescriptor, parameterDescriptors.get(i));
        }
        emit("invokespecial " + className + "/<init>(" + joinDescriptors(parameterDescriptors) + ")V");
        return classDescriptor(className);
    }

    private String inferExpressionDescriptor(Expression expression) {
        if (expression instanceof ConstantExpression) {
            return descriptorOfConstant(((ConstantExpression) expression).getValue());
        }
        if (expression instanceof IntLiteral) {
            return "I";
        }
        if (expression instanceof FloatLiteral) {
            return "F";
        }
        if (expression instanceof DoubleLiteral) {
            return "D";
        }
        if (expression instanceof CharLiteral) {
            return "C";
        }
        if (expression instanceof BoolLiteral) {
            return "Z";
        }
        if (expression instanceof SimpleLoc) {
            return descriptorOfSimpleLocation((SimpleLoc) expression);
        }
        if (expression instanceof ThisLoc) {
            return descriptorOfThisLocation((ThisLoc) expression);
        }
        if (expression instanceof MemberLoc) {
            return descriptorOfMemberLocation((MemberLoc) expression);
        }
        if (expression instanceof ConstructorCall) {
            return classDescriptor(((ConstructorCall) expression).getName().getName());
        }
        if (expression instanceof MethodCall) {
            return descriptorOfMethodCall((MethodCall) expression);
        }
        if (expression instanceof MethodCallLoc) {
            return descriptorOfMethodCall(((MethodCallLoc) expression).getMethodCall());
        }
        if (expression instanceof ParanthesisExpr) {
            return inferExpressionDescriptor(((ParanthesisExpr) expression).getExpression());
        }
        if (expression instanceof UnaryExpression) {
            UnaryExpression unaryExpression = (UnaryExpression) expression;
            return unaryExpression.getOperand() == UnaryOperator.NOT
                    ? "Z"
                    : numericStackDescriptor(inferExpressionDescriptor(unaryExpression.getExpression()));
        }
        if (expression instanceof UnaryOpExpr) {
            UnaryOpExpr unaryOpExpr = (UnaryOpExpr) expression;
            return unaryOpExpr.getOperator() == UnaryOpExpr.Operator.NOT
                    ? "Z"
                    : numericStackDescriptor(inferExpressionDescriptor(unaryOpExpr.getOperand()));
        }
        if (expression instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) expression;
            if (isComparison(binaryExpression.getOperator())
                    || binaryExpression.getOperator() == BinaryOperator.AND
                    || binaryExpression.getOperator() == BinaryOperator.OR) {
                return "Z";
            }
            return arithmeticResultDescriptor(
                    inferExpressionDescriptor(binaryExpression.getLeftOperand()),
                    inferExpressionDescriptor(binaryExpression.getRightOperand())
            );
        }
        throw generationError("Cannot infer expression type");
    }

    private String descriptorOfSimpleLocation(SimpleLoc simpleLoc) {
        SlotInfo slot = slots.get(simpleLoc.getId().getName());
        if (slot != null) {
            return slot.descriptor;
        }
        return requireField(currentClass.name, simpleLoc.getId().getName()).descriptor;
    }

    private String descriptorOfThisLocation(ThisLoc thisLoc) {
        if (thisLoc.getLoc() == null) {
            return classDescriptor(currentClass.name);
        }
        return descriptorOfFieldChain(currentClass.name, thisLoc.getLoc());
    }

    private String descriptorOfMemberLocation(MemberLoc memberLoc) {
        String rootDescriptor = descriptorOfRoot(memberLoc.getMemberName().getName());
        return descriptorOfFieldChain(classNameFromDescriptor(rootDescriptor), memberLoc.getLoc());
    }

    private String descriptorOfRoot(String name) {
        SlotInfo slot = slots.get(name);
        if (slot != null) {
            return slot.descriptor;
        }
        return requireField(currentClass.name, name).descriptor;
    }

    private String descriptorOfFieldChain(String owner, Location location) {
        if (location instanceof SimpleLoc) {
            return requireField(owner, ((SimpleLoc) location).getId().getName()).descriptor;
        }
        if (location instanceof MemberLoc) {
            MemberLoc memberLoc = (MemberLoc) location;
            FieldInfo field = requireField(owner, memberLoc.getMemberName().getName());
            return descriptorOfFieldChain(classNameFromDescriptor(field.descriptor), memberLoc.getLoc());
        }
        if (location instanceof ThisLoc) {
            ThisLoc thisLoc = (ThisLoc) location;
            if (thisLoc.getLoc() == null) {
                return classDescriptor(owner);
            }
            return descriptorOfFieldChain(owner, thisLoc.getLoc());
        }
        if (location instanceof MethodCallLoc) {
            return descriptorOfMethodCall(((MethodCallLoc) location).getMethodCall());
        }
        throw generationError("Cannot infer field chain type");
    }

    private String descriptorOfMethodCall(MethodCall methodCall) {
        if (methodCall.getInstance() == null && classes.containsKey(methodCall.getCallee().getName())) {
            return classDescriptor(methodCall.getCallee().getName());
        }

        String receiverOwner;
        if (methodCall.getInstance() == null) {
            receiverOwner = currentClass.name;
        } else {
            receiverOwner = classNameFromDescriptor(inferExpressionDescriptor(methodCall.getInstance()));
        }

        List<String> argumentDescriptors = new ArrayList<>();
        for (Expression argument : methodCall.getArguments()) {
            argumentDescriptors.add(inferExpressionDescriptor(argument));
        }

        MethodInfo methodInfo = findMethod(receiverOwner, methodCall.getCallee().getName(), argumentDescriptors);
        if (methodInfo == null) {
            throw generationError("Unknown method " + receiverOwner + "." + methodCall.getCallee().getName());
        }
        return methodInfo.returnDescriptor;
    }

    private String descriptorOfVar(Var var) {
        if (var.getType() != null) {
            return descriptorOf(var.getType());
        }
        if (var.getConstructorCall() != null) {
            return classDescriptor(var.getConstructorCall().getName().getName());
        }
        throw generationError("Variable has neither type nor constructor");
    }

    private String descriptorOf(Type type) {
        if (type instanceof PrimitiveType) {
            PrimitiveType.Primitive primitive = ((PrimitiveType) type).getPrimitive();
            switch (primitive) {
                case INT:
                    return "I";
                case FLOAT:
                    return "F";
                case DOUBLE:
                    return "D";
                case CHAR:
                    return "C";
                case BOOL:
                    return "Z";
                case VOID:
                    return "V";
                default:
                    throw generationError("Unsupported primitive type");
            }
        }
        if (type instanceof UserDefinedType) {
            return classDescriptor(((UserDefinedType) type).getId().getName());
        }
        throw generationError("Unsupported type");
    }

    private String descriptorOfConstant(Object value) {
        if (value instanceof Integer) {
            return "I";
        }
        if (value instanceof Float) {
            return "F";
        }
        if (value instanceof Double) {
            return "D";
        }
        if (value instanceof Character) {
            return "C";
        }
        if (value instanceof Boolean) {
            return "Z";
        }
        throw generationError("Unsupported constant type");
    }

    private List<String> constructorParameterDescriptors(String className, List<Expression> arguments) {
        List<String> parameterDescriptors = new ArrayList<>();
        ClassInfo classInfo = classes.get(className);
        if (classInfo != null && arguments.size() <= classInfo.fields.size()) {
            List<FieldInfo> fields = new ArrayList<>(classInfo.fields.values());
            for (int i = 0; i < arguments.size(); i++) {
                parameterDescriptors.add(fields.get(i).descriptor);
            }
            return parameterDescriptors;
        }
        for (Expression argument : arguments) {
            parameterDescriptors.add(inferExpressionDescriptor(argument));
        }
        return parameterDescriptors;
    }

    private MethodInfo findMethodInfoForNode(Method method) {
        for (MethodInfo methodInfo : currentClass.methods) {
            if (methodInfo.source == method) {
                return methodInfo;
            }
        }
        return null;
    }

    private MethodInfo findMethod(String owner, String name, List<String> parameterDescriptors) {
        ClassInfo classInfo = classes.get(owner);
        if (classInfo == null) {
            return null;
        }

        MethodInfo arityMatch = null;
        for (MethodInfo methodInfo : classInfo.methods) {
            if (!methodInfo.name.equals(name)) {
                continue;
            }
            if (sameDescriptors(methodInfo.parameterDescriptors, parameterDescriptors)) {
                return methodInfo;
            }
            if (methodInfo.parameterDescriptors.size() == parameterDescriptors.size() && arityMatch == null) {
                arityMatch = methodInfo;
            }
        }
        if (arityMatch != null) {
            return arityMatch;
        }
        if (!OBJECT_CLASS_NAME.equals(classInfo.superName)) {
            return findMethod(classInfo.superName, name, parameterDescriptors);
        }
        return null;
    }

    private MethodInfo findMethodByNameAndCount(String owner, String name, int count) {
        ClassInfo classInfo = classes.get(owner);
        if (classInfo == null) {
            return null;
        }
        for (MethodInfo methodInfo : classInfo.methods) {
            if (methodInfo.name.equals(name) && methodInfo.parameterDescriptors.size() == count) {
                return methodInfo;
            }
        }
        if (!OBJECT_CLASS_NAME.equals(classInfo.superName)) {
            return findMethodByNameAndCount(classInfo.superName, name, count);
        }
        return null;
    }

    private boolean hasMethod(ClassInfo classInfo, String name, List<String> parameterDescriptors) {
        for (MethodInfo methodInfo : classInfo.methods) {
            if (methodInfo.name.equals(name) && sameDescriptors(methodInfo.parameterDescriptors, parameterDescriptors)) {
                return true;
            }
        }
        return false;
    }

    private FieldInfo findField(String owner, String name) {
        ClassInfo classInfo = classes.get(owner);
        if (classInfo == null) {
            return null;
        }
        FieldInfo field = classInfo.fields.get(name);
        if (field != null) {
            return field;
        }
        if (!OBJECT_CLASS_NAME.equals(classInfo.superName)) {
            return findField(classInfo.superName, name);
        }
        return null;
    }

    private FieldInfo requireField(String owner, String name) {
        FieldInfo field = findField(owner, name);
        if (field == null) {
            throw generationError("Unknown field " + owner + "." + name);
        }
        return field;
    }

    private boolean sameDescriptors(List<String> expected, List<String> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            String expectedDescriptor = expected.get(i);
            String actualDescriptor = actual.get(i);
            if (!expectedDescriptor.equals(actualDescriptor)
                    && !(isIntLike(expectedDescriptor) && isIntLike(actualDescriptor))) {
                return false;
            }
        }
        return true;
    }

    private String accessFlag(AccessModifier accessModifier) {
        return accessModifier == AccessModifier.PRIVATE ? "private" : "public";
    }

    private String jvmFieldName(String sourceName) {
        if ("field".equals(sourceName) || "method".equals(sourceName)
                || "class".equals(sourceName) || "super".equals(sourceName)
                || "limit".equals(sourceName) || "end".equals(sourceName)) {
            return "sl$" + sourceName;
        }
        return sourceName;
    }

    private String classDescriptor(String className) {
        return "L" + className + ";";
    }

    private String classNameFromDescriptor(String descriptor) {
        if (descriptor == null || !descriptor.startsWith("L") || !descriptor.endsWith(";")) {
            throw generationError("Expected object descriptor but found " + descriptor);
        }
        return descriptor.substring(1, descriptor.length() - 1);
    }

    private String joinDescriptors(List<String> descriptors) {
        StringBuilder joined = new StringBuilder();
        for (String descriptor : descriptors) {
            joined.append(descriptor);
        }
        return joined.toString();
    }

    private String loadOpcode(String descriptor) {
        if ("D".equals(descriptor)) {
            return "dload";
        }
        if ("F".equals(descriptor)) {
            return "fload";
        }
        if (isReference(descriptor)) {
            return "aload";
        }
        return "iload";
    }

    private String loadLocalInstruction(SlotInfo slot) {
        return loadLocalInstruction(slot.descriptor, slot.index, slot.parameter);
    }

    private String loadLocalInstruction(String descriptor, int slot, boolean compact) {
        String opcode = loadOpcode(descriptor);
        if (compact && slot >= 0 && slot <= 3) {
            return opcode + "_" + slot;
        }
        return opcode + " " + slot;
    }

    private String storeOpcode(String descriptor) {
        if ("D".equals(descriptor)) {
            return "dstore";
        }
        if ("F".equals(descriptor)) {
            return "fstore";
        }
        if (isReference(descriptor)) {
            return "astore";
        }
        return "istore";
    }

    private String storeLocalInstruction(String descriptor, int slot, boolean compact) {
        String opcode = storeOpcode(descriptor);
        if (compact && slot >= 0 && slot <= 3) {
            return opcode + "_" + slot;
        }
        return opcode + " " + slot;
    }

    private String returnOpcode(String descriptor) {
        if ("D".equals(descriptor)) {
            return "dreturn";
        }
        if ("F".equals(descriptor)) {
            return "freturn";
        }
        if (isReference(descriptor)) {
            return "areturn";
        }
        if ("V".equals(descriptor)) {
            return "return";
        }
        return "ireturn";
    }

    private String printlnDescriptor(String descriptor) {
        if (isReference(descriptor)) {
            return "Ljava/lang/Object;";
        }
        return descriptor;
    }

    private int slotSize(String descriptor) {
        return "D".equals(descriptor) ? 2 : 1;
    }

    private String arithmeticPrefix(String descriptor) {
        if ("D".equals(descriptor)) {
            return "d";
        }
        if ("F".equals(descriptor)) {
            return "f";
        }
        return "i";
    }

    private String numericStackDescriptor(String descriptor) {
        return isIntLike(descriptor) ? "I" : descriptor;
    }

    private String arithmeticResultDescriptor(String leftDescriptor, String rightDescriptor) {
        if ("D".equals(leftDescriptor) || "D".equals(rightDescriptor)) {
            return "D";
        }
        if ("F".equals(leftDescriptor) || "F".equals(rightDescriptor)) {
            return "F";
        }
        return "I";
    }

    private boolean isReference(String descriptor) {
        return descriptor != null && descriptor.startsWith("L") && descriptor.endsWith(";");
    }

    private boolean isIntLike(String descriptor) {
        return "I".equals(descriptor) || "Z".equals(descriptor) || "C".equals(descriptor);
    }

    private boolean isComparison(BinaryOperator operator) {
        return operator == BinaryOperator.LESS_THAN
                || operator == BinaryOperator.GREATER_THAN
                || operator == BinaryOperator.LESS_THAN_OR_EQUAL_TO
                || operator == BinaryOperator.GREATER_THAN_OR_EQUAL_TO
                || operator == BinaryOperator.EQUALITY
                || operator == BinaryOperator.INEQUALITY;
    }

    private String integerComparisonOpcode(BinaryOperator operator) {
        switch (operator) {
            case LESS_THAN:
                return "if_icmplt";
            case GREATER_THAN:
                return "if_icmpgt";
            case LESS_THAN_OR_EQUAL_TO:
                return "if_icmple";
            case GREATER_THAN_OR_EQUAL_TO:
                return "if_icmpge";
            case EQUALITY:
                return "if_icmpeq";
            case INEQUALITY:
                return "if_icmpne";
            default:
                throw generationError("Unsupported comparison operator");
        }
    }

    private String singleValueComparisonOpcode(BinaryOperator operator) {
        switch (operator) {
            case LESS_THAN:
                return "iflt";
            case GREATER_THAN:
                return "ifgt";
            case LESS_THAN_OR_EQUAL_TO:
                return "ifle";
            case GREATER_THAN_OR_EQUAL_TO:
                return "ifge";
            case EQUALITY:
                return "ifeq";
            case INEQUALITY:
                return "ifne";
            default:
                throw generationError("Unsupported comparison operator");
        }
    }

    private String floatingCompareInstruction(BinaryOperator operator) {
        switch (operator) {
            case LESS_THAN:
            case LESS_THAN_OR_EQUAL_TO:
                return "cmpg";
            case GREATER_THAN:
            case GREATER_THAN_OR_EQUAL_TO:
            case EQUALITY:
            case INEQUALITY:
                return "cmpl";
            default:
                throw generationError("Unsupported floating comparison operator");
        }
    }

    private String referenceComparisonOpcode(BinaryOperator operator) {
        if (operator == BinaryOperator.EQUALITY) {
            return "if_acmpeq";
        }
        if (operator == BinaryOperator.INEQUALITY) {
            return "if_acmpne";
        }
        throw generationError("Only equality comparisons are supported for references");
    }

    private boolean statementFallsThrough(Statement statement) {
        if (statement instanceof ReturnStmt || statement instanceof BreakJump || statement instanceof ContinueJump) {
            return false;
        }
        if (statement instanceof Block) {
            Block block = (Block) statement;
            for (Statement child : block.getStatements()) {
                if (!statementFallsThrough(child)) {
                    return false;
                }
            }
            return true;
        }
        if (statement instanceof IfStmt) {
            IfStmt ifStmt = (IfStmt) statement;
            if (ifStmt.getElseBranch() == null) {
                return true;
            }
            return statementFallsThrough(ifStmt.getThenBranch()) || statementFallsThrough(ifStmt.getElseBranch());
        }
        return true;
    }

    private RuntimeException generationError(String message) {
        return new IllegalStateException(message);
    }
}
