grammar WHILE;

@header{
package parser;

import stmt.*;
import aexp.*;
import bexp.*;
}

statement returns [Statement s]
	      : 'skip' 																{ $s = new Skip(); }
          | v=ID ':=' x=aExp													{ $s = new Assignment(new Variable($v.text),$x.e); }
          | 'if' '(' b=bExp ')' 'then' s1=statement 'else' s2=statement			{ $s = new If($b.e,$s1.s,$s2.s); }
          | 'if' '(' b=bExp ')' 'then' s1=statement 'else' s2=statement 'fi'	{ $s = new If($b.e,$s1.s,$s2.s); }
          | 'while' '(' b=bExp ')' 'do' s1=statement							{ $s = new While($b.e,$s1.s); }
          | 'while' '(' b=bExp ')' 'do' s1=statement 'od'						{ $s = new While($b.e,$s1.s); }
          | s1=statement ';' s2=statement										{ $s = new SeqComp($s1.s,$s2.s); }
          | '{' s1=statement '}'												{ $s = $s1.s; } 
          ;

bExp returns [BExp e]
	 : 'true' 								{ $e = new True(); }
     | 'false'								{ $e = new False(); }
     | b1=bExp o=bBinop b2=bExp 			{ $e = new BComp($b1.e,$o.op,$b2.e); }
     | 'not' '(' b=bExp ')'					{ $e = new Neg($b.e); }
     | a1=aExp c=aComparator a2=aExp		{ $e = new AComparison($a1.e,$c.op,$a2.e); }
     | '(' b=bExp ')'						{ $e = $b.e; }
     ;

aExp returns [AExp e]
     : v=ID								{ $e = new Variable($v.text); }
     | x=NUM							{ $e = new Constant(Integer.parseInt($x.text)); }
     | a1=aExp o=aOp a2=aExp 			{ $e = new AComp($a1.e,$o.op,$a2.e); }
     | '(' a=aExp ')'					{ $e = $a.e; }
     ;

aComparator returns [bexp.AComparator op] 
		: '<' 	{ $op = bexp.AComparator.less; } 
        | '<='  { $op = bexp.AComparator.leq; }
        | '='  	{ $op = bexp.AComparator.eq; }
        | '=='  { $op = bexp.AComparator.eq; }
        | '>='  { $op = bexp.AComparator.geq; }
        | '>' 	{ $op = bexp.AComparator.greater; }
        ;
         
bBinop returns [bexp.BBinOp op]
		: 'and' { $op = bexp.BBinOp.and; }
		| 'or'	{ $op = bexp.BBinOp.or; }
		;

aOp returns [aexp.AOp op]
		: '+' 	{ $op = aexp.AOp.plus; }
		| '-' 	{ $op = aexp.AOp.minus; }
		| '*' 	{ $op = aexp.AOp.mult; }
		| '/' 	{ $op = aexp.AOp.div; }
		;


NUM: [0] | [1-9][0-9]* ;
ID : [A-Z,a-z]+ ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
