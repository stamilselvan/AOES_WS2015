package test;

import aexp.*;
import stmt.*;

import java.io.FileReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.*;
import analysis.*;

import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		testLive("program1.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testLive("program2.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testAvail("program2.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testAvail("program3.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testDominator("program4.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testReaching("program5.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testReaching("program6.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		testFolding("program6.txt");
		System.out.println("--------------------------------------------------------------------------\n");
		//testGeneric();
	}
	
	public static void testLive(String file){
		
		Statement s = Parse(file);
		
		LiveVariables a = new LiveVariables(s);
		
		System.out.println("Performing a live variables analysis on the following program: \n");
		
		System.out.println(s);
		
		Map<Integer,Set<Variable>> res = a.analyse();
		
		System.out.println("Live Variable(s) at the exit of blocks:");
		
		System.out.println(res);
	}
	
	public static void testAvail(String file){
		
		Statement s = Parse(file);
		
		AvailableExpressions a = new AvailableExpressions(s);
				
		System.out.println("Performing an available expressions analysis on the following program: \n");
		
		System.out.println(s);
		
		Map<Integer,Set<AExp>> res = a.analyse();
		
		System.out.println("AExp information at the exit of Blocks \n" + res + "\n");
	}
	
	public static void testDominator(String file){
		
		Statement s = Parse(file);
		
		Dominator a = new Dominator(s);
		
		System.out.println("Performing a Dominator analysis on the following program: \n");
		
		System.out.println(s);
		
		Map<Integer,Set<Integer>> res = a.analyse();
		
		System.out.println("\nResult of dominator analysis\n");
		
		System.out.println(res);
	}
	
	public static Map<Integer,Set<RD>> testReaching(String file){
		
		Statement s = Parse(file);
		
		ReachingDefinition a = new ReachingDefinition(s);
				
		System.out.println("Performing Reaching Definition analysis on the following program:");
		
		System.out.println(s);
		
		Map<Integer,Set<RD>> RD = a.analyse();
		
		System.out.println("\nRD at the entry of Blocks \n" + RD + "\n");
		
		UD computeUD = new UD(s);
		Map<Integer,Set<RD>> UD = computeUD.compute(RD);
		System.out.println("The use-definition chains are the following:");
		System.out.println(UD + "\n");
		System.out.println("Explanation: 3=[(x,5), (y,2), (x,1)] means "
				+ "label 3, is using x defined at label 5 and label 1, using y defined at label 2. \n");

		DU computeDU = new DU(s);
		Map<Integer,Set<RD>> DU = computeDU.compute(UD);
		System.out.println("The definition-use chains are the following:");
		System.out.println(DU + "\n");
		System.out.println("Explanation: 1=[(x,4), (x,5), (x,3)] means "
				+ "x defined at label 1 is used by labels 4,5,3. \n");
		
		return UD;
	}
	
	public static void testFolding(String file){
		
		Map<Integer,Set<RD>> UD = testReaching(file);

		Statement s = Parse(file);
		ConstantFolding CF = new ConstantFolding(s);
		
		System.out.println("Performing Constant Folding on the following program: \n");
		System.out.println(s);
		System.out.println("");
		
		Statement s1= CF.optimise(UD);
		
		System.out.println("The optimised program is the following: \n");
		System.out.println(s1);
	}
	
	public static void testGeneric(){
		JFrame parent  = new JFrame();
				
		Object[] options = {"Live Variables",
                			"Available Expressions",
                			"Dominator",
                			"Reaching Definitions",
                			"Constant Folding"
                			};
		int n = JOptionPane.showOptionDialog(parent,
				"Which analysis or optimisation would you like to perform?",
						"Choose an Analysis or Optimisation",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[0]);
		
		parent.dispose();
		
		switch(n){
		case 0: testLive(""); break;
		case 1: testAvail(""); break;
		case 2: testDominator(""); break;
		case 3: testReaching(""); break;
		case 4: testFolding(""); break;
		default: return;
		}
		
	}
	
	public static Statement Parse(String program){
		Statement s = null;
		
		// first try to open the given program if it is not empty
		if(! program.equals("")){
		try{
			FileReader fr = new FileReader("programs/" + program);
			
			CharStream stream = new ANTLRInputStream(fr);
		    WHILELexer lexer = new WHILELexer(stream);
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    WHILEParser parser = new WHILEParser(tokens);
	
		    s = parser.statement().s;
		}catch(Exception e){System.out.println(e.getMessage());}
		}
		
		if(s != null) return s;
		
		// only if that's not working open a file dialog
		try{
			JFrame parent  = new JFrame();
			JFileChooser diag = new JFileChooser("programs/");
			diag.showOpenDialog(parent);
			
			parent.dispose();
			
			FileReader fr = new FileReader(diag.getSelectedFile().getAbsolutePath());
			
			CharStream stream = new ANTLRInputStream(fr);
		    WHILELexer lexer = new WHILELexer(stream);
		    CommonTokenStream tokens = new CommonTokenStream(lexer);
		    WHILEParser parser = new WHILEParser(tokens);
	
		    s = parser.statement().s;
		}catch(Exception e){System.out.println(e.getMessage());}
		
	    return s;
	}
}
