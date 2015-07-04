package bexp;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;

public class False extends BExp {
	public False(){}
	
	@Override
	public BExp copy() {
		return new False();
	}
	
	@Override
	public BExp subst(String var, AExp e) {
		return new False();
	}

	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		return fv;
	}

	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		return aexp;
	}
	
	String print(){
		String result;
		
		result = "false";
		
		return result;
	}
}
