package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Papillon implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		double rr = r + Math.sin(t);
		double tt = t + Math.cos(t) / r;
		return Complex.polar(rr, tt);
	}
}
