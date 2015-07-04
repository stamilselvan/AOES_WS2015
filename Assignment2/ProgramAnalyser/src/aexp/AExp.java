package aexp;

import java.util.*;

// (abstract) class for arithmetic expressions
public abstract class AExp {
	// get all free variables
	public abstract Set<Variable> getFV();
	
	// get all non-trivial arithmetic (sub-) expressions
	public abstract Set<AExp> getArithExpr();
	
	// return a copy of this boolean expression
	public abstract AExp copy();
	
	// return this expression with all variables with name var
	// replaced by the arithmetic expression e
	public abstract AExp subst(String var, AExp e);
	
	@Override
	public final String toString() {
		return print();
	}
	
	// should be overwritten in subclasses
	abstract String print();
}
