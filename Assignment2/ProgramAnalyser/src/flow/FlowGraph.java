package flow;

import java.util.*;

public class FlowGraph {
	// a flow graph consists of its labels, its flow relation, its reversed flow relation,
	// its initial label, its final labels, and a mapping from labels to blocks
	Set<Integer> labels;
	Set<Edge> flow;
	Set<Edge> flowR;
	Integer init;
	Set<Integer> finals;
	Map<Integer,Block> blocks;
	
	public FlowGraph(){	
		labels = new HashSet<Integer>();
		flow = new HashSet<Edge>();
		flowR = new HashSet<Edge>();
		init = -1;
		finals = new HashSet<Integer>();
		blocks = null;
	}
	
	public void setLabels(Set<Integer> l) {
		labels.clear();
		labels.addAll(l);
	}

	public void setFlow(Set<Edge> f) {
		flow.clear();
		flow.addAll(f);
		
		// calculate a new reversed flow relation
		flowR.clear();
				
		// reverse all flow edges and add them to flowR
		Iterator<Edge> it = flow.iterator();
		Edge e;
		while(it.hasNext()){
			e = it.next();
			flowR.add(e.reversed());
		}
	}

	public void setInit(Integer i) {
		init = i;
	}

	public void setFinals(Set<Integer> f) {
		finals.clear();
		finals.addAll(f);
	}

	//TODO: the map should be copied
	public void setBlocks(Map<Integer,Block> m){
		blocks = m;
	}

	public Set<Integer> getLabels(){
		Set<Integer> l = new HashSet<Integer>();
		l.addAll(labels);
		return l;
	}
	
	public Set<Edge> getFlow(){
		Set<Edge> f = new HashSet<Edge>();
		f.addAll(flow);
		return f;
	}
	
	public Set<Edge> getFlowR(){
		Set<Edge> f = new HashSet<Edge>();
		f.addAll(flowR);
		return f;
	}
	
	
	public int getInit(){
		return init;
	}
	
	public Set<Integer> getFinals(){
		Set<Integer> f = new HashSet<Integer>();
		f.addAll(finals);
		return f;
	}
		
	// TODO: the map should be copied
	public Map<Integer,Block> getBlocks(){
		return blocks;
	}
}
