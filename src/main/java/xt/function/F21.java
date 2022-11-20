package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F21 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		return Complex.polar(y * y, x);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F21");
		return builder.toString();
	}
}
