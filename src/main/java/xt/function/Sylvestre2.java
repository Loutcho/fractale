package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Sylvestre2 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double theta = z.arg();
		r = r * r;
		theta = Math.PI * Math.cos(theta);
		return Complex.polar(r, theta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sylvestre2");
		return builder.toString();
	}
}
