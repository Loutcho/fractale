package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class AieJAiMal implements Function<Complex, Complex> {
	
	private static final double C = 2.0;
	private static final double K = 4.0;
	
	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		return Complex.add(z, Complex.polar(C * Math.cos(r) * Math.cos(K * t), C * Math.sin(r) * Math.sin(K * t)));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AieJAiMal");
		return builder.toString();
	}
}
