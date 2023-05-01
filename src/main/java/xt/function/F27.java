package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F27 implements Function<Complex, Complex> {

	private Function<Complex, Complex> log = new Log();
	private Function<Complex, Complex> sinh = new Sinh();
	private Function<Complex, Complex> cos = new Cos();
	
	private static final double K = 2.0 / Math.PI;
	private static final double K2 = 5.0 / 4.0 * Math.PI;
	
	@Override
	public Complex apply(Complex z) {
		Complex zz = sinh.apply(z);
		double t = zz.arg();
		double r = zz.abs();
		double tt = K * t;
		Complex zzz = log.apply(Complex.polar(r, tt));
		double x = zzz.re();
		double y = zzz.im();
		double yy = K2 * y;
		Complex zzzz = new Complex(yy, x);
		// return zzzz;
		return cos.apply(zzzz);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F27");
		return builder.toString();
	}
}
