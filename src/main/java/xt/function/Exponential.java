package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Exponential implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		return Complex.polar(Math.exp(x), y);
	}
}
