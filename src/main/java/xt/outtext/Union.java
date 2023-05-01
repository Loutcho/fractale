package xt.outtext;

import java.util.function.Function;

import xt.math.Complex;

public class Union implements Function<Complex, Double> {
	
	private Function<Complex, Double>[] function;

	@SafeVarargs
	public static Union u(Function<Complex, Double>...function) {
		return new Union(function);
	}
	
	@SafeVarargs
	private Union(Function<Complex, Double>...function) {
		this.function = function;
	}

	@Override
	public Double apply(Complex z) {
		double q;
		double max = 0.0;
		for (int i = 0; i < function.length; i ++) {
			q = function[i].apply(z);
			if (q > max) {
				max = q;
			}
		}
		return max;
	}
}
