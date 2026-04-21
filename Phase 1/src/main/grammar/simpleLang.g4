grammar simpleLang;

@header{
    package main.grammar;
    import main.ast.*;
}

// Parser rules
program returns [Program programRet]
    :
;

// Lexer rules

// 1- General structure
MAIN : 'main';
INT : 'int';
BOOL : 'bool';
IF : 'if';
ELSE : 'else';
TRUE : 'true';
FALSE : 'false';
// new
MODULE: 'module';
BEGIN: 'begin';
END: 'end';
INCLUDES: 'includes';
STRUCT: 'struct';
PUBLIC: 'public';
PRIVATE: 'private';
MUT: 'mut';
VOID: 'void';
ELIF: 'elif';
WHILE: 'while';
FOR: 'for';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';
THIS: 'this';
OUTPUT: 'output';
FLOAT: 'float';
DOUBLE: 'double';
CHAR: 'char';


// 2- Symbols
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
ASSIGN : '=';
PLUS : '+';
LPAR : '(';
RPAR : ')';
// new
MINUS: '-';
MULT: '*';
DIV: '/';
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';
EQ: '=='; 
NEQ: '!=';
DOT: '.';
COMMA: ','; 
MOD: '%'; 


// 3- Identifiers
ID : [a-zA-Z_][a-zA-Z0-9_]*;
INT_VAL : [0-9]+;
FLOAT_VAL : [0-9]+ '.' [0-9]+;
CHAR_VAL : '\'' . '\'';


// 4- Whitespace and comments
WHITE_SPACE : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;


