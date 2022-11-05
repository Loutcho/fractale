package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F15 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double w = x * x + 4.0 * y;
		double ww, xx, yy;
		if (w >= 0.0) {
			ww = Math.sqrt(w);
			xx = (ww + x) / 2.0;
			yy = (ww - x) / 2.0;
		} else {
			ww = Math.sqrt(-w);
			xx = (x - ww) / 2.0;
			yy = (ww - x) / 2.0;
			if (x * x + 2.0 * y > 0.0 && x > 0.0) {
				double tmp = xx; xx = yy; yy = tmp; 
				// xx = -xx;
				// yy = -yy;
			}
		}
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F15");
		return builder.toString();
	}
}
