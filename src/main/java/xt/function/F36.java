package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F36 implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = 2.0 * Math.sin(Math.sqrt(Math.abs(x + y)));
		double yy = 2.0 * Math.cos(Math.sqrt(Math.abs(- x + y)));
		return new Complex(xx, yy); // x = u + v; y = u - v;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F36");
		return builder.toString();
	}
}
