package xt.function;

import xt.math.Complex;

public class Exponential implements Function {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		
		double ex = Math.exp(x);
		Complex eyi = Complex.ei(y);
		return Complex.mul(ex, eyi);
	}

	@Override
	public String getHumanReadableFormula() {
		return "e^z";
	}
}
