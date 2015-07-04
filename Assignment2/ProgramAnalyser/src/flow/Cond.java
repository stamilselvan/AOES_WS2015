package flow;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;
import bexp.*;

// a conditional block
public class Cond extends Block {
	// a conditional block contains a boolean condition
	BExp cond;
	
	public Cond(BExp c, int l){
		cond = c;
		label = l;
	}
	
	public BExp getCond(){
		return cond;
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
	public Set<Variable> getUsed() {
		Set<Variable> res = new HashSet<Variable>();
		res.addAll(cond.getFV());

		return res;
	}
}
