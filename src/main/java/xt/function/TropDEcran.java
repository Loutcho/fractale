package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class TropDEcran implements Function<Complex, Complex> {

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TropDEcran");
		return builder.toString();
	}
}
