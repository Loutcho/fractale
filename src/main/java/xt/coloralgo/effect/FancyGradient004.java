package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class FancyGradient004 implements Effect {

	private double threshold;
	
	public FancyGradient004(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		this.threshold *= coef;
	}
	
	private static final double A = 25.0;
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = z.re();
		double y = z.im();
		
		double u = Math.sqrt(((x * x) + (y * y)) / (threshold * threshold));
		if (u == 0.0) {
			return 0.0;
		}
		if (u < 1.0) {
			u = 1.0 / u;
		}
		u = u - 1;
		return MyMath.sq(Math.tanh(A * u));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyGradient004(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
