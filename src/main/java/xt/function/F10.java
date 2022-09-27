package xt.function;

import java.util.function.Function;

import xt.math.Complex;

/**
 * Reduce the radius by one
 */
public class F10 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double theta = z.arg();
		r = Math.max(0.0, r - 1.0);
		return Complex.polar(r, theta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F10");
		return builder.toString();
	}
}
