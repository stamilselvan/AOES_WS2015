package stmt;

import flow.*;

import java.util.*;

import aexp.AExp;

// abstract class for statements
public abstract class Statement {
	// return a copy of this statement
	// note that boolean and arithmetic expressions are also copied
	public abstract Statement copy();
	
	// in block with label lab, substitute each occurrence of variable with
	// arithmetic expression e
	public abstract void subst(int lab, String var, AExp e);
	
	// construct a flow graph of the statement
	public final FlowGraph constructFlowGraph(int start){
		// label the statement beginning with start
		this.labelling(start);
		
		// construct the set of labels and the mapping from labels to blocks
		Map<Integer,Block> map = new HashMap<Integer,Block>();
		Set<Integer> labels= new HashSet<Integer>();
		labels.addAll(labels(map));
		
		// construct the flow relation
		Set<Edge> flow = new HashSet<Edge>();
		flow.addAll(flow());
		
		// calculate the initial label
		int init = init();
		
		// calculate the finals labels
		Set<Integer> finals = new HashSet<Integer>();
		finals.addAll(finals());
		
		// collect everything in a flow graph
		FlowGraph fg = new FlowGraph();
		fg.setLabels(labels);
		fg.setFlow(flow);
		fg.setInit(init);
		fg.setFinals(finals);
		fg.setBlocks(map);
		
		// return the constructed flow graph
		return fg;
	}
	
	@Override
	public final String toString() {
		return print("");
	}
	
	// print the statement in a string (should be redefined in subclasses)
	abstract String print(String offset);
	// uniquely label all blocks in the statement beginning with "start"
	// the return value gives the last used label in the labelling + 1
	abstract int labelling(int start);
	// construct the set of labels of the statement and produce a mapping from labels to blocks
	abstract Set<Integer> labels(Map<Integer,Block> map);
	// construct the set of flow edges
	abstract Set<Edge> flow();
	// return the initial label
	abstract Integer init();
	// return the set of final labels
	abstract Set<Integer> finals();
}
