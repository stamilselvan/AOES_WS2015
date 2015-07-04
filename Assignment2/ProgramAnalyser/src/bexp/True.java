package bexp;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;

public class True extends BExp {
	public True(){}
	
	@Override
	public BExp copy() {
		return new True();
	}
	
	@Override
	public BExp subst(String var, AExp e) {
		return new True();
	}

	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		return aexp;
	}
	
	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		return fv;
	}
	
	String print(){
		String result;
		
		result = "true";
		
		return result;
	}
}
