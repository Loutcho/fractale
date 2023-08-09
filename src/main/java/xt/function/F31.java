package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F31 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = x * x - Math.abs(y);
		double yy = Math.abs(x) + y * y;
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F31");
		return builder.toString();
	}
}
