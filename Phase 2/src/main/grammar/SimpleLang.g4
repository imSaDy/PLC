grammar SimpleLang;

@header {
    package main.grammar;
    
    import main.ast.core.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    
    import main.ast.types.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;
    import java.util.ArrayList;
    import java.util.List;
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
        { $topLevelDeclRet =$m.moduleRet;

        }
    |
        s=structDef
        { $topLevelDeclRet = $s.structRet;
    }
    ;

module returns [Module moduleRet]
    :
        k=KW_MODULE
        i=ID
        {
            $moduleRet = new Module(new Identifier($i.text));
            $moduleRet.setLine($i.line);
        }
        (KW_INCLUDES i1=ID { $moduleRet.addInclude(new Identifier($i1.text)); }
        (COMMA i2=ID { $moduleRet.addInclude(new Identifier($i2.text)); } )*)?
        KW_BEGIN
        (m=member { $moduleRet.addMember($m.memberRet); })*
        KW_END
    ;

structDef returns [Struct structRet]
    :
        k=KW_STRUCT
        i=ID
        KW_BEGIN
        {
            $structRet = new Struct(new Identifier($i.text));
            $structRet.setLine($k.line);
        }
        (m=member { $structRet.addMember($m.memberRet); })*
        KW_END
    ;

member returns [Member memberRet]
    :
        a=accessModifier?
        m=method_decl
        {
            MethodDecl methodDecl = new MethodDecl();
            methodDecl.setMethod($m.methodRet);
            if ($a.ctx != null) {
                methodDecl.setAccessModifier($a.accessModifierRet);
            }
            $memberRet = methodDecl;
        }
    |
        a=accessModifier?
        v=vardecl
        SEMI
        {
            VarDecl varDecl = new VarDecl();
            varDecl.setVar($v.varRet);
            if ($a.ctx != null) {
                varDecl.setAccessModifier($a.accessModifierRet);
            }
            $memberRet = varDecl;
        }
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
        i=ID      { $typeRet = new UserDefinedType(new Identifier($i.text)); }
    |
        KW_INT    { $typeRet = new PrimitiveType(PrimitiveType.Primitive.INT); }
    |
        KW_FLOAT  { $typeRet = new PrimitiveType(PrimitiveType.Primitive.FLOAT); }
    |
        KW_DOUBLE { $typeRet = new PrimitiveType(PrimitiveType.Primitive.DOUBLE); }
    |
        KW_CHAR   { $typeRet = new PrimitiveType(PrimitiveType.Primitive.CHAR); }
    |
        KW_VOID   { $typeRet = new PrimitiveType(PrimitiveType.Primitive.VOID); }
    |
        KW_BOOL   { $typeRet = new PrimitiveType(PrimitiveType.Primitive.BOOL); }
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

    |
        ws=whileStmt

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
        k=KW_FOR
        {
            $forStmtRet = new ForStmt();
            $forStmtRet.setLine($k.line);
        }
        LPAREN
        (i1=initexpr { $forStmtRet.addInitializer($i1.initExprRet); }
            (COMMA i2=initexpr { $forStmtRet.addInitializer($i2.initExprRet); })*)?
        SEMI
        (c=expr { $forStmtRet.setCondition($c.expressionRet); })?
        SEMI
        (u1=updateExpr { $forStmtRet.addUpdater($u1.updateExprRet); }
            (COMMA u2=updateExpr { $forStmtRet.addUpdater($u2.updateExprRet); })*)?
        RPAREN
        b=st
        { $forStmtRet.setBody($b.statementRet); }
    ;

whileStmt returns [WhileStmt whileStmtRet]
    :
        k=KW_WHILE
        LPAREN
        e=expr
        RPAREN
        s=st
        {
            $whileStmtRet = new WhileStmt($e.expressionRet, $s.statementRet);
            $whileStmtRet.setLine($k.line);
        }
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

    |
        m=memberLoc
        { $locationRet = $m.memberLocRet; }

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

        (l=loc DOT {$methodCallRet.setInstance($l.locationRet); })?
        i=ID
        { $methodCallRet.setCallee(new Identifier($i.text)); }

        LPAREN
        (e1=expr
        { $methodCallRet.addArgument($e1.expressionRet);}
        (COMMA e2=expr
        { $methodCallRet.addArgument($e2.expressionRet); }
        )*)?
        RPAREN
        { $methodCallRet.setLine($i.line); }
    ;

expr returns [Expression expressionRet]
    :
        l=loc
        { $expressionRet = $l.locationRet; }
    |
        k=KW_THIS
        {
            ThisLoc thisLoc = new ThisLoc();
            thisLoc.setLine($k.line);
            $expressionRet = thisLoc;
        }
    |
        m=methodcall
        { $expressionRet = $m.methodCallRet; }
    |
        c=cons
        { $expressionRet = $c.constructorCallRet; }
    |
        p=LPAREN
        e=expr
        RPAREN
        { $expressionRet = $e.expressionRet; }
    |
        i=CONSTINT
        {
            $expressionRet = new IntLiteral(Integer.parseInt($i.text));
            $expressionRet.setLine($i.line);
        }
    |
        f=CONSTFLOAT
        {
            $expressionRet = new FloatLiteral(Float.parseFloat($f.text));
            $expressionRet.setLine($f.line);
        }
    |
        d=CONSTDOUBLE
        {
            $expressionRet = new DoubleLiteral(Double.parseDouble($d.text));
            $expressionRet.setLine($d.line);
        }
    |
        ch=CONSTCHAR
        {
            $expressionRet = new CharLiteral($ch.text.charAt(1));
            $expressionRet.setLine($ch.line);
        }
    |
        b=CONSTBOOL
        {
            $expressionRet = new BoolLiteral(Boolean.parseBoolean($b.text));
            $expressionRet.setLine($b.line);
        }
    |
        op=(MINUS | KW_NOT)
        e=expr
        {
            $expressionRet = new UnaryExpression($op.text, $e.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=(STAR | SLASH)
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, $op.text, $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=(PLUS | MINUS)
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, $op.text, $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=(LESS | GREATER | LESS_EQ | GREATER_EQ)
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, $op.text, $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=(EQUAL | NOT_EQUAL)
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, $op.text, $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=KW_AND
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, "and", $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
    |
        left=expr
        op=KW_OR
        right=expr
        {
            $expressionRet = new BinaryExpression($left.expressionRet, "or", $right.expressionRet);
            $expressionRet.setLine($op.line);
        }
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

updateExpr returns [AssignStmt updateExprRet]
    :
        l=loc
        a=ASSIGN
        e=expr
        {
            $updateExprRet = new AssignStmt($l.locationRet, $e.expressionRet);
            $updateExprRet.setLine($a.line);
        }
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