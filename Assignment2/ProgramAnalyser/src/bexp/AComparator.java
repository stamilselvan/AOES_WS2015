package bexp;

// arithmetic comparators
public enum AComparator { 
	less, leq , eq, geq, greater; 
	
	public static String printAComparator(AComparator c){
		switch(c){
		case less: return "<";
		case leq: return "<=";
		case eq: return "=";
		case geq: return ">=";
		case greater: return ">";
		default: return "not implemented";
		}
	}
}
