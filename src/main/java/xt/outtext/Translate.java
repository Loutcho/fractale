package xt.outtext;

import java.util.function.Function;

import xt.math.Complex;

public class Translate implements Function<Complex, Complex> {
	
	private Complex vector;

	public static Function<Complex, Complex> t(double x, double y) {
		return new Translate(new Complex(x, y));
	}
	
	private Translate(Complex vector) {
		this.vector = vector;
	}

	@Override
	public Complex apply(Complex z) {
		return new Complex(z.re() + vector.re(), z.im() + vector.im());
	}
}
