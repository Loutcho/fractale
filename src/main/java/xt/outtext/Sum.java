package xt.outtext;

import java.util.function.Function;

import xt.math.Complex;

public class Sum implements Function<Complex, Double> {
	
	private Function<Complex, Double>[] function;

	@SafeVarargs
	public Sum(Function<Complex, Double>...function) {
		this.function = function;
	}

	@Override
	public Double apply(Complex z) {
		double q = 0.0;
		for (int i = 0; i < function.length; i ++) {
			q += function[i].apply(z);
		}
		return q;
	}
}
