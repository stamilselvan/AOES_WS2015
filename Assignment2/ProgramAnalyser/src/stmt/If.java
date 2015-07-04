package stmt;

import java.util.*;

import flow.*;
import aexp.AExp;
import bexp.BExp;

public class If extends Statement {
	// If-statements consist of a condition, a then branch, an else branch, and possibly a label
	private BExp cond;
	private Statement thenS;
	private Statement elseS;
	int label=-1;
	
	public If(BExp c, Statement t, Statement e){
		cond = c;
		thenS = t;
		elseS = e;
	}
	
	@Override
	public Statement copy() {
		If c = new If(cond.copy(),thenS.copy(),elseS.copy());
		c.label = label;
		return c;
	}

	@Override
	public void subst(int lab, String var, AExp e) {
		if(label == lab){
			cond = cond.subst(var, e);
		} else {
			thenS.subst(lab, var, e);
			elseS.subst(lab, var, e);
		}
	}

	String print(String offset){
		String result;
		
		if(label > 0){
			result = offset + "if [" + cond.toString() + "]^" + Integer.toString(label) + "\n" +
		             offset + "then \n" +
					 thenS.print(offset + "  ") + "\n" + 
		             offset + "else \n" + 
					 elseS.print(offset + "  ") + "\n" +
					 offset + "fi";
		} else {
			result = offset + "if (" + cond.toString() + ")\n" + 
		             offset + "then \n" + 
					 thenS.print(offset + "  ") + "\n" + 
					 offset + "else \n" + 
					 elseS.print(offset + "  ") + "\n" +
					 offset + "fi";
		}
		
		return result;
	}
	
	int labelling(int offset){
		label = offset;
		
		int tmp = thenS.labelling(offset+1);
		    tmp = elseS.labelling(tmp);
		
		return tmp;
	}
	
	
	Set<Integer> labels(Map<Integer,Block> map){
		Set<Integer> l = new HashSet<Integer>();
		l.add(label);
		
		map.put(label, new Cond(cond,label));
		
		l.addAll(thenS.labels(map));
		l.addAll(elseS.labels(map));
		
		return l;
	}
	
	Set<Edge> flow(){
		Set<Edge> f = new HashSet<Edge>();
		
		f.add(new Edge(label,thenS.init()));
		f.add(new Edge(label,elseS.init()));
		f.addAll(thenS.flow());
		f.addAll(elseS.flow());
		
		return f;
	}
	
	Integer init(){
		Integer i = label;
		
		return i;
	}
	
	Set<Integer> finals(){
		Set<Integer> f = new HashSet<Integer>();
		
		f.addAll(thenS.finals());
		f.addAll(elseS.finals());
		
		return f;
	}
}
