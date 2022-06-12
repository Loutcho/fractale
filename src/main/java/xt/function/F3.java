package xt.function;

import xt.math.Complex;

public class F3 implements Function {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double sx = Math.signum(x);
		double sy = Math.signum(y);
		if ((x == 0.0) || (y == 0.0)) {
			return new Complex(0.0, 0.0);
		}
		return Complex.mul(z, new Complex(sx / Math.log(Math.atan(Math.abs(x)) / (Math.PI / 2.0)), sy / Math.log(Math.atan(Math.abs(y)) / (Math.PI / 2.0))));
	}

	@Override
	public String getHumanReadableFormula() {
		return "f3(z)";
	}
}
