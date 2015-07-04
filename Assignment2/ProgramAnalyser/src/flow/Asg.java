package flow;

import java.util.*;

import aexp.*;

// an assignment block
public class Asg extends Block {
	// an assignment (var:=expr) consists of a variable (var) and an arithmetic expression (expr)
	Variable var;
	AExp expr;
	
	public Asg(Variable v, AExp e, int l){
		var = v;
		expr = e;
		label = l;
	}

	public Variable getVar() {
		return var;
	}

	public AExp getExpr() {
		return expr;
	}

	
	
	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		fv.add(var);
		fv.addAll(expr.getFV());
		
		return fv;
	}

	@Override
	public Set<AExp> getArithExpr() {
		Set<AExp> aexp = new HashSet<AExp>();
		
		aexp.addAll(expr.getArithExpr());
		
		return aexp;
	}

	@Override
	public Set<Variable> getUsed() {
		Set<Variable> res = new HashSet<Variable>();
		res.addAll(expr.getFV());

		return res;
	}
	
	
}
