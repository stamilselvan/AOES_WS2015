/**
 * 
 */
package analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import stmt.Statement;
import flow.Asg;
import flow.Block;
import flow.Cond;
import aexp.RD;
import aexp.Variable;

/**
 * @author grp6
 *
 */
public class DU extends Analysis<RD>{
	
	public DU(Statement S) {
		super(S);
		// TODO Auto-generated constructor stub
	}

	Variable get_var_block(Block b){
		
		if( b instanceof Asg){
			return ((Asg) b).getVar();
		}
		
		if( b instanceof Cond){
			return null;
		}
	
		if( b instanceof flow.Skip){
			return null;
		}
		
		return null;
	}
	
	public Map<Integer,Set<RD>> compute(Map<Integer,Set<RD>> UD){
		
		Map<Integer,Set<RD>> DU = new HashMap<Integer, Set<RD>>();
		
		Iterator<Entry<Integer,Block>> it = blocks.entrySet().iterator();
		Entry<Integer,Block> entry;
		
		for(int i=1; i<=blocks.size(); i++){
			Set<RD> empty = new HashSet<RD>();
			DU.put(i, empty);
		}
		
		while(it.hasNext()){
			// x:=x+y :: Block by Block ::
			Variable block_def;
			RD this_rd = new RD();
			
			
			entry = it.next();
			Block block = entry.getValue();
			Integer node = entry.getKey();
			block_def = get_var_block(block);
			
			if(block_def != null){
				this_rd.setLabel(node);
				this_rd.setVariable(block_def);
				
				for(int i=1; i<=blocks.size(); i++){
					if(UD.get(i).contains(this_rd)){
						RD temp = new RD();
						temp.setLabel(i);
						temp.setVariable(block_def);
						DU.get(node).add(temp);
					}
				}
			}
			
		}
		
		//System.out.println("\nDU chain:\n" +DU);
		return DU;
		
	}

}
