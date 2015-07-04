package stmt;

import java.util.*;

import aexp.*;
import flow.*;

public class Assignment extends Statement {
	// Assignments consist of a variable, an arithmetic expression, and (possibly) a label
	private Variable var;
	private AExp expr;
	private int label=-1;
	
	// the attributes are only the in the constructor
	public Assignment(Variable v, AExp e){
		var = v;
		expr = e;
	}
	
	@Override
	public Statement copy() {
		Assignment c= new Assignment((Variable) var.copy(),expr.copy());
		c.label = label;
		return c;
	}

	@Override
	public void subst(int lab, String var, AExp e) {
		if(label==lab){
			expr = expr.subst(var, e);
		}
	}

	String print(String offset){
		String result;
		
		// if a proper label was given
		if(label > 0){
			result = offset + "[" + var.toString() + ":=" + expr.toString() + "]^" + Integer.toString(label);	
		} else{
			result = offset + var.toString() + ":=" + expr.toString();	
		}
		
		return result;
	}
	
	
	int labelling(int offset){
		label = offset;
		return offset+1;
	}
	
	
	Set<Integer> labels(Map<Integer,Block> map){
		Set<Integer> l = new HashSet<Integer>();
		l.add(label);
		
		map.put(label, new Asg(var,expr,label));
		
		return l;
	}
	
	Set<Edge> flow(){
		Set<Edge> f = new HashSet<Edge>();
		return f;
	}
	
	Integer init(){
		Integer i = label;
		
		return i;
	}
	
	Set<Integer> finals(){
		Set<Integer> f = new HashSet<Integer>();
		f.add(label);
		
		return f;
	}
	
}
