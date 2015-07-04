package stmt;

import java.util.*;

import flow.*;
import aexp.AExp;
import bexp.BExp;

public class While extends Statement {
	// While loops consist of a condition, a body, and possibly a label
	BExp cond;
	Statement body;
	int label=-1;
	
	public While(BExp c, Statement b){
		cond = c;
		body = b;
	}
	
	@Override
	public Statement copy() {
		While c = new While(cond.copy(), body.copy());
		c.label = label;
		return c;
	}

	@Override
	public void subst(int lab, String var, AExp e) {
		if(label == lab){
			cond = cond.subst(var, e);
		} else{
			body.subst(lab, var, e);
		}
	}

	String print(String offset){
		String result;
		
		if(label>0){
			result = offset + "while( [" + cond.toString() + "]^" + Integer.toString(label) + ") \n" +
		             offset + "do \n" +
		             body.print(offset + "  ") + "\n" +
		             offset + "od";
		}else {
			result = offset + "while (" + cond.toString() + ") \n"+ 
					 offset + "do \n" + 
		             body.print(offset + "  ") + "\n" +
		             offset + "od";
		}
	    
		return result;
	}
	
	int labelling(int offset){
		label = offset;
		
		int tmp = body.labelling(offset+1);
		return tmp;
	}
	
	
	Set<Integer> labels(Map<Integer,Block> map){
		Set<Integer> l = new HashSet<Integer>();
		
		map.put(label, new Cond(cond,label));
		
		l.add(label);
		l.addAll(body.labels(map));
		
		return l;
	}
	
	Set<Edge> flow(){
		Set<Edge> f = new HashSet<Edge>();
		
		f.add(new Edge(label,body.init()));
		f.addAll(body.flow());
		
		Iterator<Integer> it = body.finals().iterator();
		Integer fin;
		
		while(it.hasNext()){
			fin = it.next();
			f.add(new Edge(fin,label));
		}
		
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
