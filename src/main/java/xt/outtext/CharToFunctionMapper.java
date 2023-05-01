package xt.outtext;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.charfunction.*;

public class CharToFunctionMapper {

	private static Map<Character, Function<Complex, Double>> F;
	private static Function<Complex, Double> SPACE = new CharSpace();
	
	static {
		F = new TreeMap<>();
		F.put('0', new Char0());
		F.put('1', new Char1());
		F.put('2', new Char2());
		F.put('3', new Char3());
		F.put('4', new Char4());
		F.put('5', new Char5());
		F.put('6', new Char6());
		F.put('7', new Char7());
		F.put('8', new Char8());
		F.put('9', new Char9());
		F.put(' ', SPACE);
		F.put('-', new CharMinus());
		F.put(',', new CharComma());
		F.put('(', new CharParenthesis(-1.0));
		F.put(')', new CharParenthesis(+1.0));
	}
	
	public static Function<Complex, Double> getFunction(char c) {
		Function<Complex, Double> function = F.get(c);
		return (function == null) ? SPACE : function;
	}
}
