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

// 2- Symbols
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
ASSIGN : '=';
PLUS : '+';
LPAR : '(';
RPAR : ')';

// 3- Identifiers
ID : [a-zA-Z_][a-zA-Z0-9_]*;
INT_VAL : [0-9]+;

// 4- Whitespace and comments
WHITE_SPACE : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;