package bexp;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;

public class Neg extends BExp {
	// negation of a condition
	BExp cond;
	
	public Neg(BExp c){
		cond = c;
	}
	
	@Override
	public BExp copy() {
		return new Neg(cond.copy());
	}
	
	@Override
	public BExp subst(String var, AExp e) {
		return new Neg(cond.subst(var, e));
	}

	String print(){
		String result;
		
		result = "not(" + cond.print() + ")";
		
		return result;
	}

	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		fv.addAll(cond.getFV());
		
		return fv;
	}
	
	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		aexp.addAll(cond.getArithExpr());
		
		return aexp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cond == null) ? 0 : cond.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Neg other = (Neg) obj;
		if (cond == null) {
			if (other.cond != null)
				return false;
		} else if (!cond.equals(other.cond))
			return false;
		return true;
	}
	
	
}
