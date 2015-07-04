package aexp;

import java.util.*;

public class AComp extends AExp {
	// compound arithmetic expressions consist of a left operand,
	// an arithmetic operator, and a right operand
	AExp left;
	AOp op;
	AExp right;
	
	public AComp(AExp l, AOp o, AExp r){
		left = l;
		op = o;
		right = r;
	}
	
	@Override
	public AExp copy() {
		return new AComp(left.copy(),op,right.copy());
	}

	@Override
	public AExp subst(String var, AExp e) {
		return new AComp(left.subst(var, e),op,right.subst(var, e));
	}

	String print(){
		String result;
		
		result = "(" + left.print() + AOp.printAOp(op) + right.print() + ")";
		
		return result;
	}

	
	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		fv.addAll(left.getFV());
		fv.addAll(right.getFV());
		
		return fv;
	}
	
	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		aexp.addAll(left.getArithExpr());
		aexp.addAll(right.getArithExpr());
		aexp.add(this);
		
		return aexp;
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
		AComp other = (AComp) obj;
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
