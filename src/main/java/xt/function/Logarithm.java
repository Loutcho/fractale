package xt.function;

import xt.math.Complex;

public class Logarithm implements Function {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();

		double r = Complex.abs(z);
		double a = Math.atan2(y, x + r);
		Complex zz = new Complex(Math.log(r), 2.0 * a);
		if ((y == 0.0) && (x < 0.0)) {
			return new Complex(Math.log(r), Math.PI);
		}
		return zz;
	}

	@Override
	public String getHumanReadableFormula() {
		return "log(z)";
	}
}
