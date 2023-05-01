package xt.outtext;

import static xt.outtext.Union.u;
import static xt.outtext.Scale.k;
import static xt.outtext.Translate.t;

import java.util.function.Function;

import xt.math.Complex;

public class OutText {
	
	private Function<Complex, Double> s;
	
	public OutText(Complex anchor, double size, String string) {
		int n = string.length();
		Function<Complex, Double>[] functions = new Function[n];
		for(int i = 0; i < n; i ++) {
			char c = string.charAt(i);
			Function<Complex, Double> f = CharToFunctionMapper.getFunction(c);
			functions[i] = new Compose<>(f, t(- 2.5 * (i - ((double) (n - 1)) / 2.0), 0.0));
		}
		s = new Compose<>(u(functions), new Compose<>(k(1.0 / size), t(-anchor.re(), -anchor.im())));
	}
	
	public double apply(Complex z) {
		return s.apply(z);
	}
}
