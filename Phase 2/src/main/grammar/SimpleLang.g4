grammar SimpleLang;
@header {
    import main.ast.core.*;

    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;

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
        { $moduleRet = new Module(new Identifier($i.text));
        $moduleRet.setLine($i.line); }
        (KW_INCLUDES i1=ID { $moduleRet.addInclude(new Identifier($i1.text)); } (COMMA i2=ID { $moduleRet.addInclude(new Identifier($i2.text)); } )*)?
        KW_BEGIN
        (member)*
        KW_END

    ;

structDef returns [Struct structRet]
    :
        k=KW_STRUCT
        i=ID
        KW_BEGIN
        member*
        KW_END

    ;

member
    :
        accessModifier?
        m=method_decl

    |

        accessModifier?
        v=vardecl

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
        ID

    |
        KW_INT

    |
        KW_FLOAT

    |
       KW_DOUBLE

    |
        KW_CHAR

    |
        KW_VOID

    |
        KW_BOOL

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

forStmt
    :
        KW_FOR
        LPAREN
        (initexpr (COMMA initexpr)*)?
        SEMI
        (expr)?
        SEMI
        (loc ASSIGN expr (COMMA loc ASSIGN expr)*)?
        RPAREN
        st
    ;

whileStmt
    :
        KW_WHILE
        LPAREN
        expr
        RPAREN
        st
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

expr returns[Expression expressionRet]
    :
        loc

    |
        KW_THIS

    |
        methodcall

    |
        cons

    |
        LPAREN expr RPAREN

    |
        CONSTINT

    |
        CONSTFLOAT

    |
        CONSTDOUBLE

    |
        CONSTCHAR

    |
        CONSTBOOL

    |
        (MINUS | KW_NOT) expr

    |
        expr (STAR | SLASH) expr

    |
        expr (PLUS | MINUS) expr

    |
        expr (LESS | GREATER | LESS_EQ | GREATER_EQ) expr

    |
        expr (EQUAL | NOT_EQUAL) expr

    |
        expr KW_AND expr

    |
        expr KW_OR expr

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