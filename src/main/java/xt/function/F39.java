package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F39 implements Function<Complex, Complex> {

	private double alpha;
	
	public F39(double alpha) {
		this.alpha = alpha;
	}
	
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double r = z.abs();
		
		if (r >= 1.0) {
			return Complex.UN;
		}
		
		double xx = 2.0 * (Math.abs(x) - 0.5 * Math.sqrt(1.0 - y * y));
		double yy = -(2.0 * (Math.abs(y) - 0.5 * Math.sqrt(1.0 - x * x)));
		
		double xxx = Math.cos(alpha) * xx + Math.sin(alpha) * yy;
		double yyy = -Math.sin(alpha) * xx + Math.cos(alpha) * yy;
		
		return new Complex(xxx, yyy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F39(");
		builder.append("alpha=" + alpha);
		builder.append(")");
		return builder.toString();
	}
}
