package aexp;

//arithmetic operators 
public enum AOp { 
	plus, minus, mult, div; 

	public static String printAOp(AOp o){
		switch(o){
		case plus: return "+";
		case minus: return "-";
		case mult: return "*";
		case div: return "/";
		default: return "not implemented";
		}
	}
}
