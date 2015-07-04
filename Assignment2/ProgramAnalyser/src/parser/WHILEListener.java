// Generated from WHILE.g4 by ANTLR 4.4

package parser;

import stmt.*;
import aexp.*;
import bexp.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WHILEParser}.
 */
public interface WHILEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WHILEParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull WHILEParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull WHILEParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WHILEParser#bExp}.
	 * @param ctx the parse tree
	 */
	void enterBExp(@NotNull WHILEParser.BExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#bExp}.
	 * @param ctx the parse tree
	 */
	void exitBExp(@NotNull WHILEParser.BExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WHILEParser#aExp}.
	 * @param ctx the parse tree
	 */
	void enterAExp(@NotNull WHILEParser.AExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#aExp}.
	 * @param ctx the parse tree
	 */
	void exitAExp(@NotNull WHILEParser.AExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WHILEParser#aOp}.
	 * @param ctx the parse tree
	 */
	void enterAOp(@NotNull WHILEParser.AOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#aOp}.
	 * @param ctx the parse tree
	 */
	void exitAOp(@NotNull WHILEParser.AOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link WHILEParser#bBinop}.
	 * @param ctx the parse tree
	 */
	void enterBBinop(@NotNull WHILEParser.BBinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#bBinop}.
	 * @param ctx the parse tree
	 */
	void exitBBinop(@NotNull WHILEParser.BBinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link WHILEParser#aComparator}.
	 * @param ctx the parse tree
	 */
	void enterAComparator(@NotNull WHILEParser.AComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WHILEParser#aComparator}.
	 * @param ctx the parse tree
	 */
	void exitAComparator(@NotNull WHILEParser.AComparatorContext ctx);
}