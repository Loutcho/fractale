package xt.function;

import xt.math.Complex;

public class Sylvestre implements Function {

	@Override
	public Complex apply(Complex z) {
		double r = Complex.abs(z);
		double theta = Complex.arg(z);
		r = r * r;
		theta = Math.PI * Math.cos(theta / 2.0);
		return Complex.mul(r, Complex.ei(theta));
	}

	@Override
	public String getHumanReadableFormula() {
		return "Sylvestre(z)";
	}
}
