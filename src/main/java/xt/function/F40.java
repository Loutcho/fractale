package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F40 implements Function<Complex, Complex> {

	private static final double D = 1.9;
	private static final double H = 1.0;
	
	private static final double ALPHA = 2.0;
	private static final double BETA = (2.0 - 2.0 * D) / H;
	private static final double GAMMA = (2.0 * D - (H + 2.0)) / H;
	
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		
		if ((y < 1.0) && (y > -1.0)) {
			return new Complex(Double.NaN, Double.NaN);
		}
		
		double xx = ALPHA * x + Math.signum(x) * (Math.signum(y) * BETA * y + GAMMA);
		double yy = (2.0 / H) * y - Math.signum(y) * (2.0 + H) / H;
		return new Complex(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F40(");
		builder.append(")");
		return builder.toString();
	}
}
