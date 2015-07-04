package bexp;

import java.util.*;

import aexp.*;

//(abstract) class for boolean expressions
public abstract class BExp {

	// get all free variables
	public abstract Set<Variable> getFV();
	
	// return a copy of this boolean expression
	public abstract BExp copy();
		
	// return this expression with all variables with name var
	// replaced by the arithmetic expression e
	public abstract BExp subst(String var, AExp e);
	
	// get all non-trivial arithmetic expressions
	public abstract Set<AExp> getArithExpr();
	
	@Override
	public final String toString() {
		return print();
	}
	
	abstract String print();
}
