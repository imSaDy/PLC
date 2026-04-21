grammar simpleLang;

@header{
    package main.grammar;
    import main.ast.*;
}

// Parser rules
program returns [Program programRet]
    : top_dec+ EOF
;
top_dec
    : module_dec | struct_dec
;
struct_dec
    : STRUCT ID BEGIN field_dec* END
;
field_dec
    : access? MUT? type ID SEMI
;
access
    : PUBLIC | PRIVATE
;
type
    : INT | FLOAT | DOUBLE | CHAR | BOOL | ID
;
module_dec
    : MODULE ID (INCLUDES id_list)? BEGIN module_body* END
;
id_list
    : ID (COMMA ID)* 
;
module_body
    : field_dec | method_dec
;
method_dec
    : access? (VOID | type)? ID LPAR parameters? RPAR BEGIN stmt* END
;
parameters
    : parameter (COMMA parameter)*
;
parameter
    : MUT? type ID
;
stmt 
    : assignment SEMI | if_stmt | while_stmt | for_stmt | return_stmt | output_stmt | break_stmt | continue_stmt | expr SEMI | var_dec SEMI
;
assignment
    : expr ASSIGN expr
;
if_stmt
    : IF LPAR expr RPAR BEGIN stmt* END (ELIF LPAR expr RPAR BEGIN stmt* END)* (ELSE BEGIN stmt* END)?
;
while_stmt
    : WHILE LPAR expr RPAR BEGIN stmt* END
;
for_stmt 
    : FOR LPAR assign_part? SEMI cond_part? SEMI update_part? RPAR BEGIN stmt* END
;
assign_part
    : (assignment | var_dec) (COMMA (assignment | var_dec))*
;
cond_part
    : expr (COMMA expr)*
;
update_part 
    : assignment (COMMA assignment)*
;
return_stmt 
    : RETURN expr? SEMI
;
output_stmt 
    : OUTPUT expr SEMI
;
break_stmt 
    : BREAK SEMI
;
continue_stmt
    : CONTINUE SEMI
;
var_dec
    : MUT? type (LPAR args? RPAR)? ID (ASSIGN expr)? 
;
args 
    : expr (COMMA expr)*
;
expr
    : LPAR expr RPAR
    | THIS
    | INT_VAL 
    | FLOAT_VAL 
    | CHAR_VAL 
    | TRUE 
    | FALSE 
    | ID 
    | expr DOT ID (LPAR args? RPAR)? 
    | ID LPAR args? RPAR
    | MINUS expr
    | expr (MULT | DIV | MOD) expr
    | expr (PLUS | MINUS) expr
    | expr (GT | LT | GE | LE) expr
    | expr (EQ | NEQ) expr 
;



// Lexer rules

// 1- General structure
// MAIN : 'Main';
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


