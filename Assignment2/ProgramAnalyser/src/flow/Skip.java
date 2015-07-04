package flow;

import java.util.HashSet;
import java.util.Set;

import aexp.AExp;
import aexp.Variable;

// a skip block
public class Skip extends Block {
	
	public Skip(int l){
		label = l;
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
	
	@Override
	public Set<Variable> getUsed() {
		Set<Variable> res = new HashSet<Variable>();
		
		return res;
	}
}
