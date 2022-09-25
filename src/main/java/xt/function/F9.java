package xt.function;

import java.util.function.Function;

import xt.math.Complex;

/**
 * Double the argument
 */
public class F9 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		return Complex.polar(z.abs(), 2.0 * z.arg());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F9");
		return builder.toString();
	}
}
