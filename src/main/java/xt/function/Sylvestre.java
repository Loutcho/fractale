package xt.function;

import xt.math.Complex;

public class Sylvestre implements Function {

	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double theta = z.arg();
		r = r * r;
		theta = Math.PI * Math.cos(theta / 2.0);
		return Complex.polar(r, theta);
	}

	@Override
	public String getHumanReadableFormula() {
		return "Sylvestre(z)";
	}
}
