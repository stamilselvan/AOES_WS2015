package flow;

import java.util.*;
import aexp.*;

// (abstract) class of a block in a flow graph
public abstract class Block {
	// every block has a label
	int label;
	
	// return the variables that are read in this block
	public abstract Set<Variable> getUsed();
	
	// calculate the non-trivial arithmetic expressions of a block
	public abstract Set<AExp> getArithExpr();
	
	// calculate the set of free variables in this block
	public abstract Set<Variable> getFV();

	// return the label of this block 
	public int getLabel() {
		return label;
	}
}
