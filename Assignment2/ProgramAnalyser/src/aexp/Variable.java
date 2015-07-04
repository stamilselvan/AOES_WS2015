package aexp;

import java.util.HashSet;
import java.util.Set;

public class Variable extends AExp {
	// a variable only has a name
	String name;
	
	public Variable(String n){
		name = n;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public AExp copy() {
		return new Variable(name);
	}
	
	@Override
	public AExp subst(String var, AExp e) {
		if(name.equals(var)){ 
			return e.copy();
		} else return this.copy();
	}

	String print(){
		String result;
		
		result = name;
		
		return result;
	}

	@Override
	public Set<Variable> getFV() {
		Set<Variable> fv = new HashSet<Variable>();
		
		fv.add(this);
		
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
