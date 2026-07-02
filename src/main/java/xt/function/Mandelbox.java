package xt.function;

import java.util.function.Function;

import xt.math.Complex;

/*
 * Mandelbox
 */
public class Mandelbox implements Function<Complex, Complex> {

	private Complex s;
	private double r;
	private Complex f;
	
	public Mandelbox(Complex s, double r, Complex f) {
		this.s = s;
		this.r = r;
		this.f = f;
	}

	public Complex apply(Complex z) {
		return Complex.mul(s, ballFold(r, Complex.mul(f, boxFold(z))));
	}
	
	private static Complex boxFold(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = boxFold(x);
		double yy = boxFold(y);
		return new Complex(xx, yy);
	}
	
	private static double boxFold(double x) {
		if (x > +1.0) { return +2.0 - x; }
		if (x < -1.0) { return -2.0 - x; }
		return x;
	}

	private static Complex ballFold(double r, Complex z) {
		double m = z.abs();
		double a = z.arg();
		double mm;
		if (m < r) {
			mm = m / (r * r);
		} else {
			mm = 1 / m;
		}
		return Complex.polar(mm, a);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mandelbox(");
		builder.append("s = " + s);
		builder.append(",");
		builder.append("r = " + r);
		builder.append(",");
		builder.append("f = " + f);
		builder.append(")");
		return builder.toString();
	}
}
