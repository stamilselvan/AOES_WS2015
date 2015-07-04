// Generated from WHILE.g4 by ANTLR 4.4

package parser;

import stmt.*;
import aexp.*;
import bexp.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WHILEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__28=1, T__27=2, T__26=3, T__25=4, T__24=5, T__23=6, T__22=7, T__21=8, 
		T__20=9, T__19=10, T__18=11, T__17=12, T__16=13, T__15=14, T__14=15, T__13=16, 
		T__12=17, T__11=18, T__10=19, T__9=20, T__8=21, T__7=22, T__6=23, T__5=24, 
		T__4=25, T__3=26, T__2=27, T__1=28, T__0=29, NUM=30, ID=31, WS=32;
	public static final String[] tokenNames = {
		"<INVALID>", "'while'", "'or'", "'-'", "'*'", "'not'", "'('", "'if'", 
		"'fi'", "'<'", "'od'", "'false'", "'<='", "'{'", "'and'", "'else'", "'skip'", 
		"'}'", "'true'", "'do'", "')'", "'+'", "'='", "';'", "'>'", "':='", "'then'", 
		"'=='", "'/'", "'>='", "NUM", "ID", "WS"
	};
	public static final int
		RULE_statement = 0, RULE_bExp = 1, RULE_aExp = 2, RULE_aComparator = 3, 
		RULE_bBinop = 4, RULE_aOp = 5;
	public static final String[] ruleNames = {
		"statement", "bExp", "aExp", "aComparator", "bBinop", "aOp"
	};

	@Override
	public String getGrammarFileName() { return "WHILE.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WHILEParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatementContext extends ParserRuleContext {
		public Statement s;
		public StatementContext s1;
		public BExpContext b;
		public StatementContext s2;
		public Token v;
		public AExpContext x;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode ID() { return getToken(WHILEParser.ID, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public AExpContext aExp() {
			return getRuleContext(AExpContext.class,0);
		}
		public BExpContext bExp() {
			return getRuleContext(BExpContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		return statement(0);
	}

	private StatementContext statement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementContext _localctx = new StatementContext(_ctx, _parentState);
		StatementContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_statement, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(13); match(T__22);
				setState(14); match(T__23);
				setState(15); ((StatementContext)_localctx).b = bExp(0);
				setState(16); match(T__9);
				setState(17); match(T__3);
				setState(18); ((StatementContext)_localctx).s1 = statement(0);
				setState(19); match(T__14);
				setState(20); ((StatementContext)_localctx).s2 = statement(6);
				 ((StatementContext)_localctx).s =  new If(((StatementContext)_localctx).b.e,((StatementContext)_localctx).s1.s,((StatementContext)_localctx).s2.s); 
				}
				break;
			case 2:
				{
				setState(23); match(T__28);
				setState(24); match(T__23);
				setState(25); ((StatementContext)_localctx).b = bExp(0);
				setState(26); match(T__9);
				setState(27); match(T__10);
				setState(28); ((StatementContext)_localctx).s1 = statement(4);
				 ((StatementContext)_localctx).s =  new While(((StatementContext)_localctx).b.e,((StatementContext)_localctx).s1.s); 
				}
				break;
			case 3:
				{
				setState(31); match(T__13);
				 ((StatementContext)_localctx).s =  new Skip(); 
				}
				break;
			case 4:
				{
				setState(33); ((StatementContext)_localctx).v = match(ID);
				setState(34); match(T__4);
				setState(35); ((StatementContext)_localctx).x = aExp(0);
				 ((StatementContext)_localctx).s =  new Assignment(new Variable((((StatementContext)_localctx).v!=null?((StatementContext)_localctx).v.getText():null)),((StatementContext)_localctx).x.e); 
				}
				break;
			case 5:
				{
				setState(38); match(T__22);
				setState(39); match(T__23);
				setState(40); ((StatementContext)_localctx).b = bExp(0);
				setState(41); match(T__9);
				setState(42); match(T__3);
				setState(43); ((StatementContext)_localctx).s1 = statement(0);
				setState(44); match(T__14);
				setState(45); ((StatementContext)_localctx).s2 = statement(0);
				setState(46); match(T__21);
				 ((StatementContext)_localctx).s =  new If(((StatementContext)_localctx).b.e,((StatementContext)_localctx).s1.s,((StatementContext)_localctx).s2.s); 
				}
				break;
			case 6:
				{
				setState(49); match(T__28);
				setState(50); match(T__23);
				setState(51); ((StatementContext)_localctx).b = bExp(0);
				setState(52); match(T__9);
				setState(53); match(T__10);
				setState(54); ((StatementContext)_localctx).s1 = statement(0);
				setState(55); match(T__19);
				 ((StatementContext)_localctx).s =  new While(((StatementContext)_localctx).b.e,((StatementContext)_localctx).s1.s); 
				}
				break;
			case 7:
				{
				setState(58); match(T__16);
				setState(59); ((StatementContext)_localctx).s1 = statement(0);
				setState(60); match(T__12);
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).s1.s; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementContext(_parentctx, _parentState);
					_localctx.s1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statement);
					setState(65);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(66); match(T__6);
					setState(67); ((StatementContext)_localctx).s2 = statement(3);
					 ((StatementContext)_localctx).s =  new SeqComp(((StatementContext)_localctx).s1.s,((StatementContext)_localctx).s2.s); 
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BExpContext extends ParserRuleContext {
		public BExp e;
		public BExpContext b1;
		public BExpContext b;
		public AExpContext a1;
		public AComparatorContext c;
		public AExpContext a2;
		public BBinopContext o;
		public BExpContext b2;
		public AComparatorContext aComparator() {
			return getRuleContext(AComparatorContext.class,0);
		}
		public BExpContext bExp(int i) {
			return getRuleContext(BExpContext.class,i);
		}
		public BBinopContext bBinop() {
			return getRuleContext(BBinopContext.class,0);
		}
		public AExpContext aExp(int i) {
			return getRuleContext(AExpContext.class,i);
		}
		public List<AExpContext> aExp() {
			return getRuleContexts(AExpContext.class);
		}
		public List<BExpContext> bExp() {
			return getRuleContexts(BExpContext.class);
		}
		public BExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterBExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitBExp(this);
		}
	}

	public final BExpContext bExp() throws RecognitionException {
		return bExp(0);
	}

	private BExpContext bExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BExpContext _localctx = new BExpContext(_ctx, _parentState);
		BExpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_bExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(76); match(T__11);
				 ((BExpContext)_localctx).e =  new True(); 
				}
				break;
			case 2:
				{
				setState(78); match(T__18);
				 ((BExpContext)_localctx).e =  new False(); 
				}
				break;
			case 3:
				{
				setState(80); match(T__24);
				setState(81); match(T__23);
				setState(82); ((BExpContext)_localctx).b = bExp(0);
				setState(83); match(T__9);
				 ((BExpContext)_localctx).e =  new Neg(((BExpContext)_localctx).b.e); 
				}
				break;
			case 4:
				{
				setState(86); ((BExpContext)_localctx).a1 = aExp(0);
				setState(87); ((BExpContext)_localctx).c = aComparator();
				setState(88); ((BExpContext)_localctx).a2 = aExp(0);
				 ((BExpContext)_localctx).e =  new AComparison(((BExpContext)_localctx).a1.e,((BExpContext)_localctx).c.op,((BExpContext)_localctx).a2.e); 
				}
				break;
			case 5:
				{
				setState(91); match(T__23);
				setState(92); ((BExpContext)_localctx).b = bExp(0);
				setState(93); match(T__9);
				 ((BExpContext)_localctx).e =  ((BExpContext)_localctx).b.e; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BExpContext(_parentctx, _parentState);
					_localctx.b1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_bExp);
					setState(98);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(99); ((BExpContext)_localctx).o = bBinop();
					setState(100); ((BExpContext)_localctx).b2 = bExp(5);
					 ((BExpContext)_localctx).e =  new BComp(((BExpContext)_localctx).b1.e,((BExpContext)_localctx).o.op,((BExpContext)_localctx).b2.e); 
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AExpContext extends ParserRuleContext {
		public AExp e;
		public AExpContext a1;
		public Token v;
		public Token x;
		public AExpContext a;
		public AOpContext o;
		public AExpContext a2;
		public AOpContext aOp() {
			return getRuleContext(AOpContext.class,0);
		}
		public TerminalNode ID() { return getToken(WHILEParser.ID, 0); }
		public AExpContext aExp(int i) {
			return getRuleContext(AExpContext.class,i);
		}
		public List<AExpContext> aExp() {
			return getRuleContexts(AExpContext.class);
		}
		public TerminalNode NUM() { return getToken(WHILEParser.NUM, 0); }
		public AExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterAExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitAExp(this);
		}
	}

	public final AExpContext aExp() throws RecognitionException {
		return aExp(0);
	}

	private AExpContext aExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AExpContext _localctx = new AExpContext(_ctx, _parentState);
		AExpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_aExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(109); ((AExpContext)_localctx).v = match(ID);
				 ((AExpContext)_localctx).e =  new Variable((((AExpContext)_localctx).v!=null?((AExpContext)_localctx).v.getText():null)); 
				}
				break;
			case NUM:
				{
				setState(111); ((AExpContext)_localctx).x = match(NUM);
				 ((AExpContext)_localctx).e =  new Constant(Integer.parseInt((((AExpContext)_localctx).x!=null?((AExpContext)_localctx).x.getText():null))); 
				}
				break;
			case T__23:
				{
				setState(113); match(T__23);
				setState(114); ((AExpContext)_localctx).a = aExp(0);
				setState(115); match(T__9);
				 ((AExpContext)_localctx).e =  ((AExpContext)_localctx).a.e; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AExpContext(_parentctx, _parentState);
					_localctx.a1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_aExp);
					setState(120);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(121); ((AExpContext)_localctx).o = aOp();
					setState(122); ((AExpContext)_localctx).a2 = aExp(3);
					 ((AExpContext)_localctx).e =  new AComp(((AExpContext)_localctx).a1.e,((AExpContext)_localctx).o.op,((AExpContext)_localctx).a2.e); 
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AComparatorContext extends ParserRuleContext {
		public bexp.AComparator op;
		public AComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterAComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitAComparator(this);
		}
	}

	public final AComparatorContext aComparator() throws RecognitionException {
		AComparatorContext _localctx = new AComparatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aComparator);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(130); match(T__20);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.less; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(132); match(T__17);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.leq; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(134); match(T__7);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.eq; 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(136); match(T__2);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.eq; 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 5);
				{
				setState(138); match(T__0);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.geq; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(140); match(T__5);
				 ((AComparatorContext)_localctx).op =  bexp.AComparator.greater; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BBinopContext extends ParserRuleContext {
		public bexp.BBinOp op;
		public BBinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bBinop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterBBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitBBinop(this);
		}
	}

	public final BBinopContext bBinop() throws RecognitionException {
		BBinopContext _localctx = new BBinopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bBinop);
		try {
			setState(148);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(144); match(T__15);
				 ((BBinopContext)_localctx).op =  bexp.BBinOp.and; 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(146); match(T__27);
				 ((BBinopContext)_localctx).op =  bexp.BBinOp.or; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AOpContext extends ParserRuleContext {
		public aexp.AOp op;
		public AOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).enterAOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WHILEListener ) ((WHILEListener)listener).exitAOp(this);
		}
	}

	public final AOpContext aOp() throws RecognitionException {
		AOpContext _localctx = new AOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aOp);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); match(T__8);
				 ((AOpContext)_localctx).op =  aexp.AOp.plus; 
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); match(T__26);
				 ((AOpContext)_localctx).op =  aexp.AOp.minus; 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(154); match(T__25);
				 ((AOpContext)_localctx).op =  aexp.AOp.mult; 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(156); match(T__1);
				 ((AOpContext)_localctx).op =  aexp.AOp.div; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return statement_sempred((StatementContext)_localctx, predIndex);
		case 1: return bExp_sempred((BExpContext)_localctx, predIndex);
		case 2: return aExp_sempred((AExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statement_sempred(StatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bExp_sempred(BExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean aExp_sempred(AExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\"\u00a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2B\n\2\3\2\3\2\3\2\3\2\3\2\7\2I\n\2"+
		"\f\2\16\2L\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3c\n\3\3\3\3\3\3\3\3\3\3\3\7\3j\n\3\f"+
		"\3\16\3m\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4y\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4\u0080\n\4\f\4\16\4\u0083\13\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0091\n\5\3\6\3\6\3\6\3\6\5\6\u0097\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a1\n\7\3\7\2\5\2\4\6\b\2\4\6\b\n"+
		"\f\2\2\u00b4\2A\3\2\2\2\4b\3\2\2\2\6x\3\2\2\2\b\u0090\3\2\2\2\n\u0096"+
		"\3\2\2\2\f\u00a0\3\2\2\2\16\17\b\2\1\2\17\20\7\t\2\2\20\21\7\b\2\2\21"+
		"\22\5\4\3\2\22\23\7\26\2\2\23\24\7\34\2\2\24\25\5\2\2\2\25\26\7\21\2\2"+
		"\26\27\5\2\2\b\27\30\b\2\1\2\30B\3\2\2\2\31\32\7\3\2\2\32\33\7\b\2\2\33"+
		"\34\5\4\3\2\34\35\7\26\2\2\35\36\7\25\2\2\36\37\5\2\2\6\37 \b\2\1\2 B"+
		"\3\2\2\2!\"\7\22\2\2\"B\b\2\1\2#$\7!\2\2$%\7\33\2\2%&\5\6\4\2&\'\b\2\1"+
		"\2\'B\3\2\2\2()\7\t\2\2)*\7\b\2\2*+\5\4\3\2+,\7\26\2\2,-\7\34\2\2-.\5"+
		"\2\2\2./\7\21\2\2/\60\5\2\2\2\60\61\7\n\2\2\61\62\b\2\1\2\62B\3\2\2\2"+
		"\63\64\7\3\2\2\64\65\7\b\2\2\65\66\5\4\3\2\66\67\7\26\2\2\678\7\25\2\2"+
		"89\5\2\2\29:\7\f\2\2:;\b\2\1\2;B\3\2\2\2<=\7\17\2\2=>\5\2\2\2>?\7\23\2"+
		"\2?@\b\2\1\2@B\3\2\2\2A\16\3\2\2\2A\31\3\2\2\2A!\3\2\2\2A#\3\2\2\2A(\3"+
		"\2\2\2A\63\3\2\2\2A<\3\2\2\2BJ\3\2\2\2CD\f\4\2\2DE\7\31\2\2EF\5\2\2\5"+
		"FG\b\2\1\2GI\3\2\2\2HC\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\3\3\2\2"+
		"\2LJ\3\2\2\2MN\b\3\1\2NO\7\24\2\2Oc\b\3\1\2PQ\7\r\2\2Qc\b\3\1\2RS\7\7"+
		"\2\2ST\7\b\2\2TU\5\4\3\2UV\7\26\2\2VW\b\3\1\2Wc\3\2\2\2XY\5\6\4\2YZ\5"+
		"\b\5\2Z[\5\6\4\2[\\\b\3\1\2\\c\3\2\2\2]^\7\b\2\2^_\5\4\3\2_`\7\26\2\2"+
		"`a\b\3\1\2ac\3\2\2\2bM\3\2\2\2bP\3\2\2\2bR\3\2\2\2bX\3\2\2\2b]\3\2\2\2"+
		"ck\3\2\2\2de\f\6\2\2ef\5\n\6\2fg\5\4\3\7gh\b\3\1\2hj\3\2\2\2id\3\2\2\2"+
		"jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\5\3\2\2\2mk\3\2\2\2no\b\4\1\2op\7!\2\2"+
		"py\b\4\1\2qr\7 \2\2ry\b\4\1\2st\7\b\2\2tu\5\6\4\2uv\7\26\2\2vw\b\4\1\2"+
		"wy\3\2\2\2xn\3\2\2\2xq\3\2\2\2xs\3\2\2\2y\u0081\3\2\2\2z{\f\4\2\2{|\5"+
		"\f\7\2|}\5\6\4\5}~\b\4\1\2~\u0080\3\2\2\2\177z\3\2\2\2\u0080\u0083\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\7\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7\13\2\2\u0085\u0091\b\5\1\2\u0086\u0087\7\16\2\2"+
		"\u0087\u0091\b\5\1\2\u0088\u0089\7\30\2\2\u0089\u0091\b\5\1\2\u008a\u008b"+
		"\7\35\2\2\u008b\u0091\b\5\1\2\u008c\u008d\7\37\2\2\u008d\u0091\b\5\1\2"+
		"\u008e\u008f\7\32\2\2\u008f\u0091\b\5\1\2\u0090\u0084\3\2\2\2\u0090\u0086"+
		"\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u008a\3\2\2\2\u0090\u008c\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\t\3\2\2\2\u0092\u0093\7\20\2\2\u0093\u0097\b\6\1"+
		"\2\u0094\u0095\7\4\2\2\u0095\u0097\b\6\1\2\u0096\u0092\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\13\3\2\2\2\u0098\u0099\7\27\2\2\u0099\u00a1\b\7\1\2\u009a"+
		"\u009b\7\5\2\2\u009b\u00a1\b\7\1\2\u009c\u009d\7\6\2\2\u009d\u00a1\b\7"+
		"\1\2\u009e\u009f\7\36\2\2\u009f\u00a1\b\7\1\2\u00a0\u0098\3\2\2\2\u00a0"+
		"\u009a\3\2\2\2\u00a0\u009c\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\r\3\2\2\2"+
		"\13AJbkx\u0081\u0090\u0096\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}