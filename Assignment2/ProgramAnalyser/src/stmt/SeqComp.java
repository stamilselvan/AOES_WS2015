package stmt;

import java.util.*;

import aexp.AExp;
import flow.*;

public class SeqComp extends Statement {
	// a sequential composition has a left hand statement and a right hand statement
	private Statement left;
	private Statement right;
	
	public SeqComp(Statement l, Statement r){
		left = l;
		right = r;
	}
	
	@Override
	public Statement copy() {
		SeqComp c = new SeqComp(left.copy(),right.copy());
		return c;
	}

	@Override
	public void subst(int lab, String var, AExp e) {
		left.subst(lab, var, e);
		right.subst(lab, var, e);
	}

	String print(String offset){
		String result;
		
		result = left.print(offset) + "; \n" + 
		         right.print(offset);
				
		return result;
	}
	
	int labelling(int offset){
		int tmp = left.labelling(offset);
		    tmp = right.labelling(tmp);
		
		return tmp;
	}
	
	
	Set<Integer> labels(Map<Integer,Block> map){
		Set<Integer> l = new HashSet<Integer>();
		
		l.addAll(left.labels(map));
		l.addAll(right.labels(map));
		
		return l;
	}
	
	Set<Edge> flow(){
		Set<Edge> f = new HashSet<Edge>();
		
		Iterator<Integer> it = left.finals().iterator();
		Integer fin;
		Integer in = right.init();
		
		while(it.hasNext()){
			fin = it.next();
			f.add(new Edge(fin,in));
		}
		
		f.addAll(left.flow());
		f.addAll(right.flow());
		
		return f;
	}
	
	Integer init(){
		Integer i;
		
		i = left.init();
		
		return i;
	}
	
	Set<Integer> finals(){
		Set<Integer> f = new HashSet<Integer>();
		
		f.addAll(right.finals());
		
		return f;
	}
}
