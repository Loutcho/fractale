package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Logarithm implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();

		double r = z.abs();
		double a = Math.atan2(y, x + r);
		Complex zz = new Complex(Math.log(r), 2.0 * a);
		if ((y == 0.0) && (x < 0.0)) {
			return new Complex(Math.log(r), Math.PI);
		}
		return zz;
	}
}
