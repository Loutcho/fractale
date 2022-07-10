package xt.function;

import xt.math.Complex;

public class Papillon implements Function {

	public Complex apply(Complex z) {
		double r = Complex.abs(z);
		double t = Complex.arg(z);
		double rr = r + Math.sin(t);
		double tt = t + Math.cos(t) / r;
		return Complex.mul(rr, Complex.ei(tt));
	}

	@Override
	public String getHumanReadableFormula() {
		return "Papillon(z)";
	}
}
