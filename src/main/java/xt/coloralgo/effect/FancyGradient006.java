package xt.coloralgo.effect;

import xt.math.Complex;

public class FancyGradient006 implements Effect {

	private double threshold;
	
	public FancyGradient006(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		this.threshold *= coef;
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = Math.abs(z.re());
		double y = Math.abs(z.im());
		double tt = Math.pow(Math.max(x, y) / (threshold * threshold), 20.0);
		return (tt > 1.0) ? 0.0 : Math.sqrt(1.0 - tt); 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyGradient006(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
