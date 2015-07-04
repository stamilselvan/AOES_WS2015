/**
 * 
 */
package aexp;

/**
 * @author grp6
 *
 */
public class AsgConst {
	
	Variable var;
	Constant value;

	/**
	 * @return the var
	 */
	public Variable getVar() {
		return var;
	}
	/**
	 * @param var the var to set
	 */
	public void setVar(Variable var) {
		this.var = var;
	}
	/**
	 * @return the value
	 */
	public Constant getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Constant value) {
		this.value = value;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((var == null) ? 0 : var.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AsgConst)) {
			return false;
		}
		AsgConst other = (AsgConst) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		if (var == null) {
			if (other.var != null) {
				return false;
			}
		} else if (!var.equals(other.var)) {
			return false;
		}
		return true;
	}
	
	
	
}
