package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F42 implements Function<Complex, Complex> {

	private static double K = 2.0;
	
	private Complex f(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = Math.abs(x * y) - K;
		double yy = Math.abs(x + y) - K;
		return new Complex(xx, yy);
	}
	
	public Complex apply(Complex z) {
		return f(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F42(");
		builder.append(")");
		return builder.toString();
	}
}
