package stmt;

import java.util.*;

import aexp.AExp;
import flow.*;

public class Skip extends Statement {
	// skip has only a label
	private int label=-1;
	
	public Skip(){}
	
	@Override
	public Statement copy() {
		Skip c= new Skip();
		c.label = -1;
		return c;
	}

	@Override
	public void subst(int lab, String var, AExp e) {}

	@Override
	String print(String offset){
		String result;
		
		if(label>0){
			result = offset + "[skip]^" + Integer.toString(label);
		}else {
			result = offset + "skip";	
		}
		
		return result;
	}
	
	public int labelling(int offset){
		label = offset;
		return offset+1;
	}
	
	
	public Set<Integer> labels(Map<Integer,Block> map){
		Set<Integer> l = new HashSet<Integer>();
		l.add(label);
		
		map.put(label, new flow.Skip(label));
		
		return l;
	}
	
	public Set<Edge> flow(){
		Set<Edge> f = new HashSet<Edge>();
		
		return f;
	}
	
	public Integer init(){
		Integer i = label;
		
		return i;
	}
	
	public Set<Integer> finals(){
		Set<Integer> f = new HashSet<Integer>();
		
		f.add(label);
		
		return f;
	}
}
