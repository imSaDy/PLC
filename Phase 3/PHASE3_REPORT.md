# PLC Phase 3: Final Implementation Report

## 1. Scope and template boundary

This report explains the final Phase 3 implementation in source-reading order.
For every added or changed block it states what the code does, why it is
needed, and why the chosen design is appropriate.

The following five files belonged to the supplied project template and have
been restored to their original source text:

1. `src/main/symbolTable/SymbolTable.java`
2. `src/main/symbolTable/items/SymbolTableItem.java`
3. `src/main/symbolTable/items/VarItem.java`
4. `src/main/symbolTable/items/MethodItem.java`
5. `src/main/symbolTable/items/ModuleItem.java`

No Phase 3 marker, key abstraction, typed overload, extra field, or helper
method remains in those files. The former added files `Key.java` and
`TopLevelItem.java` were removed.

Because the template classes cannot be changed, shared module/struct metadata
is held by `SemanticContext`, not injected into template symbol classes.

## 2. Final source order

```text
1. Untouched template symbol table
2. Added StructItem
3. Direct NameAnalyzer visitor
4. Analyzer-owned semantic context
5. Symbol construction pass
6. Name/private lookup
7. Location resolution
8. Initialization/mutability checks
9. Type/call checks
10. Concrete literal AST construction
11. Reachability analysis and optimized source
12. Main entry-point integration
```

## 3. Untouched template symbol model

### 3.1 `SymbolTable`

Source: `src/main/symbolTable/SymbolTable.java`, lines 1–60.

This file is not Phase 3 implementation work. It retains the template design:

| Lines | Existing API | Use by Phase 3 |
|---|---|---|
| 11–12 | Parent table and `Map<String, SymbolTableItem>` | Represents lexical scope |
| 15–16 | Static `top` and `root` | Preserves the supplied global-scope API |
| 18–25 | Constructors | Create root/member/child tables |
| 28–33 | Single `put(SymbolTableItem)` | Reject duplicate names in one scope |
| 36–45 | Single `get(String)` | Search current scope and then `pre` |
| 48–59 | `push`/`pop` | Preserve the supplied stack-style API |

The analyzers use this API as supplied. There are no type-specific `put` or
`get` methods.

### 3.2 Existing symbol items

| File | Lines | Existing responsibility |
|---|---:|---|
| `SymbolTableItem.java` | 1–13 | Common symbol name |
| `VarItem.java` | 1–25 | Type, mutability, initialization, visibility |
| `MethodItem.java` | 1–26 | Return type, ordered parameter types, visibility |
| `ModuleItem.java` | 1–14 | Module name and module member table |

These files are also unchanged template sources.

## 4. Added `StructItem`

Source: `src/main/symbolTable/items/StructItem.java`, lines 1–36.

The template supplied `ModuleItem` but no struct counterpart, so this is the
only symbol-item class added for Phase 3.

| Lines | Added code | What it does | Why it is needed |
|---|---|---|---|
| 11–13 | Class, member table, ordered field slots | Stores the struct namespace and constructor positions | Structs require fields/methods and positional construction |
| 15–18 | Constructor | Stores the inherited name and creates the member table | Each struct needs an independent namespace |
| 20–22 | `addField` | Records a valid constructor field | Constructor argument position must match field position |
| 24–26 | `addInvalidFieldSlot` | Preserves a rejected declaration’s position | Later constructor arguments must not shift after an earlier duplicate |
| 28–30 | `getFields` | Exposes a read-only ordered view | Type checking reads positions without mutating them |
| 32–34 | `getStructSymbolTable` | Returns the struct namespace | Symbol construction and member lookup need it |

`Optional.empty()` represents an invalid recovered slot explicitly instead of
using `null`.

## 5. Direct `NameAnalyzer` visitor

Source: `src/main/visitor/name/NameAnalyzer.java`, lines 1–371.

`NameAnalyzer` directly extends `Visitor<Type>`. The earlier facade,
coordinator, declaration visitor, and statement visitor were removed because
they split one traversal into unnecessary layers.

### 5.1 Dependencies and entry point

| Lines | Code | What/why |
|---|---|---|
| 43–48 | Shared fields | Keep context, symbol pass, and specialized semantic helpers |
| 50–67 | Constructor | Wire name, initialization, location, and type responsibilities once |
| 69–73 | `analyze` | Build symbols, visit the AST, return diagnostics |

### 5.2 Program and top-level declarations

| Lines | Visitor | Responsibility |
|---|---|---|
| 75–81 | `Program` | Visit every top-level declaration |
| 83–106 | `Module` | Activate its item/table, validate includes, visit members, restore state |
| 108–111 | `ModuleDecl` | Delegate wrapper through double dispatch |
| 113–128 | `Struct` | Activate its item/table, visit members, restore state |
| 130–133 | `StructDecl` | Delegate wrapper through double dispatch |

### 5.3 Methods, parameters, and fields

| Lines | Visitor | Responsibility |
|---|---|---|
| 135–153 | `Method` | Create method scope, validate signature/body, restore state |
| 155–158 | `MethodDecl` | Delegate to method |
| 160–179 | `Parameter` | Validate type, insert initialized variable, report duplicate |
| 181–190 | `Var` | Validate explicit type or constructor |
| 192–195 | `VarDecl` | Delegate member wrapper |

Parameters start initialized because invocation supplies their values.

### 5.4 Statements and lexical scopes

| Lines | Visitor/helper | Responsibility |
|---|---|---|
| 197–204 | `Block` | Create and restore a child lexical table |
| 206–210 | `analyzeStatements` | Visit a body without an unintended additional scope |
| 212–249 | `VarDeclStmt` | Insert local, validate initializer, update initialized state |
| 251–270 | `AssignStmt` | Check RHS, resolve LHS, check type/mutability/initialization |
| 272–275 | `MethodCallStmt` | Delegate call analysis |
| 277–284 | `ReturnStmt` | Check return type |
| 286–330 | `if`/`for`/`while` | Validate boolean conditions and visit nested statements |
| 332–340 | Break/continue | No nested semantic work |
| 342–358 | `InputStmt` | Resolve a write target and complete initialization |
| 360–363 | `OutputStmt` | Analyze a read expression |
| 365–369 | `analyzeType` | Null-safe type delegation |

## 6. `SemanticContext`: metadata outside template classes

Source: `src/main/visitor/name/SemanticContext.java`, lines 1–288.

This class is necessary specifically because the restored template classes
cannot be extended with Phase 3 ownership/include fields.

### 6.1 Run-specific state

| Lines | State | Reason |
|---|---|---|
| 27 | Diagnostics | Errors arise in multiple passes |
| 28–31 | AST module/struct bindings | Duplicate AST declarations still need their exact symbol object |
| 32–36 | Declaration owner and method AST maps | Private access and receiver initialization need ownership/body |
| 37–40 | Member-table and include maps | Supply common module/struct behavior without changing template items |
| 41 | Registered top-level list | Supports deterministic global method search |
| 43–46 | Global/current scope, container, method | Represents active traversal state |

### 6.2 Binding and lookup

| Lines | Methods | Purpose |
|---|---|---|
| 48–52 | Constructor | Create a fresh global table and set template `root/top` |
| 54–59 | Diagnostics | Add and return sorted messages |
| 62–87 | Active-state accessors | Save/restore scope, container, and method |
| 90–104 | Module/struct binding | Store exact AST item, member table, and include names |
| 106–126 | Top-level/member/item access | Expose analyzer-owned metadata |
| 130–149 | Declaration/method binding | Support private and initialization checks |
| 153–161 | Variable lookup | Use unchanged `SymbolTable.get(name)` and translate absence to `null` |
| 164–186 | Top-level/module/struct lookup | Use unchanged global table and safe expected casts |

### 6.3 Nested values

| Lines | Nested type | Purpose |
|---|---|---|
| 188–213 | `DiagnosticCollector` | Stable line/insertion-order diagnostics |
| 215–235 | `TypeSystem` | Fresh primitives, boolean test, type equality |
| 237–252 | `DeclaredTypeResolver` | Resolve explicit or constructor-declared variable type |
| 254–270 | `ResolvedLocation` | Carry resolved type and optional variable symbol |
| 272–286 | `TopLevelTypeAnalyzer` | Resolve only user-defined types via visitor dispatch |

## 7. Two-pass `SymbolTableAnalyzer`

Source: `src/main/visitor/name/SymbolTableAnalyzer.java`, lines 1–212.

### 7.1 Pass order

Lines 28–47 register all modules/structs first and then all members. This
allows forward references without inspecting AST runtime classes.

### 7.2 Top-level symbols

| Lines | Visitor | Work |
|---|---|---|
| 49–72 | Module visitor | Create template `ModuleItem`, bind metadata, insert globally |
| 73–90 | Struct visitor | Create added `StructItem`, bind metadata, insert globally |

Only successful insertions enter the global top-level search list.

### 7.3 Members

| Lines | Block | Work |
|---|---|---|
| 91–133 | Container state/traversal | Select analyzer-owned member table and visit members |
| 135–159 | Field registration | Create `VarItem`, set constructor initialization, bind owner, insert |
| 160–183 | Method registration | Create `MethodItem`, copy ordered parameter types, bind AST/owner, insert |
| 185–203 | Struct slot recovery | Preserve valid or rejected constructor positions |
| 206–210 | Visibility helper | Convert AST modifier once |

## 8. `NameErrorAnalyzer`

Source: `src/main/visitor/name/NameErrorAnalyzer.java`, lines 1–137.

| Lines | Block | What it does | Why |
|---|---|---|---|
| 19–46 | Field lookup | Search direct member and recursively included modules | Includes extend visible fields |
| 48–75 | Method lookup | Search direct member and includes with cycle protection | Includes may be cyclic |
| 77–97 | Unqualified method lookup | Prefer current container, then one public global candidate | Avoid arbitrary ambiguity |
| 99–119 | Private checks | Compare declaration owner with active container | Private members are legal only inside their owner |
| 121–135 | Direct member helpers | Use analyzer-owned member table plus unchanged `get(name)` | Template table remains untouched |

The visited-name set prevents infinite recursion through cyclic includes.

## 9. `LocationAnalyzer`

Source: `src/main/visitor/name/LocationAnalyzer.java`, lines 1–275.

| Lines | Block | Responsibility |
|---|---|---|
| 19–89 | Coordinator | Start absolute/relative lookup and map user-defined types to containers |
| 92–196 | Absolute visitor | Resolve lexical variable, included field, top-level name, `this`, member chain, call |
| 198–274 | Relative visitor | Resolve fields inside a known module/struct container |

The `read` flag distinguishes an uninitialized read from a legal first write.
Every field result is also checked for private access.

## 10. `InitializationErrorAnalyzer`

Source: `src/main/visitor/name/InitializationErrorAnalyzer.java`, lines 1–132.

| Lines | Block | Responsibility |
|---|---|---|
| 24–31 | `checkRead` | Report uninitialized reads |
| 33–52 | `completeAssignment` | Reject immutable reassignment and record first initialization |
| 54–65 | `completeInput` | Treat input as a write |
| 67–79 | Receiver-method entry | Recognize `init` or a body that writes `this` |
| 81–130 | Visitor methods | Search assignments/input through blocks, branches, and loops |

## 11. `TypeErrorAnalyzer`

Source: `src/main/visitor/name/TypeErrorAnalyzer.java`, lines 1–378.

| Lines | Block | Responsibility |
|---|---|---|
| 55–112 | Reusable checks | Initializer, assignment, return, boolean condition, void type |
| 114–195 | Method calls | Resolve target, private access, receiver initialization, argument count/types |
| 197–223 | Argument comparison | Report the first left-to-right type mismatch |
| 225–264 | Constructors | Require struct and initialize positional fields |
| 266–293 | Locations/parentheses | Delegate typed location resolution |
| 295–320 | Unary/binary operators | Compute result types |
| 322–363 | Literal/primitive visitors | Return concrete expression types |
| 365–375 | User-defined type | Require a declared module or struct |

## 12. Concrete literal AST construction

Source: `src/main/grammar/SimpleLang.g4`, lines 384–404.

Each constant token constructs its existing concrete AST class:

| Token | AST node |
|---|---|
| `CONSTINT` | `IntLiteral` |
| `CONSTFLOAT` | `FloatLiteral` |
| `CONSTDOUBLE` | `DoubleLiteral` |
| `CONSTCHAR` | `CharLiteral` |
| `CONSTBOOL` | `BoolLiteral` |

This allows visitor dispatch to determine literal type without `getClass()`.

## 13. Reachability and optimized source

### 13.1 Public facade and graph

- `src/main/visitor/ReachabilityAnalyzer.java`, lines 1–16: stable public API.
- `ReachabilityGraphAnalyzer.java`, lines 1–197: index modules/structs/methods,
  store includes and references, and identify `main`.
- Graph lines 103–139 store source-ordered nodes and method owners.
- Node lines 141–195 store one declaration’s line, members, includes,
  references, and entry-point flag.

### 13.2 Reference visitor

Source: `src/main/visitor/reachability/ReachabilityReferenceAnalyzer.java`,
lines 1–276.

It visits declarations, all statement forms, calls, constructors, locations,
operators, and user-defined types. A reference becomes a graph edge only when
the target is a known top-level node. Structural references count even inside
a branch that may be false at runtime.

### 13.3 Reachability engine

Source: `src/main/visitor/reachability/ReachabilityEngineAnalyzer.java`,
lines 1–79.

Lines 19–48 build the graph and perform BFS from every declaration containing
`main`. Lines 51–77 separate reachable and unreachable declarations while
preserving AST identity.

### 13.4 Result and optimized output

Source: `src/main/visitor/reachability/ReachabilityResult.java`, lines 1–131.

| Lines | Work |
|---|---|
| 23–47 | Construct normal/no-entry results |
| 49–59 | Format unreachable warnings |
| 61–112 | Copy exact parse-tree intervals of reachable declarations |
| 114–126 | Build `_optimized` path |
| 128–129 | Store unreachable name/line |

Original token intervals preserve comments and internal formatting.

## 14. `SimpleLang` integration

Source: `src/SimpleLang.java`, lines 1–48.

| Lines | Work |
|---|---|
| 18–27 | Parse source and keep parse tree plus AST |
| 29–33 | Run direct `main.visitor.name.NameAnalyzer` and print diagnostics |
| 35–41 | Run reachability and print warnings |
| 42–45 | Write optimized source using exact parse-tree contexts |

## 15. Exact diagnostic formats

```text
Line <LineNumber> : <Name> not declared
Line <LineNumber> : <Name> is private
Line <LineNumber> : <Name> already defined
Line <LineNumber> : <Name> is uninitialized
Line <LineNumber> : Type mismatch in assignment. Cannot assign <SourceType> to <TargetType>
Line <LineNumber> : Condition type must be bool
Line <LineNumber> : Return type mismatch. Expected <ExpectedType>, got <ActualType>
Line <LineNumber> : Cannot modify immutable variable <Name>
Line <LineNumber> : Argument count mismatch for method <MethodName>. Expected <ExpectedCount>, got <ActualCount>
Line <LineNumber> : Argument type mismatch for method <MethodName>, parameter <Index>. Expected <ExpectedType>, got <ActualType>
Warning Line <LineNumber> : <Name> is unreachable
```

## 16. Verification

- All Java sources under `src` and `gen` compile with `-Xlint:all`.
- Only the two supplied exception `serialVersionUID` warnings and generated
  parser `this-escape` warning remain.
- All 11 supplied sample outputs pass.
- A focused struct constructor/member lookup test also passes against the
  restored template table.
- No source under `src` contains `instanceof`, `getClass()`, `OwnerInfo`, or
  `CONSTANT_TYPES`.
- The five pre-existing symbol-table files match the recovered template
  byte-for-byte.
- The generated `samples/Name/unreachable_optimized.mol` and empty
  `src/main/symbolTable/utils` directory were removed.
- Every remaining added analyzer class, context field, and helper method has
  at least one live source reference.

### 16.1 VS Code ANTLR cache build fix

VS Code's ANTLR debugger generated a second parser source tree under
`src/main/grammar/.antlr`. The canonical generated sources already exist under
`gen/main/grammar`, so compiling both directories produced duplicate definitions
of `SimpleLangLexer`, `SimpleLangParser`, `SimpleLangListener`, and
`SimpleLangBaseListener`.

The generated `.antlr` cache was removed. In addition, `test_samples.sh`, lines
58–67, now excludes every `*/.antlr/*` path while discovering Java sources. This
makes the fix persistent if the VS Code extension recreates its cache:

```bash
# start: exclude VS Code's duplicate ANTLR cache from compilation
mapfile -d '' JAVA_SOURCES < <(
    find "$ROOT_DIR/src" "$ROOT_DIR/gen" \
        -type f \
        -name '*.java' \
        ! -path '*/.antlr/*' \
        -print0 \
        | sort -z
)
# end: exclude VS Code's duplicate ANTLR cache from compilation
```

After this change, `./test_samples.sh` completes successfully with 11 passed,
0 failed, and 0 missing samples.

---



# Appendix A: Complete symbol model

## A.1 `SymbolTable.java`

Source: `src/main/symbolTable/SymbolTable.java`, lines 1–59.

```java
package main.symbolTable;

import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.SymbolTableItem;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private SymbolTable pre; 
    private Map<String, SymbolTableItem> items;

    
    public static SymbolTable top;
    public static SymbolTable root;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    
    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getName())) {
            throw new ItemAlreadyExistsException();
        }
        items.put(item.getName(), item);
    }

    
    public SymbolTableItem get(String key) throws ItemNotFoundException {
        SymbolTableItem item = items.get(key);
        if (item != null) {
            return item;
        }
        if (pre != null) {
            return pre.get(key);
        }
        throw new ItemNotFoundException();
    }

    
    public static void push(SymbolTable symbolTable) {
        if (top != null) {
            symbolTable.pre = top;
        }
        top = symbolTable;
    }

    public static void pop() {
        if (top != null) {
            top = top.pre;
        }
    }
}```

## A.2 `SymbolTableItem.java`

Source: `src/main/symbolTable/items/SymbolTableItem.java`, lines 1–12.

```java
package main.symbolTable.items;

public abstract class SymbolTableItem {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}```

## A.3 `VarItem.java`

Source: `src/main/symbolTable/items/VarItem.java`, lines 1–24.

```java
package main.symbolTable.items;

import main.ast.types.Type;

public class VarItem extends SymbolTableItem {
    private Type type;
    private boolean isMut;
    private boolean isInitialized;
    private String visibility; 

    public VarItem(String name, Type type, boolean isMut, String visibility) {
        this.name = name;
        this.type = type;
        this.isMut = isMut;
        this.isInitialized = false; 
        this.visibility = visibility;
    }

    
    public Type getType() { return type; }
    public boolean isMut() { return isMut; }
    public boolean isInitialized() { return isInitialized; }
    public void setInitialized(boolean initialized) { isInitialized = initialized; }
    public String getVisibility() { return visibility; }
}```

## A.4 `MethodItem.java`

Source: `src/main/symbolTable/items/MethodItem.java`, lines 1–25.

```java
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
}```

## A.5 `ModuleItem.java`

Source: `src/main/symbolTable/items/ModuleItem.java`, lines 1–13.

```java
package main.symbolTable.items;

import main.symbolTable.SymbolTable;

public class ModuleItem extends SymbolTableItem {
    private SymbolTable moduleSymbolTable;

    public ModuleItem(String name) {
        this.name = name;
        this.moduleSymbolTable = new SymbolTable();
    }

    public SymbolTable getModuleSymbolTable() { return moduleSymbolTable; }
}```

## A.6 `StructItem.java`

Source: `src/main/symbolTable/items/StructItem.java`, lines 1–36.

```java
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
```


# Appendix B: Complete name/type analyzers

## B.1 `NameAnalyzer.java`

Source: `src/main/visitor/name/NameAnalyzer.java`, lines 1–371.

```java
// start: Phase 3 name and type analyzer
package main.visitor.name;

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
import main.ast.types.Identifier;
import main.ast.types.Type;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;
import main.visitor.name.SemanticContext.DeclaredTypeResolver;
import main.visitor.name.SemanticContext.ResolvedLocation;

import java.util.List;

public final class NameAnalyzer extends Visitor<Type> {
    private final SemanticContext context;
    private final SymbolTableAnalyzer symbols;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final TypeErrorAnalyzer types;

    public NameAnalyzer() {
        context = new SemanticContext();
        symbols = new SymbolTableAnalyzer(context);

        NameErrorAnalyzer names = new NameErrorAnalyzer(context);
        initialization = new InitializationErrorAnalyzer(context);
        locations = new LocationAnalyzer(
                context,
                names,
                initialization
        );
        types = new TypeErrorAnalyzer(
                context,
                names,
                locations,
                initialization
        );
    }

    public List<String> analyze(Program program) {
        symbols.analyze(program);
        program.accept(this);
        return context.messages();
    }

    @Override
    public Type visit(Program program) {
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Type visit(Module module) {
        ModuleItem item = context.itemFor(module);
        SymbolTableItem previousContainer = context.currentContainer();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentContainer(item);
        context.setCurrentScope(context.memberTable(item));

        for (Identifier include : module.getIncludes()) {
            if (context.findModule(include.getName()) == null) {
                context.report(
                        module.getLine(),
                        include.getName() + " not declared"
                );
            }
        }
        for (Member member : module.getMembers()) {
            member.accept(this);
        }

        context.setCurrentScope(previousScope);
        context.setCurrentContainer(previousContainer);
        return null;
    }

    @Override
    public Type visit(ModuleDecl moduleDecl) {
        return moduleDecl.getModule().accept(this);
    }

    @Override
    public Type visit(Struct struct) {
        StructItem item = context.itemFor(struct);
        SymbolTableItem previousContainer = context.currentContainer();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentContainer(item);
        context.setCurrentScope(context.memberTable(item));

        for (Member member : struct.getMembers()) {
            member.accept(this);
        }

        context.setCurrentScope(previousScope);
        context.setCurrentContainer(previousContainer);
        return null;
    }

    @Override
    public Type visit(StructDecl structDecl) {
        return structDecl.getStruct().accept(this);
    }

    @Override
    public Type visit(Method method) {
        Method previousMethod = context.currentMethod();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentMethod(method);
        context.setCurrentScope(new SymbolTable(
                context.memberTable(context.currentContainer())
        ));

        analyzeType(method.getReturnType());
        for (Parameter parameter : method.getParameters()) {
            parameter.accept(this);
        }
        analyzeStatements(method.getBody());

        context.setCurrentScope(previousScope);
        context.setCurrentMethod(previousMethod);
        return method.getReturnType();
    }

    @Override
    public Type visit(MethodDecl methodDecl) {
        return methodDecl.getMethod().accept(this);
    }

    @Override
    public Type visit(Parameter parameter) {
        analyzeType(parameter.getType());
        VarItem item = new VarItem(
                parameter.getName().getName(),
                parameter.getType(),
                parameter.getIsMutable(),
                "public"
        );
        item.setInitialized(true);
        try {
            context.currentScope().put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    parameter.getLine(),
                    parameter.getName().getName() + " already defined"
            );
        }
        return parameter.getType();
    }

    @Override
    public Type visit(Var var) {
        Type type = DeclaredTypeResolver.typeOf(var);
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(types);
        } else {
            analyzeType(type);
        }
        return type;
    }

    @Override
    public Type visit(VarDecl varDecl) {
        return varDecl.getVar().accept(this);
    }

    @Override
    public Type visit(Block block) {
        SymbolTable previousScope = context.currentScope();
        context.setCurrentScope(new SymbolTable(previousScope));
        analyzeStatements(block);
        context.setCurrentScope(previousScope);
        return null;
    }

    private void analyzeStatements(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
    }

    @Override
    public Type visit(VarDeclStmt varDeclStmt) {
        Var var = varDeclStmt.getVar();
        Type type = DeclaredTypeResolver.typeOf(var);
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(types);
        } else {
            analyzeType(type);
        }

        VarItem item = new VarItem(
                var.getName().getName(),
                type,
                var.getIsMutable(),
                "public"
        );
        item.setInitialized(var.getConstructorCall() != null);
        try {
            context.currentScope().put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    var.getLine(),
                    var.getName().getName() + " already defined"
            );
        }

        if (varDeclStmt.getInitial() != null) {
            Type initialType =
                    varDeclStmt.getInitial().accept(types);
            types.checkInitializer(
                    type,
                    initialType,
                    varDeclStmt.getLine()
            );
            item.setInitialized(true);
        }
        return type;
    }

    @Override
    public Type visit(AssignStmt assignStmt) {
        Type rightType = assignStmt.getRight().accept(types);
        ResolvedLocation left = locations.resolve(
                assignStmt.getLeft(),
                false,
                types
        );
        boolean mismatch = types.checkAssignment(
                left,
                rightType,
                assignStmt.getLine()
        );
        initialization.completeAssignment(
                left == null ? null : left.variable(),
                assignStmt.getLine(),
                mismatch
        );
        return null;
    }

    @Override
    public Type visit(MethodCallStmt methodCallStmt) {
        return methodCallStmt.getMethodCall().accept(types);
    }

    @Override
    public Type visit(ReturnStmt returnStmt) {
        Type actualType = returnStmt.getValue() == null
                ? types.voidType()
                : returnStmt.getValue().accept(types);
        types.checkReturn(actualType, returnStmt.getLine());
        return actualType;
    }

    @Override
    public Type visit(IfStmt ifStmt) {
        types.requireBoolean(
                ifStmt.getCondition().accept(types),
                ifStmt.getLine()
        );
        ifStmt.getThenBranch().accept(this);
        if (ifStmt.getElseBranch() != null) {
            ifStmt.getElseBranch().accept(this);
        }
        return null;
    }

    @Override
    public Type visit(ForStmt forStmt) {
        SymbolTable previousScope = context.currentScope();
        context.setCurrentScope(new SymbolTable(previousScope));

        for (Statement initializer : forStmt.getInitializers()) {
            initializer.accept(this);
        }
        if (forStmt.getCondition() != null) {
            types.requireBoolean(
                    forStmt.getCondition().accept(types),
                    forStmt.getLine()
            );
        }
        forStmt.getBody().accept(this);
        for (AssignStmt updater : forStmt.getUpdaters()) {
            updater.accept(this);
        }

        context.setCurrentScope(previousScope);
        return null;
    }

    @Override
    public Type visit(WhileStmt whileStmt) {
        types.requireBoolean(
                whileStmt.getCondition().accept(types),
                whileStmt.getLine()
        );
        whileStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Type visit(BreakJump breakJump) {
        return null;
    }

    @Override
    public Type visit(ContinueJump continueJump) {
        return null;
    }

    @Override
    public Type visit(InputStmt inputStmt) {
        ResolvedLocation location = locations.resolve(
                inputStmt.getLoc(),
                false,
                types
        );
        if (location == null || location.variable() == null) {
            return null;
        }

        initialization.completeInput(
                location.variable(),
                inputStmt.getLine()
        );
        return null;
    }

    @Override
    public Type visit(OutputStmt outputStmt) {
        return outputStmt.getValue().accept(types);
    }

    private void analyzeType(Type type) {
        if (type != null) {
            type.accept(types);
        }
    }
}
// end: Phase 3 name and type analyzer
```

## B.2 `SemanticContext.java`

Source: `src/main/visitor/name/SemanticContext.java`, lines 1–288.

```java
// start: Phase 3 shared semantic context and values
package main.visitor.name;

import main.ast.declarations.Method;
import main.ast.declarations.Module;
import main.ast.declarations.Struct;
import main.ast.declarations.Var;
import main.ast.types.PrimitiveType;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class SemanticContext {
    private final DiagnosticCollector diagnostics = new DiagnosticCollector();
    private final Map<Module, ModuleItem> moduleItems =
            new IdentityHashMap<>();
    private final Map<Struct, StructItem> structItems =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, SymbolTableItem>
            declarationContainers =
            new IdentityHashMap<>();
    private final Map<MethodItem, Method> methodDeclarations =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, SymbolTable> memberTables =
            new IdentityHashMap<>();
    private final Map<SymbolTableItem, List<String>> includedNames =
            new IdentityHashMap<>();
    private final List<SymbolTableItem> topLevelItems = new ArrayList<>();

    private final SymbolTable globalTable;
    private SymbolTable currentScope;
    private SymbolTableItem currentContainer;
    private Method currentMethod;

    SemanticContext() {
        globalTable = new SymbolTable();
        SymbolTable.root = globalTable;
        SymbolTable.top = globalTable;
    }

    void report(int line, String message) {
        diagnostics.report(line, message);
    }

    List<String> messages() {
        return diagnostics.messages();
    }

    SymbolTable globalTable() {
        return globalTable;
    }

    SymbolTable currentScope() {
        return currentScope;
    }

    void setCurrentScope(SymbolTable currentScope) {
        this.currentScope = currentScope;
    }

    SymbolTableItem currentContainer() {
        return currentContainer;
    }

    void setCurrentContainer(SymbolTableItem currentContainer) {
        this.currentContainer = currentContainer;
    }

    Method currentMethod() {
        return currentMethod;
    }

    void setCurrentMethod(Method currentMethod) {
        this.currentMethod = currentMethod;
    }

    void bind(Module module, ModuleItem item) {
        moduleItems.put(module, item);
        memberTables.put(item, item.getModuleSymbolTable());
        List<String> names = new ArrayList<>();
        module.getIncludes().forEach(
                include -> names.add(include.getName())
        );
        includedNames.put(item, List.copyOf(names));
    }

    void bind(Struct struct, StructItem item) {
        structItems.put(struct, item);
        memberTables.put(item, item.getStructSymbolTable());
        includedNames.put(item, List.of());
    }

    void registerTopLevel(SymbolTableItem item) {
        topLevelItems.add(item);
    }

    List<SymbolTableItem> topLevelItems() {
        return List.copyOf(topLevelItems);
    }

    SymbolTable memberTable(SymbolTableItem item) {
        return memberTables.get(item);
    }

    List<String> includedNames(SymbolTableItem item) {
        return includedNames.getOrDefault(item, List.of());
    }

    ModuleItem itemFor(Module module) {
        return moduleItems.get(module);
    }

    StructItem itemFor(Struct struct) {
        return structItems.get(struct);
    }

    void bindDeclaration(
            SymbolTableItem declaration,
            SymbolTableItem container
    ) {
        declarationContainers.put(declaration, container);
    }

    SymbolTableItem declarationContainer(SymbolTableItem declaration) {
        return declarationContainers.get(declaration);
    }

    boolean isMember(SymbolTableItem declaration) {
        return declarationContainers.containsKey(declaration);
    }

    void bindMethod(MethodItem item, Method declaration) {
        methodDeclarations.put(item, declaration);
    }

    Method declarationFor(MethodItem item) {
        return methodDeclarations.get(item);
    }

    VarItem lookupVariable(String name) {
        if (currentScope == null) {
            return null;
        }
        try {
            return (VarItem) currentScope.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    SymbolTableItem findTopLevel(String name) {
        try {
            return globalTable.get(name);
        } catch (ItemNotFoundException exception) {
            return null;
        }
    }

    ModuleItem findModule(String name) {
        try {
            return (ModuleItem) globalTable.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    StructItem findStruct(String name) {
        try {
            return (StructItem) globalTable.get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    private static final class DiagnosticCollector {
        private final List<Diagnostic> diagnostics = new ArrayList<>();
        private int nextOrder;

        void report(int line, String message) {
            diagnostics.add(new Diagnostic(line, nextOrder++, message));
        }

        List<String> messages() {
            diagnostics.sort(Comparator
                    .comparingInt(Diagnostic::line)
                    .thenComparingInt(Diagnostic::order));

            List<String> messages = new ArrayList<>();
            for (Diagnostic diagnostic : diagnostics) {
                messages.add(
                        "Line " + diagnostic.line() + " : "
                                + diagnostic.message()
                );
            }
            return messages;
        }

        private record Diagnostic(int line, int order, String message) {
        }
    }

    static final class TypeSystem {
        private TypeSystem() {
        }

        static PrimitiveType primitive(
                PrimitiveType.Primitive primitive
        ) {
            return new PrimitiveType(primitive);
        }

        static boolean isBoolean(Type type) {
            return type != null && "bool".equals(type.getStr());
        }

        static boolean same(Type first, Type second) {
            return first != null
                    && second != null
                    && first.getStr() != null
                    && first.getStr().equals(second.getStr());
        }
    }

    static final class DeclaredTypeResolver {
        private DeclaredTypeResolver() {
        }

        static Type typeOf(Var var) {
            if (var.getType() != null) {
                return var.getType();
            }
            if (var.getConstructorCall() != null) {
                return new UserDefinedType(
                        var.getConstructorCall().getName()
                );
            }
            return null;
        }
    }

    static final class ResolvedLocation {
        private final Type type;
        private final VarItem variable;

        ResolvedLocation(Type type, VarItem variable) {
            this.type = type;
            this.variable = variable;
        }

        Type type() {
            return type;
        }

        VarItem variable() {
            return variable;
        }
    }

    static final class TopLevelTypeAnalyzer
            extends Visitor<SymbolTableItem> {
        private final SemanticContext context;

        TopLevelTypeAnalyzer(SemanticContext context) {
            this.context = context;
        }

        @Override
        public SymbolTableItem visit(UserDefinedType userDefinedType) {
            return context.findTopLevel(
                    userDefinedType.getId().getName()
            );
        }
    }
}
// end: Phase 3 shared semantic context and values
```

## B.3 `SymbolTableAnalyzer.java`

Source: `src/main/visitor/name/SymbolTableAnalyzer.java`, lines 1–212.

```java
// start: Phase 3 symbol-table analyzers
package main.visitor.name;

import main.visitor.name.SemanticContext.DeclaredTypeResolver;
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
import main.ast.types.AccessModifier;
import main.ast.types.Identifier;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

final class SymbolTableAnalyzer {
    private final TopLevelSymbolAnalyzer topLevels;
    private final MemberSymbolAnalyzer members;

    SymbolTableAnalyzer(SemanticContext context) {
        topLevels = new TopLevelSymbolAnalyzer(context);
        members = new MemberSymbolAnalyzer(context);
    }

    void analyze(Program program) {
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(topLevels);
        }
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(members);
        }
    }
}

final class TopLevelSymbolAnalyzer extends Visitor<Void> {
    private final SemanticContext context;

    TopLevelSymbolAnalyzer(SemanticContext context) {
        this.context = context;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        ModuleItem item = new ModuleItem(module.getName().getName());
        context.bind(module, item);
        try {
            context.globalTable().put(item);
            context.registerTopLevel(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    module.getLine(),
                    module.getName().getName() + " already defined"
            );
        }
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        StructItem item = new StructItem(struct.getName().getName());
        context.bind(struct, item);
        try {
            context.globalTable().put(item);
            context.registerTopLevel(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    struct.getLine(),
                    struct.getName().getName() + " already defined"
            );
        }
        return null;
    }
}

final class MemberSymbolAnalyzer extends Visitor<Void> {
    private final SemanticContext context;
    private SymbolTableItem currentContainer;
    private StructItem currentStruct;

    MemberSymbolAnalyzer(SemanticContext context) {
        this.context = context;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        analyzeMembers(
                module.getMembers(),
                context.itemFor(module),
                null
        );
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        StructItem item = context.itemFor(struct);
        analyzeMembers(struct.getMembers(), item, item);
        return null;
    }

    private void analyzeMembers(
            Iterable<Member> members,
            SymbolTableItem container,
            StructItem struct
    ) {
        SymbolTableItem previousContainer = currentContainer;
        StructItem previousStruct = currentStruct;
        currentContainer = container;
        currentStruct = struct;
        for (Member member : members) {
            member.accept(this);
        }
        currentContainer = previousContainer;
        currentStruct = previousStruct;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        Var var = varDecl.getVar();
        VarItem item = new VarItem(
                var.getName().getName(),
                DeclaredTypeResolver.typeOf(var),
                var.getIsMutable(),
                visibility(varDecl.getAccessModifier())
        );
        item.setInitialized(var.getConstructorCall() != null);
        context.bindDeclaration(item, currentContainer);

        try {
            context.memberTable(currentContainer).put(item);
            recordStructField(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    var.getLine(),
                    var.getName().getName() + " already defined"
            );
            recordExistingStructField(var.getName().getName());
        }
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        Method method = methodDecl.getMethod();
        MethodItem item = new MethodItem(
                method.getName().getName(),
                method.getReturnType(),
                visibility(methodDecl.getAccessModifier())
        );
        for (Parameter parameter : method.getParameters()) {
            item.addParameterType(parameter.getType());
        }
        context.bindMethod(item, method);
        context.bindDeclaration(item, currentContainer);

        try {
            context.memberTable(currentContainer).put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    method.getLine(),
                    method.getName().getName() + " already defined"
            );
        }
        return null;
    }

    private void recordStructField(VarItem field) {
        if (currentStruct != null) {
            currentStruct.addField(field);
        }
    }

    private void recordExistingStructField(String name) {
        if (currentStruct == null) {
            return;
        }
        try {
            currentStruct.addField(
                    (VarItem) currentStruct
                            .getStructSymbolTable()
                            .get(name)
            );
        } catch (ItemNotFoundException ignored) {
            currentStruct.addInvalidFieldSlot();
        }
    }

    private String visibility(AccessModifier modifier) {
        return modifier == AccessModifier.PRIVATE
                ? "private"
                : "public";
    }
}
// end: Phase 3 symbol-table analyzers
```

## B.4 `NameErrorAnalyzer.java`

Source: `src/main/visitor/name/NameErrorAnalyzer.java`, lines 1–137.

```java
// start: Phase 3 name and access error analyzer
package main.visitor.name;

import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;

import java.util.HashSet;
import java.util.Set;

final class NameErrorAnalyzer {
    private final SemanticContext context;

    NameErrorAnalyzer(SemanticContext context) {
        this.context = context;
    }

    VarItem findField(SymbolTableItem container, String name) {
        return findField(container, name, new HashSet<>());
    }

    private VarItem findField(
            SymbolTableItem container,
            String name,
            Set<String> visited
    ) {
        if (container == null || !visited.add(container.getName())) {
            return null;
        }
        VarItem direct = memberVariable(container, name);
        if (direct != null) {
            return direct;
        }
        for (String includedName : context.includedNames(container)) {
            VarItem included = findField(
                    context.findTopLevel(includedName),
                    name,
                    visited
            );
            if (included != null) {
                return included;
            }
        }
        return null;
    }

    MethodItem findMethod(SymbolTableItem container, String name) {
        return findMethod(container, name, new HashSet<>());
    }

    private MethodItem findMethod(
            SymbolTableItem container,
            String name,
            Set<String> visited
    ) {
        if (container == null || !visited.add(container.getName())) {
            return null;
        }
        MethodItem direct = memberMethod(container, name);
        if (direct != null) {
            return direct;
        }
        for (String includedName : context.includedNames(container)) {
            MethodItem included = findMethod(
                    context.findTopLevel(includedName),
                    name,
                    visited
            );
            if (included != null) {
                return included;
            }
        }
        return null;
    }

    MethodItem findUnqualifiedMethod(String name) {
        MethodItem local = findMethod(context.currentContainer(), name);
        if (local != null) {
            return local;
        }

        MethodItem visibleMethod = null;
        for (SymbolTableItem container
                : context.topLevelItems()) {
            MethodItem candidate = memberMethod(container, name);
            if (candidate == null
                    || "private".equals(candidate.getVisibility())) {
                continue;
            }
            if (visibleMethod != null) {
                return null;
            }
            visibleMethod = candidate;
        }
        return visibleMethod;
    }

    void checkPrivate(VarItem item, int line) {
        checkPrivate(item, item.getVisibility(), line);
    }

    void checkPrivate(MethodItem item, int line) {
        checkPrivate(item, item.getVisibility(), line);
    }

    private void checkPrivate(
            SymbolTableItem item,
            String visibility,
            int line
    ) {
        SymbolTableItem declarationContainer =
                context.declarationContainer(item);
        if (declarationContainer != null
                && declarationContainer != context.currentContainer()
                && "private".equals(visibility)) {
            context.report(line, item.getName() + " is private");
        }
    }

    private VarItem memberVariable(SymbolTableItem container, String name) {
        try {
            return (VarItem) context.memberTable(container).get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }

    private MethodItem memberMethod(SymbolTableItem container, String name) {
        try {
            return (MethodItem) context.memberTable(container).get(name);
        } catch (ItemNotFoundException | ClassCastException exception) {
            return null;
        }
    }
}
// end: Phase 3 name and access error analyzer
```

## B.5 `LocationAnalyzer.java`

Source: `src/main/visitor/name/LocationAnalyzer.java`, lines 1–275.

```java
// start: Phase 3 location analyzers
package main.visitor.name;

import main.visitor.name.SemanticContext.ResolvedLocation;
import main.visitor.name.SemanticContext.TopLevelTypeAnalyzer;
import main.ast.expressions.Location;
import main.ast.expressions.MemberLoc;
import main.ast.expressions.MethodCallLoc;
import main.ast.expressions.SimpleLoc;
import main.ast.expressions.ThisLoc;
import main.ast.types.Identifier;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.IVisitor;
import main.visitor.Visitor;

final class LocationAnalyzer {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final TopLevelTypeAnalyzer types;

    LocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.types = new TopLevelTypeAnalyzer(context);
    }

    ResolvedLocation resolve(
            Location location,
            boolean read,
            IVisitor<Type> expressionAnalyzer
    ) {
        return location.accept(new AbsoluteLocationAnalyzer(
                context,
                names,
                initialization,
                this,
                read,
                expressionAnalyzer
        ));
    }

    ResolvedLocation resolveRelative(
            SymbolTableItem container,
            Location location,
            boolean read
    ) {
        return location.accept(new RelativeLocationAnalyzer(
                context,
                names,
                initialization,
                this,
                container,
                read
        ));
    }

    ResolvedLocation resolveNamedBase(String name, int line) {
        VarItem variable = context.lookupVariable(name);
        if (variable != null) {
            return new ResolvedLocation(variable.getType(), variable);
        }
        SymbolTableItem container = context.findTopLevel(name);
        if (container != null) {
            return new ResolvedLocation(typeOf(container), null);
        }
        context.report(line, name + " not declared");
        return null;
    }

    SymbolTableItem containerFor(Type type) {
        return type == null ? null : type.accept(types);
    }

    Type typeOf(SymbolTableItem container) {
        return container == null
                ? null
                : new UserDefinedType(
                        new Identifier(container.getName())
                );
    }
}

final class AbsoluteLocationAnalyzer extends Visitor<ResolvedLocation> {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final boolean read;
    private final IVisitor<Type> expressions;

    AbsoluteLocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization,
            LocationAnalyzer locations,
            boolean read,
            IVisitor<Type> expressions
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.locations = locations;
        this.read = read;
        this.expressions = expressions;
    }

    @Override
    public ResolvedLocation visit(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        VarItem variable = context.lookupVariable(name);
        if (variable != null) {
            initialization.checkRead(variable, simpleLoc.getLine(), read);
            return new ResolvedLocation(variable.getType(), variable);
        }

        VarItem includedField =
                names.findField(context.currentContainer(), name);
        if (includedField != null) {
            names.checkPrivate(includedField, simpleLoc.getLine());
            initialization.checkRead(
                    includedField,
                    simpleLoc.getLine(),
                    read
            );
            return new ResolvedLocation(
                    includedField.getType(),
                    includedField
            );
        }

        SymbolTableItem container = context.findTopLevel(name);
        if (container != null) {
            return new ResolvedLocation(locations.typeOf(container), null);
        }
        context.report(simpleLoc.getLine(), name + " not declared");
        return null;
    }

    @Override
    public ResolvedLocation visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() == null) {
            return new ResolvedLocation(
                    locations.typeOf(context.currentContainer()),
                    null
            );
        }
        return locations.resolveRelative(
                context.currentContainer(),
                thisLoc.getLoc(),
                read
        );
    }

    @Override
    public ResolvedLocation visit(MemberLoc memberLoc) {
        ResolvedLocation base = locations.resolveNamedBase(
                memberLoc.getMemberName().getName(),
                memberLoc.getLine()
        );
        if (base == null) {
            return null;
        }

        boolean baseIsUninitialized = read
                && base.variable() != null
                && !base.variable().isInitialized();
        if (baseIsUninitialized) {
            context.report(
                    memberLoc.getLine(),
                    base.variable().getName() + " is uninitialized"
            );
        }
        return locations.resolveRelative(
                locations.containerFor(base.type()),
                memberLoc.getLoc(),
                read && !baseIsUninitialized
        );
    }

    @Override
    public ResolvedLocation visit(MethodCallLoc methodCallLoc) {
        return new ResolvedLocation(
                methodCallLoc.getMethodCall().accept(expressions),
                null
        );
    }
}

final class RelativeLocationAnalyzer extends Visitor<ResolvedLocation> {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final SymbolTableItem container;
    private final boolean read;

    RelativeLocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization,
            LocationAnalyzer locations,
            SymbolTableItem container,
            boolean read
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.locations = locations;
        this.container = container;
        this.read = read;
    }

    @Override
    public ResolvedLocation visit(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        if (container == null) {
            context.report(simpleLoc.getLine(), name + " not declared");
            return null;
        }

        VarItem variable = names.findField(container, name);
        if (variable == null) {
            context.report(simpleLoc.getLine(), name + " not declared");
            return null;
        }
        names.checkPrivate(variable, simpleLoc.getLine());
        initialization.checkRead(variable, simpleLoc.getLine(), read);
        return new ResolvedLocation(variable.getType(), variable);
    }

    @Override
    public ResolvedLocation visit(MemberLoc memberLoc) {
        String name = memberLoc.getMemberName().getName();
        if (container == null) {
            context.report(memberLoc.getLine(), name + " not declared");
            return null;
        }

        VarItem variable = names.findField(container, name);
        if (variable == null) {
            context.report(memberLoc.getLine(), name + " not declared");
            return null;
        }
        names.checkPrivate(variable, memberLoc.getLine());
        return locations.resolveRelative(
                locations.containerFor(variable.getType()),
                memberLoc.getLoc(),
                read
        );
    }

    @Override
    public ResolvedLocation visit(ThisLoc thisLoc) {
        if (container == null) {
            return null;
        }
        return thisLoc.getLoc() == null
                ? new ResolvedLocation(locations.typeOf(container), null)
                : locations.resolveRelative(
                        container,
                        thisLoc.getLoc(),
                        read
                );
    }
}
// end: Phase 3 location analyzers
```

## B.6 `InitializationErrorAnalyzer.java`

Source: `src/main/visitor/name/InitializationErrorAnalyzer.java`, lines 1–132.

```java
// start: Phase 3 initialization and mutability error analyzer
package main.visitor.name;

import main.ast.declarations.Method;
import main.ast.expressions.ThisLoc;
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.Statement;
import main.ast.statements.WhileStmt;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

final class InitializationErrorAnalyzer extends Visitor<Boolean> {
    private final SemanticContext context;

    InitializationErrorAnalyzer(SemanticContext context) {
        this.context = context;
    }

    void checkRead(VarItem variable, int line, boolean read) {
        if (read && !variable.isInitialized()) {
            context.report(
                    line,
                    variable.getName() + " is uninitialized"
            );
        }
    }

    void completeAssignment(
            VarItem variable,
            int line,
            boolean typeMismatch
    ) {
        if (variable == null) {
            return;
        }
        if (!typeMismatch
                && !context.isMember(variable)
                && variable.isInitialized()
                && !variable.isMut()) {
            context.report(
                    line,
                    "Cannot modify immutable variable "
                            + variable.getName()
            );
        }
        variable.setInitialized(true);
    }

    void completeInput(VarItem variable, int line) {
        if (!context.isMember(variable)
                && variable.isInitialized()
                && !variable.isMut()) {
            context.report(
                    line,
                    "Cannot modify immutable variable "
                            + variable.getName()
            );
        }
        variable.setInitialized(true);
    }

    boolean methodInitializesReceiver(MethodItem methodItem) {
        if ("init".equals(methodItem.getName())) {
            return true;
        }
        Method declaration = context.declarationFor(methodItem);
        return declaration != null
                && statementInitializesReceiver(declaration.getBody());
    }

    private boolean statementInitializesReceiver(Statement statement) {
        return statement != null
                && Boolean.TRUE.equals(statement.accept(this));
    }

    @Override
    public Boolean visit(ThisLoc thisLoc) {
        return true;
    }

    @Override
    public Boolean visit(AssignStmt assignStmt) {
        return Boolean.TRUE.equals(assignStmt.getLeft().accept(this));
    }

    @Override
    public Boolean visit(InputStmt inputStmt) {
        return Boolean.TRUE.equals(inputStmt.getLoc().accept(this));
    }

    @Override
    public Boolean visit(Block block) {
        for (Statement statement : block.getStatements()) {
            if (statementInitializesReceiver(statement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean visit(IfStmt ifStmt) {
        return statementInitializesReceiver(ifStmt.getThenBranch())
                || statementInitializesReceiver(ifStmt.getElseBranch());
    }

    @Override
    public Boolean visit(ForStmt forStmt) {
        for (Statement initializer : forStmt.getInitializers()) {
            if (statementInitializesReceiver(initializer)) {
                return true;
            }
        }
        for (AssignStmt updater : forStmt.getUpdaters()) {
            if (statementInitializesReceiver(updater)) {
                return true;
            }
        }
        return statementInitializesReceiver(forStmt.getBody());
    }

    @Override
    public Boolean visit(WhileStmt whileStmt) {
        return statementInitializesReceiver(whileStmt.getBody());
    }
}
// end: Phase 3 initialization and mutability error analyzer
```

## B.7 `TypeErrorAnalyzer.java`

Source: `src/main/visitor/name/TypeErrorAnalyzer.java`, lines 1–378.

```java
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
        List<Type> argumentTypes = new ArrayList<>();
        for (Expression argument : methodCall.getArguments()) {
            argumentTypes.add(argument.accept(this));
        }

        MethodItem method;
        ResolvedLocation instance = null;
        if (methodCall.getInstance() == null) {
            method = names.findUnqualifiedMethod(
                    methodCall.getCallee().getName()
            );
        } else {
            instance = locations.resolve(
                    methodCall.getInstance(),
                    false,
                    this
            );
            if (instance == null) {
                return null;
            }
            SymbolTableItem target = locations.containerFor(instance.type());
            if (target == null) {
                context.report(
                        methodCall.getLine(),
                        methodCall.getCallee().getName() + " not declared"
                );
                return null;
            }
            method = names.findMethod(
                    target,
                    methodCall.getCallee().getName()
            );
        }

        String methodName = methodCall.getCallee().getName();
        if (method == null) {
            context.report(
                    methodCall.getLine(),
                    methodName + " not declared"
            );
            return null;
        }
        names.checkPrivate(method, methodCall.getLine());

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
            return method.getReturnType();
        }

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
        return method.getReturnType();
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
        if (operator == BinaryOperator.LESS_THAN
                || operator == BinaryOperator.GREATER_THAN
                || operator == BinaryOperator.LESS_THAN_OR_EQUAL_TO
                || operator == BinaryOperator.GREATER_THAN_OR_EQUAL_TO
                || operator == BinaryOperator.EQUALITY
                || operator == BinaryOperator.INEQUALITY
                || operator == BinaryOperator.AND
                || operator == BinaryOperator.OR) {
            return TypeSystem.primitive(PrimitiveType.Primitive.BOOL);
        }
        return TypeSystem.same(leftType, rightType) ? leftType : null;
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
```


# Appendix C: Complete reachability analyzers

## C.1 `ReachabilityAnalyzer.java`

Source: `src/main/visitor/ReachabilityAnalyzer.java`, lines 1–16.

```java
// start: Phase 3 reachability-analyzer facade
package main.visitor;

import main.ast.core.Program;
import main.visitor.reachability.ReachabilityEngineAnalyzer;
import main.visitor.reachability.ReachabilityResult;

public final class ReachabilityAnalyzer {
    private final ReachabilityEngineAnalyzer engine =
            new ReachabilityEngineAnalyzer();

    public ReachabilityResult analyze(Program program) {
        return engine.analyze(program);
    }
}
// end: Phase 3 reachability-analyzer facade
```

## C.2 `ReachabilityGraphAnalyzer.java`

Source: `src/main/visitor/reachability/ReachabilityGraphAnalyzer.java`, lines 1–197.

```java
// start: Phase 3 reachability graph analyzer
package main.visitor.reachability;

import main.ast.core.Program;
import main.ast.declarations.Member;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.ModuleDecl;
import main.ast.declarations.Struct;
import main.ast.declarations.StructDecl;
import main.ast.declarations.TopLevelDecl;
import main.ast.types.Identifier;
import main.visitor.Visitor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ReachabilityGraphAnalyzer extends Visitor<Void> {
    private enum Phase {
        TOP_LEVELS,
        METHODS
    }

    private final Graph graph = new Graph();
    private Phase phase;
    private Node currentNode;

    Graph analyze(Program program) {
        phase = Phase.TOP_LEVELS;
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }

        phase = Phase.METHODS;
        for (Node node : graph.nodes()) {
            currentNode = node;
            for (Member member : node.members()) {
                member.accept(this);
            }
        }

        for (Node node : graph.nodes()) {
            new ReachabilityReferenceAnalyzer(graph, node).analyze();
        }
        currentNode = null;
        return graph;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        if (phase != Phase.TOP_LEVELS) {
            return null;
        }
        Module module = moduleDecl.getModule();
        List<String> includedNames = new ArrayList<>();
        for (Identifier include : module.getIncludes()) {
            includedNames.add(include.getName());
        }
        graph.addNode(new Node(
                module.getName().getName(),
                module.getLine(),
                moduleDecl,
                module.getMembers(),
                includedNames
        ));
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        if (phase != Phase.TOP_LEVELS) {
            return null;
        }
        Struct struct = structDecl.getStruct();
        graph.addNode(new Node(
                struct.getName().getName(),
                struct.getLine(),
                structDecl,
                struct.getMembers(),
                List.of()
        ));
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        if (phase != Phase.METHODS) {
            return null;
        }
        String methodName = methodDecl.getMethod().getName().getName();
        graph.registerMethod(methodName, currentNode.name());
        if ("main".equals(methodName)) {
            currentNode.markMainMethod();
        }
        return null;
    }

    static final class Graph {
        private final List<Node> nodes = new ArrayList<>();
        private final Map<String, Node> nodeByName =
                new LinkedHashMap<>();
        private final Map<String, Set<String>> methodContainers =
                new LinkedHashMap<>();

        void addNode(Node node) {
            nodes.add(node);
            nodeByName.putIfAbsent(node.name(), node);
        }

        List<Node> nodes() {
            return nodes;
        }

        Node nodeNamed(String name) {
            return nodeByName.get(name);
        }

        boolean containsNode(String name) {
            return nodeByName.containsKey(name);
        }

        void registerMethod(String methodName, String containerName) {
            methodContainers
                    .computeIfAbsent(
                            methodName,
                            ignored -> new LinkedHashSet<>()
                    )
                    .add(containerName);
        }

        Set<String> containersForMethod(String methodName) {
            return methodContainers.get(methodName);
        }
    }

    static final class Node {
        private final String name;
        private final int line;
        private final TopLevelDecl declaration;
        private final List<Member> members;
        private final List<String> includedNames;
        private final Set<String> references = new LinkedHashSet<>();
        private boolean hasMainMethod;

        Node(
                String name,
                int line,
                TopLevelDecl declaration,
                List<Member> members,
                List<String> includedNames
        ) {
            this.name = name;
            this.line = line;
            this.declaration = declaration;
            this.members = members;
            this.includedNames = includedNames;
        }

        String name() {
            return name;
        }

        int line() {
            return line;
        }

        TopLevelDecl declaration() {
            return declaration;
        }

        List<Member> members() {
            return members;
        }

        List<String> includedNames() {
            return includedNames;
        }

        Set<String> references() {
            return references;
        }

        boolean hasMainMethod() {
            return hasMainMethod;
        }

        void markMainMethod() {
            hasMainMethod = true;
        }
    }
}
// end: Phase 3 reachability graph analyzer
```

## C.3 `ReachabilityReferenceAnalyzer.java`

Source: `src/main/visitor/reachability/ReachabilityReferenceAnalyzer.java`, lines 1–276.

```java
// start: Phase 3 reachability reference analyzer
package main.visitor.reachability;

import main.visitor.reachability.ReachabilityGraphAnalyzer.Graph;
import main.visitor.reachability.ReachabilityGraphAnalyzer.Node;
import main.ast.declarations.Member;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Parameter;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
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
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.MethodCallStmt;
import main.ast.statements.OutputStmt;
import main.ast.statements.ReturnStmt;
import main.ast.statements.Statement;
import main.ast.statements.VarDeclStmt;
import main.ast.statements.WhileStmt;
import main.ast.types.UserDefinedType;
import main.visitor.Visitor;

import java.util.Set;

final class ReachabilityReferenceAnalyzer extends Visitor<Void> {
    private final Graph graph;
    private final Node node;

    ReachabilityReferenceAnalyzer(
            Graph graph,
            Node node
    ) {
        this.graph = graph;
        this.node = node;
    }

    void analyze() {
        for (String includedName : node.includedNames()) {
            addReference(includedName);
        }
        for (Member member : node.members()) {
            member.accept(this);
        }
    }

    private void addReference(String name) {
        if (graph.containsNode(name)) {
            node.references().add(name);
        }
    }

    private void analyzeExpression(Expression expression) {
        if (expression != null) {
            expression.accept(this);
        }
    }

    private void analyzeStatement(Statement statement) {
        if (statement != null) {
            statement.accept(this);
        }
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        methodDecl.getMethod().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        varDecl.getVar().accept(this);
        return null;
    }

    @Override
    public Void visit(Method method) {
        method.getReturnType().accept(this);
        for (Parameter parameter : method.getParameters()) {
            parameter.accept(this);
        }
        method.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(Parameter parameter) {
        parameter.getType().accept(this);
        return null;
    }

    @Override
    public Void visit(Var var) {
        if (var.getType() != null) {
            var.getType().accept(this);
        }
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VarDeclStmt varDeclStmt) {
        varDeclStmt.getVar().accept(this);
        analyzeExpression(varDeclStmt.getInitial());
        return null;
    }

    @Override
    public Void visit(AssignStmt assignStmt) {
        assignStmt.getLeft().accept(this);
        assignStmt.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        analyzeExpression(returnStmt.getValue());
        return null;
    }

    @Override
    public Void visit(IfStmt ifStmt) {
        ifStmt.getCondition().accept(this);
        analyzeStatement(ifStmt.getThenBranch());
        analyzeStatement(ifStmt.getElseBranch());
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        for (Statement initializer : forStmt.getInitializers()) {
            initializer.accept(this);
        }
        analyzeExpression(forStmt.getCondition());
        for (AssignStmt updater : forStmt.getUpdaters()) {
            updater.accept(this);
        }
        analyzeStatement(forStmt.getBody());
        return null;
    }

    @Override
    public Void visit(WhileStmt whileStmt) {
        whileStmt.getCondition().accept(this);
        analyzeStatement(whileStmt.getBody());
        return null;
    }

    @Override
    public Void visit(InputStmt inputStmt) {
        inputStmt.getLoc().accept(this);
        return null;
    }

    @Override
    public Void visit(OutputStmt outputStmt) {
        outputStmt.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        if (methodCall.getInstance() != null) {
            methodCall.getInstance().accept(this);
        } else {
            Set<String> containers = graph.containersForMethod(
                    methodCall.getCallee().getName()
            );
            if (containers != null && containers.size() == 1) {
                addReference(containers.iterator().next());
            }
        }
        for (Expression argument : methodCall.getArguments()) {
            argument.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorCall constructorCall) {
        addReference(constructorCall.getName().getName());
        for (Expression argument : constructorCall.getArguments()) {
            argument.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SimpleLoc simpleLoc) {
        addReference(simpleLoc.getId().getName());
        return null;
    }

    @Override
    public Void visit(MemberLoc memberLoc) {
        addReference(memberLoc.getMemberName().getName());
        memberLoc.getLoc().accept(this);
        return null;
    }

    @Override
    public Void visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() != null) {
            thisLoc.getLoc().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodCallLoc methodCallLoc) {
        methodCallLoc.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(ParanthesisExpr paranthesisExpr) {
        paranthesisExpr.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryOpExpr unaryOpExpr) {
        unaryOpExpr.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeftOperand().accept(this);
        binaryExpression.getRightOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(UserDefinedType userDefinedType) {
        addReference(userDefinedType.getId().getName());
        return null;
    }
}
// end: Phase 3 reachability reference analyzer
```

## C.4 `ReachabilityEngineAnalyzer.java`

Source: `src/main/visitor/reachability/ReachabilityEngineAnalyzer.java`, lines 1–79.

```java
// start: Phase 3 reachability engine analyzer
package main.visitor.reachability;

import main.visitor.reachability.ReachabilityGraphAnalyzer.Graph;
import main.visitor.reachability.ReachabilityGraphAnalyzer.Node;
import main.visitor.reachability.ReachabilityResult.UnreachableDeclaration;
import main.ast.core.Program;
import main.ast.declarations.TopLevelDecl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

public final class ReachabilityEngineAnalyzer {
    public ReachabilityResult analyze(Program program) {
        Graph graph = new ReachabilityGraphAnalyzer().analyze(program);
        Set<Node> reachableNodes =
                Collections.newSetFromMap(new IdentityHashMap<>());
        Deque<Node> workList = new ArrayDeque<>();

        for (Node node : graph.nodes()) {
            if (node.hasMainMethod()) {
                reachableNodes.add(node);
                workList.addLast(node);
            }
        }
        if (workList.isEmpty()) {
            return ReachabilityResult.withoutEntryPoint(
                    program.getTopLevelDeclarations()
            );
        }

        while (!workList.isEmpty()) {
            Node node = workList.removeFirst();
            for (String reference : node.references()) {
                Node referencedNode =
                        graph.nodeNamed(reference);
                if (referencedNode != null
                        && reachableNodes.add(referencedNode)) {
                    workList.addLast(referencedNode);
                }
            }
        }
        return createResult(program, graph, reachableNodes);
    }

    private ReachabilityResult createResult(
            Program program,
            Graph graph,
            Set<Node> reachableNodes
    ) {
        Set<TopLevelDecl> reachableDeclarations =
                Collections.newSetFromMap(new IdentityHashMap<>());
        List<UnreachableDeclaration> unreachableDeclarations =
                new ArrayList<>();

        for (Node node : graph.nodes()) {
            if (reachableNodes.contains(node)) {
                reachableDeclarations.add(node.declaration());
            } else {
                unreachableDeclarations.add(new UnreachableDeclaration(
                        node.name(),
                        node.line()
                ));
            }
        }
        return new ReachabilityResult(
                program.getTopLevelDeclarations(),
                reachableDeclarations,
                unreachableDeclarations,
                true
        );
    }
}
// end: Phase 3 reachability engine analyzer
```

## C.5 `ReachabilityResult.java`

Source: `src/main/visitor/reachability/ReachabilityResult.java`, lines 1–131.

```java
// start: Phase 3 reachability result
package main.visitor.reachability;

import main.ast.declarations.TopLevelDecl;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

public final class ReachabilityResult {
    private final List<TopLevelDecl> declarations;
    private final Set<TopLevelDecl> reachableDeclarations;
    private final List<UnreachableDeclaration> unreachableDeclarations;
    private final boolean hasEntryPoint;

    ReachabilityResult(
            List<TopLevelDecl> declarations,
            Set<TopLevelDecl> reachableDeclarations,
            List<UnreachableDeclaration> unreachableDeclarations,
            boolean hasEntryPoint
    ) {
        this.declarations = new ArrayList<>(declarations);
        this.reachableDeclarations = reachableDeclarations;
        this.unreachableDeclarations = unreachableDeclarations;
        this.hasEntryPoint = hasEntryPoint;
    }

    static ReachabilityResult withoutEntryPoint(
            List<TopLevelDecl> declarations
    ) {
        Set<TopLevelDecl> allDeclarations =
                Collections.newSetFromMap(new IdentityHashMap<>());
        allDeclarations.addAll(declarations);
        return new ReachabilityResult(
                declarations,
                allDeclarations,
                Collections.emptyList(),
                false
        );
    }

    public List<String> warnings() {
        List<String> warnings = new ArrayList<>();
        for (UnreachableDeclaration declaration
                : unreachableDeclarations) {
            warnings.add(
                    "Warning Line " + declaration.line() + " : "
                            + declaration.name() + " is unreachable"
            );
        }
        return warnings;
    }

    public boolean hasUnreachableDeclarations() {
        return hasEntryPoint && !unreachableDeclarations.isEmpty();
    }

    public Path writeOptimizedSource(
            Path inputPath,
            List<? extends ParserRuleContext> declarationContexts
    ) throws IOException {
        if (!hasUnreachableDeclarations()) {
            return null;
        }
        if (declarations.size() != declarationContexts.size()) {
            throw new IllegalArgumentException(
                    "AST and parse-tree declaration counts differ"
            );
        }

        String source = Files.readString(
                inputPath,
                StandardCharsets.UTF_8
        );
        String lineSeparator = source.contains("\r\n") ? "\r\n" : "\n";
        List<String> retainedDeclarations = new ArrayList<>();
        for (int index = 0; index < declarations.size(); index++) {
            TopLevelDecl declaration = declarations.get(index);
            if (!reachableDeclarations.contains(declaration)) {
                continue;
            }
            ParserRuleContext context = declarationContexts.get(index);
            int start = context.getStart().getStartIndex();
            int end = context.getStop().getStopIndex() + 1;
            retainedDeclarations.add(
                    source.substring(start, end).strip()
            );
        }

        String optimizedSource = String.join(
                lineSeparator + lineSeparator,
                retainedDeclarations
        );
        if (!optimizedSource.isEmpty()) {
            optimizedSource += lineSeparator;
        }

        Path outputPath = optimizedPath(inputPath);
        Files.writeString(
                outputPath,
                optimizedSource,
                StandardCharsets.UTF_8
        );
        return outputPath;
    }

    private Path optimizedPath(Path inputPath) {
        String fileName = inputPath.getFileName().toString();
        int extensionIndex = fileName.lastIndexOf('.');
        String baseName = extensionIndex < 0
                ? fileName
                : fileName.substring(0, extensionIndex);
        String extension = extensionIndex < 0
                ? ""
                : fileName.substring(extensionIndex);
        return inputPath.resolveSibling(
                baseName + "_optimized" + extension
        );
    }

    static record UnreachableDeclaration(String name, int line) {
    }
}
// end: Phase 3 reachability result
```


# Appendix D: Grammar and entry point

## D.1 `SimpleLang.g4`

Source: `src/main/grammar/SimpleLang.g4`, lines 1–519.

```antlr
grammar SimpleLang;
@header {
    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;
}

program returns [Program programRet]
    :
        { $programRet = new Program(); }
        (t=topLevelDecl { $programRet.addTopLevelDeclaration($t.topLevelDeclRet); })*
        EOF
    ;

topLevelDecl returns [TopLevelDecl topLevelDeclRet]
    :
        m=module
        { $topLevelDeclRet = new ModuleDecl($m.moduleRet); }
    |
        s=structDef
        { $topLevelDeclRet = new StructDecl($s.structRet); }
    ;

module returns [Module moduleRet]
    :
        k=KW_MODULE
        i=ID
        { $moduleRet = new Module(new Identifier($i.text)); }
        (KW_INCLUDES i1=ID { $moduleRet.addInclude(new Identifier($i1.text)); } (COMMA i2=ID { $moduleRet.addInclude(new Identifier($i2.text)); } )*)?
        KW_BEGIN
        (m=member { $moduleRet.addMember($m.memberRet); } )*
        KW_END
        { $moduleRet.setLine($k.line); }
    ;

structDef returns [Struct structRet]
    :
        k=KW_STRUCT
        i=ID
        { $structRet = new Struct(new Identifier($i.text)); }
        KW_BEGIN
        (m=member { $structRet.addMember($m.memberRet); } )*
        KW_END
        { $structRet.setLine($k.line); }
    ;

member returns [Member memberRet]
    :
        { $memberRet = new MethodDecl(); }
        (a1=accessModifier { $memberRet.setAccessModifier($a1.accessModifierRet); } )?
        m=method_decl
        { ((MethodDecl)$memberRet).setMethod($m.methodRet); }
        { $memberRet.setLine($m.methodRet.getLine()); }
    |
        { $memberRet = new VarDecl(); }
        (a2=accessModifier { $memberRet.setAccessModifier($a2.accessModifierRet); } )?
        v=vardecl
        { ((VarDecl)$memberRet).setVar($v.varRet); }
        { $memberRet.setLine($v.varRet.getLine()); }
        SEMI
    ;

accessModifier returns [AccessModifier accessModifierRet]
    :
        pr=KW_PRIVATE
        { $accessModifierRet = AccessModifier.PRIVATE; }
    |
        pu=KW_PUBLIC
        { $accessModifierRet = AccessModifier.PUBLIC; }
    ;

method_decl returns [Method methodRet]
    :
        t=type
        i=ID
        LPAREN
        a=arguments
        RPAREN
        b=block
        { $methodRet = new Method($t.typeRet, new Identifier($i.text), $a.parametersRet, $b.blockRet); }
        { $methodRet.setLine($i.line); }
    ;


arguments returns [List<Parameter> parametersRet]
    :
        { $parametersRet = new ArrayList<>(); }
        (p1=parameter { $parametersRet.add($p1.parameterRet); } (COMMA p2=parameter { $parametersRet.add($p2.parameterRet); } )*)?
    ;

parameter returns [Parameter parameterRet]
    :
        { boolean isMut = false; }
        (KW_MUT { isMut = true; } )?
        t=type
        i=ID
        { $parameterRet = new Parameter(isMut, $t.typeRet, new Identifier($i.text)); }
        { $parameterRet.setLine($i.line); }
    ;

type returns [Type typeRet]
    :
        i=ID
        { $typeRet = new UserDefinedType(new Identifier($i.text)); }
        { $typeRet.setLine($i.line); }
    |
        ki=KW_INT
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.INT); }
        { $typeRet.setLine($ki.line); }
    |
        kf=KW_FLOAT
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.FLOAT); }
        { $typeRet.setLine($kf.line); }
    |
        kd=KW_DOUBLE
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.DOUBLE); }
        { $typeRet.setLine($kd.line); }
    |
        kc=KW_CHAR
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.CHAR); }
        { $typeRet.setLine($kc.line); }
    |
        kv=KW_VOID
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.VOID); }
        { $typeRet.setLine($kv.line); }
    |
        kb=KW_BOOL
        { $typeRet = new PrimitiveType(PrimitiveType.Primitive.BOOL); }
        { $typeRet.setLine($kb.line); }
    ;

vardecl returns [Var varRet]
    :
        { boolean isMut = false; }
        (KW_MUT { isMut = true; } )?
        (t=type { $varRet = new Var(isMut, $t.typeRet); } | c=cons { $varRet = new Var(isMut, $c.constructorCallRet); } )
        i=ID
        { $varRet.setName(new Identifier($i.text)); }
        { $varRet.setLine($i.line); }
    ;

cons returns [ConstructorCall constructorCallRet]
    :
        i=ID
        { $constructorCallRet = new ConstructorCall(new Identifier($i.text)); }
        LPAREN
        (e1=expr { $constructorCallRet.addArgument($e1.expressionRet); } (COMMA e2=expr { $constructorCallRet.addArgument($e2.expressionRet); } )*)?
        RPAREN
        { $constructorCallRet.setLine($i.line); }
    ;

block returns [Block blockRet]
    :
        { $blockRet = new Block(); }
        k=KW_BEGIN
        (s=st { $blockRet.addStatement($s.statementRet); } )*
        KW_END
        { $blockRet.setLine($k.line); }
    ;

st returns [Statement statementRet]
    :
        b=block
        { $statementRet = $b.blockRet; }
        { $statementRet.setLine($b.blockRet.getLine()); }
    |
        vd=vardecl
        { $statementRet = new VarDeclStmt($vd.varRet); }
        SEMI
        { $statementRet.setLine($vd.varRet.getLine()); }
    |
        v=vardecl
        { $statementRet = new VarDeclStmt($v.varRet); }
        ASSIGN
        e=expr
        { ((VarDeclStmt)$statementRet).setInitial($e.expressionRet); }
        SEMI
        { $statementRet.setLine($e.expressionRet.getLine()); }
    |
        mc=methodcall
        { $statementRet = new MethodCallStmt($mc.methodCallRet); }
        SEMI
        { $statementRet.setLine($mc.methodCallRet.getLine()); }
    |
        ifs=ifStmt
        { $statementRet = $ifs.ifStmtRet; }
        { $statementRet.setLine($ifs.ifStmtRet.getLine()); }
    |
        fs=forStmt
        { $statementRet = $fs.forStmtRet; }
        { $statementRet.setLine($fs.forStmtRet.getLine()); }
    |
        ws=whileStmt
        { $statementRet = $ws.whileStmtRet; }
        { $statementRet.setLine($ws.whileStmtRet.getLine()); }
    |
        as=assignStmt
        { $statementRet = $as.assignStmtRet; }
        { $statementRet.setLine($as.assignStmtRet.getLine()); }
    |
        rs=returnStmt
        { $statementRet = $rs.returnStmtRet; }
        { $statementRet.setLine($rs.returnStmtRet.getLine()); }
    |
        is=inputStmt
        { $statementRet = $is.inputStmtRet; }
        { $statementRet.setLine($is.inputStmtRet.getLine()); }
    |
        os=outputStmt
        { $statementRet = $os.outputStmtRet; }
        { $statementRet.setLine($os.outputStmtRet.getLine()); }
    |
        js=jumpStmt
        { $statementRet = $js.jumpStmtRet; }
        { $statementRet.setLine($js.jumpStmtRet.getLine()); }
    ;
jumpStmt returns [JumpStmt jumpStmtRet]
    :
        kb=KW_BREAK
        { $jumpStmtRet = new BreakJump(); }
        { $jumpStmtRet.setLine($kb.line); }
    |
        kc=KW_CONTINUE
        { $jumpStmtRet = new ContinueJump(); }
        { $jumpStmtRet.setLine($kc.line); }
    ;
ifStmt returns [IfStmt ifStmtRet]
    :
        k=KW_IF
        LPAREN
        e=expr
        RPAREN
        s1=st
        { $ifStmtRet = new IfStmt($e.expressionRet, $s1.statementRet); }
        (KW_ELSE s2=st { $ifStmtRet.setElseBranch($s2.statementRet); } )?
        { $ifStmtRet.setLine($k.line); }
    ;

forStmt returns [ForStmt forStmtRet]
    :
        { $forStmtRet = new ForStmt(); }
        k=KW_FOR
        LPAREN
        (i1=initexpr { $forStmtRet.addInitializer($i1.initExprRet); } (COMMA i2=initexpr { $forStmtRet.addInitializer($i2.initExprRet); } )*)?
        SEMI
        (e1=expr { $forStmtRet.setCondition($e1.expressionRet); } )?
        SEMI
        (l1=loc ASSIGN e2=expr { $forStmtRet.addUpdater(new AssignStmt($l1.locationRet, $e2.expressionRet)); } (COMMA l2=loc ASSIGN e3=expr { $forStmtRet.addUpdater(new AssignStmt($l2.locationRet, $e3.expressionRet)); } )*)?
        RPAREN
        s=st
        { $forStmtRet.setBody($s.statementRet); }
        { $forStmtRet.setLine($k.line); }
    ;

whileStmt returns [WhileStmt whileStmtRet]
    :
        k=KW_WHILE
        LPAREN
        e=expr
        RPAREN
        s=st
        { $whileStmtRet = new WhileStmt($e.expressionRet, $s.statementRet); }
        { $whileStmtRet.setLine($k.line); }
    ;

assignStmt returns [AssignStmt assignStmtRet]
    :
        l=loc
        a=ASSIGN
        e=expr
        { $assignStmtRet = new AssignStmt($l.locationRet, $e.expressionRet); }
        SEMI
        { $assignStmtRet.setLine($a.line); }
    ;

returnStmt returns [ReturnStmt returnStmtRet]
    :
        { $returnStmtRet = new ReturnStmt(); }
        k=KW_RETURN
        (e=expr { $returnStmtRet.setValue($e.expressionRet); } )?
        SEMI
        { $returnStmtRet.setLine($k.line); }
    ;

inputStmt returns [InputStmt inputStmtRet]
    :
        k=KW_INPUT
        l=loc
        { $inputStmtRet = new InputStmt($l.locationRet); }
        SEMI
        { $inputStmtRet.setLine($k.line); }
    ;

outputStmt returns [OutputStmt outputStmtRet]
    :
        k=KW_OUTPUT
        e=expr
        { $outputStmtRet = new OutputStmt($e.expressionRet); }
        SEMI
        { $outputStmtRet.setLine($k.line); }
    ;

loc returns [Location locationRet]
    :
        s=simpleLoc
        { $locationRet = $s.simpleLocRet; }
        { $locationRet.setLine($s.simpleLocRet.getLine()); }
    |
        m=memberLoc
        { $locationRet = $m.memberLocRet; }
        { $locationRet.setLine($m.memberLocRet.getLine()); }
    |
        t=thisLoc
        { $locationRet = $t.thisLocRet; }
        { $locationRet.setLine($t.thisLocRet.getLine()); }
    ;

simpleLoc returns [SimpleLoc simpleLocRet]
    :
        i=ID
        { $simpleLocRet = new SimpleLoc(new Identifier($i.text)); }
        { $simpleLocRet.setLine($i.line); }
    ;

memberLoc returns [MemberLoc memberLocRet]
    :
        i=ID
        DOT
        l=loc
        { $memberLocRet = new MemberLoc(new Identifier($i.text), $l.locationRet); }
        { $memberLocRet.setLine($i.line); }
    ;


thisLoc returns [ThisLoc thisLocRet]
    :
        { $thisLocRet = new ThisLoc(); }
        k=KW_THIS
        (DOT l=loc { $thisLocRet.setLoc($l.locationRet); } )?
        { $thisLocRet.setLine($k.line); }
    ;

methodcall returns [MethodCall methodCallRet]
    :
        { $methodCallRet = new MethodCall(); }
        (l=loc DOT {
            $methodCallRet.setInstance($l.locationRet); })?
        i=ID
        { $methodCallRet.setCallee(new Identifier($i.text)); }

        LPAREN
        (e1=expr { $methodCallRet.addArgument($e1.expressionRet); } (COMMA e2=expr { $methodCallRet.addArgument($e2.expressionRet); } )*)?
        RPAREN
        { $methodCallRet.setLine($i.line); }
    ;

expr returns[Expression expressionRet]
    :
        l=loc
        { $expressionRet = $l.locationRet; }
        { $expressionRet.setLine($l.locationRet.getLine()); }
    |
        k=KW_THIS
        { $expressionRet = new ThisLoc(); }
        { $expressionRet.setLine($k.line); }
    |
        mc=methodcall
        { $expressionRet = $mc.methodCallRet; }
        { $expressionRet.setLine($mc.methodCallRet.getLine()); }
    |
        c=cons
        { $expressionRet = $c.constructorCallRet; }
        { $expressionRet.setLine($c.constructorCallRet.getLine()); }
    |
        LPAREN e=expr RPAREN
        { $expressionRet = $e.expressionRet; }
        { $expressionRet.setLine($e.expressionRet.getLine()); }
    |
        // start: Phase 3 typed literal AST nodes
        ci=CONSTINT
        { $expressionRet = new IntLiteral(Integer.parseInt($ci.text)); }
        { $expressionRet.setLine($ci.line); }
    |
        cf=CONSTFLOAT
        { $expressionRet = new FloatLiteral(Float.parseFloat($cf.text)); }
        { $expressionRet.setLine($cf.line); }
    |
        cd=CONSTDOUBLE
        { $expressionRet = new DoubleLiteral(Double.parseDouble($cd.text)); }
        { $expressionRet.setLine($cd.line); }
    |
        cc=CONSTCHAR
        { $expressionRet = new CharLiteral($cc.text.charAt(1)); }
        { $expressionRet.setLine($cc.line); }
    |
        cb=CONSTBOOL
        { $expressionRet = new BoolLiteral(Boolean.parseBoolean($cb.text)); }
        { $expressionRet.setLine($cb.line); }
        // end: Phase 3 typed literal AST nodes
    |
        op1=(MINUS | KW_NOT) e1=expr
        { $expressionRet = new UnaryExpression($op1.text, $e1.expressionRet); }
        { $expressionRet.setLine($op1.line); }
    |
        e2=expr op2=(STAR | SLASH) e3=expr
        { $expressionRet = new BinaryExpression($e2.expressionRet, $op2.text, $e3.expressionRet); }
        { $expressionRet.setLine($op2.line); }
    |
        e4=expr op3=(PLUS | MINUS) e5=expr
        { $expressionRet = new BinaryExpression($e4.expressionRet, $op3.text, $e5.expressionRet); }
        { $expressionRet.setLine($op3.line); }
    |
        e6=expr op4=(LESS | GREATER | LESS_EQ | GREATER_EQ) e7=expr
        { $expressionRet = new BinaryExpression($e6.expressionRet, $op4.text, $e7.expressionRet); }
        { $expressionRet.setLine($op4.line); }
    |
        e8=expr op5=(EQUAL | NOT_EQUAL) e9=expr
        { $expressionRet = new BinaryExpression($e8.expressionRet, $op5.text, $e9.expressionRet); }
        { $expressionRet.setLine($op5.line); }
    |
        e10=expr op6=KW_AND e11=expr
        { $expressionRet = new BinaryExpression($e10.expressionRet, $op6.text, $e11.expressionRet); }
        { $expressionRet.setLine($op6.line); }
    |
        e12=expr op7=KW_OR e13=expr
        { $expressionRet = new BinaryExpression($e12.expressionRet, $op7.text, $e13.expressionRet); }
        { $expressionRet.setLine($op7.line); }
    ;
initexpr returns [Statement initExprRet]
    :
        v1=vardecl
        { $initExprRet = new VarDeclStmt($v1.varRet); }
        { $initExprRet.setLine($v1.varRet.getLine()); }
    |
        l1=loc
        ASSIGN
        e1=expr
        { $initExprRet = new AssignStmt($l1.locationRet, $e1.expressionRet); }
        { $initExprRet.setLine($l1.locationRet.getLine()); }
    |
        v2=vardecl
        { $initExprRet = new VarDeclStmt($v2.varRet); }
        ASSIGN
        e2=expr
        { ((VarDeclStmt)$initExprRet).setInitial($e2.expressionRet); }
        { $initExprRet.setLine($v2.varRet.getLine()); }
    ;

KW_MODULE   : 'module' ;
KW_STRUCT   : 'struct' ;
KW_INCLUDES : 'includes' ;
KW_BEGIN    : 'begin' ;
KW_END      : 'end' ;
KW_PUBLIC   : 'public' ;
KW_PRIVATE  : 'private' ;
KW_INT      : 'int' ;
KW_FLOAT    : 'float' ;
KW_DOUBLE   : 'double' ;
KW_CHAR     : 'char' ;
KW_VOID     : 'void' ;
KW_IF       : 'if' ;
KW_ELSE     : 'else' ;
KW_FOR      : 'for' ;
KW_WHILE    : 'while' ;
KW_DO       : 'do' ;
KW_RETURN   : 'return' ;
KW_INPUT    : 'input' ;
KW_OUTPUT   : 'output' ;
KW_THIS     : 'this' ;
KW_NOT      : 'not' ;
KW_AND      : 'and' ;
KW_OR       : 'or' ;
KW_MUT      : 'mut' ;
KW_BREAK    : 'break' ;
KW_CONTINUE : 'continue' ;
KW_BOOL     : 'bool' ;
CONSTBOOL   : 'true' | 'false' ;

SEMI        : ';' ;
COMMA       : ',' ;
LPAREN      : '(' ;
RPAREN      : ')' ;
LBRACK      : '[' ;
RBRACK      : ']' ;
ASSIGN      : '=' ;
DOT         : '.' ;
ARROW       : '->' ;
MINUS       : '-' ;
PLUS        : '+' ;
STAR        : '*' ;
SLASH       : '/' ;
AMPERSAND   : '&' ;
LESS        : '<' ;
GREATER     : '>' ;
LESS_EQ     : '<=' ;
GREATER_EQ  : '>=' ;
EQUAL       : '==' ;
NOT_EQUAL   : '!=' ;

CONSTINT    : DIGIT+ ;
CONSTFLOAT  : DIGIT+ DOT DIGIT+ ;
CONSTDOUBLE : DIGIT+ DOT DIGIT+ EXPONENT SIGN? DIGIT+ ;
CONSTCHAR   : '\'' . '\'' ;

ID          : LETTER (LETTER | DIGIT | '_')* ;

fragment LETTER   : [a-zA-Z] ;
fragment DIGIT    : [0-9] ;
fragment EXPONENT : [eE] ;
fragment SIGN     : [+\-] ;

WS          : [ \t\r\n]+ -> skip ;
COMMENT     : '%%' ~[\r\n]* -> skip ;
MULTICOMMENT: '%%%' .*? '%%%' -> skip ;
```

## D.2 `SimpleLang.java`

Source: `src/SimpleLang.java`, lines 1–48.

```java
import main.ast.core.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
// start: Phase 3 analyzer import
import main.visitor.ReachabilityAnalyzer;
import main.visitor.name.NameAnalyzer;
import main.visitor.reachability.ReachabilityResult;
// end: Phase 3 analyzer import

import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);

        SimpleLangLexer lexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpleLangParser parser = new SimpleLangParser(tokens);

        SimpleLangParser.ProgramContext parseTree = parser.program();
        Program program = parseTree.programRet;

        // start: Phase 3 semantic-analysis execution
        NameAnalyzer analyzer = new NameAnalyzer();
        for (String diagnostic : analyzer.analyze(program)) {
            System.out.println(diagnostic);
        }

        ReachabilityAnalyzer reachabilityAnalyzer =
                new ReachabilityAnalyzer();
        ReachabilityResult reachability =
                reachabilityAnalyzer.analyze(program);
        for (String warning : reachability.warnings()) {
            System.out.println(warning);
        }
        reachability.writeOptimizedSource(
                Path.of(args[0]),
                parseTree.topLevelDecl()
        );
        // end: Phase 3 semantic-analysis execution
    }
}
```

## D.3 `judge_artin_tests.sh`

Source: `judge_artin_tests.sh`, lines 1-229.

This helper script was added to run the external `ArtinTests` directory in
the same way as the local sample judge:

1. It compiles all Java sources from `src` and `gen`, while excluding VS
   Code's duplicate ANTLR cache under `.antlr`.
2. It finds every `.mol` file in `ArtinTests`, except generated
   `*_optimized.mol` files.
3. It runs `SimpleLang` on a temporary copy of each input, so generated
   optimized files do not modify the original test directory.
4. It compares stdout against the matching `.out` file.
5. If an expected optimized file exists, such as
   `ArtinTests/23_optimized.mol`, it also compares that generated file.
6. It prints `[PASS]`, `[FAIL]`, or `[MISSING]` per test and exits with a
   non-zero status if any test fails or has no expected output file.

The first full run reported:

```text
Summary: 3 passed, 44 failed, 0 missing, 1 optimized file(s) checked
```

Most failing tests currently differ because the expected Artin output uses
`Line N:` while this implementation follows the project PDF format
`Line N :`. Some tests also expose semantic mismatches, so the judge is kept
strict and prints unified diffs for debugging.
