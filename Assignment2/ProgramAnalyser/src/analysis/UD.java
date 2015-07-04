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
import aexp.AExp;
import aexp.RD;
import aexp.Variable;

/**
 * @author grp6
 *
 */
public class UD extends Analysis<RD> {
	
	public UD(Statement S) {
		super(S);
		// TODO Auto-generated constructor stub
	}

	Set<Variable> get_fv_block(Block b){
		Set<Variable> fv_block = new HashSet<Variable>();
		
		if( b instanceof Asg){
			fv_block.addAll(b.getUsed());
			return fv_block;
		}
		
		if( b instanceof Cond){
			fv_block.addAll(b.getFV());
			return fv_block;
		}

		if( b instanceof flow.Skip){
			return fv_block;
		}
		
		return null;
	}
	
	public Map<Integer,Set<RD>> compute(Map<Integer,Set<RD>> rd_entry){
		
		Map<Integer,Set<RD>> UD = new HashMap<Integer, Set<RD>>();
		
		Iterator<Entry<Integer,Block>> it = blocks.entrySet().iterator();
		Entry<Integer,Block> entry;
		
		while(it.hasNext()){
			// x:=x+y :: Block by Block ::
			Set<Variable> block_fv = new HashSet<Variable>();
			
			entry = it.next();
			Block block = entry.getValue();
			Integer node = entry.getKey();
			block_fv.addAll(get_fv_block(block));
			
			Set<RD> empty_rd = new HashSet<RD>();
			UD.put(node, empty_rd);
			
			Iterator<Variable> iter_fv = block_fv.iterator();
			while(iter_fv.hasNext()){
				// x,y from (x+y) :: FV by FV  ::
				Set<RD> temp_rd = rd_entry.get(node);
				Variable used_var = iter_fv.next();
				
				Iterator<RD> iter_rd = temp_rd.iterator();
				while(iter_rd.hasNext()){
					// (x,2) from RD entry
					RD rd = iter_rd.next();
					if(rd.getVariable().equals(used_var)){
						UD.get(node).add(rd);
					}
				}
			}
		}
		
		//System.out.println("\nUD chain:\n" +UD);
		return UD;
		
	}
	
}
