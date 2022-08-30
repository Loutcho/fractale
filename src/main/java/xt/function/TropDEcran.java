package xt.function;

import xt.math.Complex;

public class TropDEcran implements Function {
	
	@Override
	public String getHumanReadableFormula() {
		return "TropDEcran(z)";
	}

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = Math.rint(x);
		double yy = Math.rint(y);
		double xxx = x - xx;
		double yyy = y - yy;
		z = new Complex(xxx * yy, yyy * xx);
		return z;
	}
}
