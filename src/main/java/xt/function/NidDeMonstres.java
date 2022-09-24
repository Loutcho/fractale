package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class NidDeMonstres implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		x = x * x;
		y = 2 * y;
		z = new Complex(x, y);
		double r = z.abs();
		double t = z.arg();
		t = 2.0 * t;
		return Complex.mul(r, Complex.ei(t));
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NidDeMonstres");
		return builder.toString();
	}
}
