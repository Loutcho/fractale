package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F15 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double w = x * x + 4.0 * y;
		Complex ww;
		if (w < 0.0) {
			if (x < 0.0) {
				ww = new Complex(0.0, -Math.sqrt(-w));
			} else {
				ww = new Complex(0.0, Math.sqrt(-w));
			}
		} else {
			ww = new Complex(Math.sqrt(w), 0.0);
		}
		Complex xx = Complex.mul(0.5, Complex.add(new Complex(x, 0.0), ww));
		Complex yy = Complex.mul(0.5, Complex.sub(new Complex(x, 0.0), ww));
		return Complex.add(xx, Complex.mul(yy, Complex.I));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F15");
		return builder.toString();
	}
}
