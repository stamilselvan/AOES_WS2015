/**
 * 
 */
package analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

import stmt.Statement;
import flow.Asg;
import flow.Block;
import flow.Cond;
import flow.Edge;
import aexp.*;

/**
 * @author grp6
 *
 */
public class AvailableExpressions extends Analysis<AExp> {
	
	public AvailableExpressions(Statement S) {
		super(S);
		// TODO Auto-generated constructor stub
	}

	@Override
	Set<AExp> kill(Block b){
		Set<AExp> kills = new HashSet<AExp>();
		
		if( b instanceof Asg){
			/* All the expressions in the program, that have,
			 * LHS var of this Asg are killed
			 * */	
			Variable lhs_var = ((Asg) b).getVar();

			Iterator<Entry<Integer,Block>> it = blocks.entrySet().iterator();
			Entry<Integer,Block> entry;
			
			while(it.hasNext()){
				entry = it.next();
				Block iter_blocks = entry.getValue();		
				
				Set<AExp> aexps_in_block = new HashSet<AExp>(); 
				aexps_in_block.addAll((Set<AExp>) iter_blocks.getArithExpr());
				
				Iterator<AExp> iter_aexp = aexps_in_block.iterator();
				while(iter_aexp.hasNext()){
					AExp temp = iter_aexp.next();
					if(temp.getFV().contains(lhs_var)){
						kills.add(temp);
					}					
				}
			}
			
			return kills;
		}
		
		if( b instanceof Cond){
			// Nothing is killed in Cond block
			return kills;
		}

		if( b instanceof flow.Skip){
			// Nothing is killed in skip block
			return kills;
		}
		
		return null;
	}
	
	@Override
	Set<AExp> gen(Block b){
		Set<AExp> gens = new HashSet<AExp>();
		
		if( b instanceof Asg){
			Set<AExp> temp = new HashSet<AExp>(); 
			temp.addAll(b.getArithExpr());

			Variable var = ((Asg) b).getVar();
			Iterator<AExp> iter_aexp = temp.iterator();
			Set<AExp> remove = new HashSet<AExp>();
			
			while(iter_aexp.hasNext()){
				AExp del_exp = iter_aexp.next();
				if(del_exp.getFV().contains(var))
					remove.add(del_exp);
			}
			temp.removeAll(remove);

			gens.addAll(temp);
			return gens;
		}
		
		if( b instanceof Cond){
			Set<AExp> temp = b.getArithExpr();
			gens.addAll(temp);
			return gens;
		}

		if( b instanceof flow.Skip){
			// Nothing is generated in skip block
			return gens;
		}
		
		return null;
	}

	@Override
	public Map<Integer, Set<AExp>> analyse(){
		if (fg == null){
			System.err.println("The flow graph needs to be constructed using the method constructFlowGraph first.");
			return null;
		}
		
		// the analysis result is a mapping from the (entry or exit points of the) labels to sets of the AExp
		Map<Integer, Set<AExp>> entry = new HashMap<Integer, Set<AExp>>();
		Map<Integer, Set<AExp>> exit = new HashMap<Integer, Set<AExp>>();
			
		// construct the kill and gen tables
		Map<Integer,Set<AExp>> kills = getKill(blocks);
		Map<Integer,Set<AExp>> gens = getGen(blocks);

		Queue<Integer> wl = new LinkedList<Integer>();
		Set<AExp> all_aexp = new HashSet<AExp>();		
		
		int no_of_blocks = blocks.size();
		for(int x=1; x<=no_of_blocks; x++) {
			wl.add(x);
			all_aexp.addAll(blocks.get(x).getArithExpr());
		}
		
		for(int x=1; x<=no_of_blocks; x++)
			exit.put(x, all_aexp);

		Integer node;
		
		// No Exp is available at the beginning of entry block
		Set<AExp> set_aexp = new HashSet<AExp>();
		entry.put(fg.getInit(), set_aexp);
		
		while(!wl.isEmpty()){
			
			Set<AExp> in = new HashSet<AExp>();
			Set<AExp> temp_in = new HashSet<AExp>();
			Set<AExp> intersection = new HashSet<AExp>();
			
			node = wl.remove();
			wl.remove(node);
			
			// AEentry(l) = (intersection) AEexit(l')
			Iterator<Integer> iter_pred = pred.get(node).iterator();
			while(iter_pred.hasNext()){
				if(intersection.isEmpty())
					intersection.addAll(exit.get(iter_pred.next()));
				else 
					intersection.retainAll(exit.get(iter_pred.next()));
			}
			
			in.addAll(intersection);
			entry.put(node, (Set<AExp>) in);
			
			temp_in.addAll(in);
			Set<AExp> old_out = new HashSet<AExp>();
			Set<AExp> temp_gen = new HashSet<AExp>();
			
			old_out.addAll(exit.get(node));
			
			// AEexit(l) = (in  \kill) U gen;
			temp_gen.addAll(gens.get(node));
			temp_in.removeAll(kills.get(node));
			temp_gen.addAll(temp_in);
			
			exit.put(node, temp_gen);
			
			if(old_out.equals(exit.get(node))){
				/* 
				 * Nothing has changed. 
				 * No need to iterate.
				 */
			}
			else {
				// Iterate further. Add all succ nodes to worklist
				Iterator<Integer> iter_exp_node = succ.get(node).iterator();
				while(iter_exp_node.hasNext()){
					wl.add(iter_exp_node.next());
				}
			}
		}
		
		System.out.println("\nAExp information at the entry of Blocks \n" + entry + "\n");
		return exit;
	}
}
