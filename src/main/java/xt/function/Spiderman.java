package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Spiderman implements Function<Complex, Complex> {

	private static final double C = 0.79;
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = C * Math.log(Math.abs(x) + 1) + y*y;
		double yy = C * Math.log(Math.abs(y) + 1) - x*x;
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spiderman");
		return builder.toString();
	}
}
