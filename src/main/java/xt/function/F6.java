package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F6 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		return Complex.polar(r * r - 2.0, 2.0 * t);
	}
}
