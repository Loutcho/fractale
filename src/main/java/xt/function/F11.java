package xt.function;

import java.util.function.Function;

import xt.math.Complex;

/**
 * The radius becomes its floor
 */
public class F11 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double theta = z.arg();
		r = Math.floor(r);
		return Complex.polar(r, theta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F11");
		return builder.toString();
	}
}
