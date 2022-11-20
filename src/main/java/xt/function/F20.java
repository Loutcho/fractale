package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F20 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = (x + Math.sin(4.0 * x)) * x - y;
		double yy = y + (x + Math.sin(3.0 * x)) * x;
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F20");
		return builder.toString();
	}
}
