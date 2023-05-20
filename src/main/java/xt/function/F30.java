package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F30 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = 2.0 / (x + y);
		double yy = x * y * xx;
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F30");
		return builder.toString();
	}
}
