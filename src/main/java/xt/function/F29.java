package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F29 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		double rr = 4.0 * Math.sin(t);
		double tt = Math.PI * Math.sin(r);
		return Complex.polar(rr, tt);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F29");
		return builder.toString();
	}
}
