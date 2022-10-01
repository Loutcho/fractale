package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Sylvestre implements Function<Complex, Complex> {

	private double n;
	
	public Sylvestre(double n) {
		this.n = n;
	}
	
	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double theta = z.arg();
		r = r * r;
		theta = Math.PI * Math.cos(n * theta / 2.0);
		return Complex.polar(r, theta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sylvestre(");
		builder.append(n);
		builder.append(")");
		return builder.toString();
	}
}
