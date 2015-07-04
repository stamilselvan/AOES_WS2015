package aexp;

import java.util.HashSet;
import java.util.Set;

public class Constant extends AExp {
	// a constant only holds an integer value
	int val;
  
	public Constant(int v){
		val = v;
	}
	
	@Override
	public AExp copy() {
		return new Constant(val);
	}
  
	@Override
	public AExp subst(String var, AExp e){
		return new Constant(val);
	}

	String print(){
		String result;
			
		result = Integer.toString(val);
			
		return result;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
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
		Constant other = (Constant) obj;
		if (val != other.val)
			return false;
		return true;
	}

}
