grammar Sample;

prog: expr;
expr: term (('+'|'-') term)*;
term: factor (('*'|'/') factor)*;
factor: INT
    | '(' expr ')'
    ;
INT     : [0-9]+ ;