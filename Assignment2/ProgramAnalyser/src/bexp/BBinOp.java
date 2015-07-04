package bexp;

// binary boolean operators 
public enum BBinOp { 
	and, or; 
	
	public static String printBBinOp(BBinOp o){
		switch(o){
		case and: return " /\\ ";
		case or: return " \\/ ";
		default: return "not implemented";
		}
	}
}
