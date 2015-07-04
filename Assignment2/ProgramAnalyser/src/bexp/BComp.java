package bexp;

import java.util.*;

import aexp.AExp;
import aexp.Variable;

public class BComp extends BExp {
	BExp left;
	BBinOp op;
	BExp right;
	
	public BComp(BExp l, BBinOp o, BExp r){
		left = l;
		op = o;
		right = r;
	}
	
	@Override
	public BExp copy() {
		return new BComp(left.copy(),op,right.copy());
	}
	
	@Override
	public BExp subst(String var, AExp e) {
		return new BComp(left.subst(var, e),op,right.subst(var, e));
	}

	public String print(){
		String result;
		
		result = "(" + left.print() + BBinOp.printBBinOp(op) + right.print() + ")";
		
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
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((op == null) ? 0 : op.hashCode());
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
		BComp other = (BComp) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (op != other.op)
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	
}
