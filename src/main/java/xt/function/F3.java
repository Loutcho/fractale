package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F3 implements Function<Complex, Complex> {

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F3");
		return builder.toString();
	}
}
