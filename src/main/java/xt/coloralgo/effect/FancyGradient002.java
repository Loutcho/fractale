package xt.coloralgo.effect;

import xt.math.Complex;

public class FancyGradient002 implements Effect {

	private double threshold;
	
	public FancyGradient002(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		this.threshold *= coef;
	}
	

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double x = z.re();
		double y = z.im();
		
		double tt = ((x * x) + (y * y)) / (threshold * threshold);
		
		return (tt > 1.0) ? 0.0 : Math.sqrt(1.0 - tt); 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyGradient002(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
