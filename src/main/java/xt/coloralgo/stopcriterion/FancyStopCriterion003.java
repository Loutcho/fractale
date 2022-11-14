package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public class FancyStopCriterion003 implements StopCriterion {

	private double threshold;
	
	public FancyStopCriterion003(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		threshold *= coef;
	}
	
	@Override
	public boolean stopsAt(Complex z) {
		double x = z.re();
		double y = z.im();
		return (Math.abs(x) < threshold) || (Math.abs(y) < threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyStopCriterion003(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
