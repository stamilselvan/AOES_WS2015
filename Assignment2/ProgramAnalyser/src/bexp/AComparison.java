package bexp;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;

public class AComparison extends BExp {
	// arithmetic comparisons consist of a left expression, a comparator, and a right expressions
	AExp left;
	AComparator comparator;
	AExp right;
	
	public AComparison(AExp l, AComparator c, AExp r){
		left = l;
		comparator = c;
		right = r;
	}
	
	@Override
	public BExp copy() {
		return new AComparison(left.copy(),comparator,right.copy());
	}
	
	@Override
	public BExp subst(String var, AExp e) {
		return new AComparison(left.subst(var, e),comparator,right.subst(var, e));
	}

	String print(){
		String result;
		
		result = left.toString() + AComparator.printAComparator(comparator) + right.toString();
		
		return result;
	}

	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		aexp.addAll(left.getArithExpr());
		aexp.addAll(right.getArithExpr());
		
		return aexp;
	}
	
	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		fv.addAll(left.getFV());
		fv.addAll(right.getFV());
		
		return fv;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comparator == null) ? 0 : comparator.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
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
		AComparison other = (AComparison) obj;
		if (comparator != other.comparator)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	
}
