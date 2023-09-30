package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F34 implements Function<Complex, Complex> {

	private double angle;
	
	public F34(double angle) {
		this.angle = angle;
	}
	
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = x;
		double yy = y;
		boolean bx = (0.0 < x) && (x <= 1.0);
		boolean by = (0.0 < y) && (y <= 1.0);

		if (bx && by) {
			xx = - 1.0 / x + y;
			yy = + 1.0 / y - x;
		}
		
		if (bx && y < 0.0) {
			xx = x;
			yy = y + 1.0;
		}
		
		if (bx && y > 1.0) {
			xx = x;
			yy = y - 1.0;
		}
		
		if (by && x < 0.0) {
			yy = y;
			xx = x + 1.1;
		}
		
		if (by && x > 1.0) {
			yy = y;
			xx = x - 1.0;
		}
		
		if (!bx && !by) {
			return Complex.add(Complex.ei(angle), z);
		}
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F34");
		return builder.toString();
	}
}
