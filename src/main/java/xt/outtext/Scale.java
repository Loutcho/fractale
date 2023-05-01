package xt.outtext;

import java.util.function.Function;

import xt.math.Complex;

public class Scale implements Function<Complex, Complex> {
	
	private double coef;

	public static Scale k(double coef) {
		return new Scale(coef);
	}
	
	private Scale(double coef) {
		this.coef = coef;
	}

	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = x * coef;
		double yy = y * coef;
		return new Complex(xx, yy);
	}
}
