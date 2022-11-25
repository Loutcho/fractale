package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class EuclidFunction implements Function<Complex, Complex> {
	
	private static final double TWO_PI = 2.0 * Math.PI;
	
	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg(); if (t < 0.0) { t += TWO_PI; }
		int a = (int) Math.rint(r);
		int b = ((int) Math.rint(r * t / TWO_PI));
		if (b == 0.0) {
			return Complex.ZERO;
		}
		int aa = b;
		int bb = a % b;
		double rr = aa;
		double tt = bb * TWO_PI / rr;
		return Complex.polar(rr, tt);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EuclidFunction");
		return builder.toString();
	}
}
