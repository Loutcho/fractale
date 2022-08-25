package xt.function;

import xt.math.Complex;

public class F6 implements Function {
	
	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		return Complex.polar(r * r - 2.0, 2.0 * t);
	}
}
