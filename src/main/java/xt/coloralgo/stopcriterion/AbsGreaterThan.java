package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public class AbsGreaterThan implements StopCriterion {

	private double threshold;
	
	public AbsGreaterThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean stopsAt(Complex t) {
		return (t.abs() > threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsGreaterThan(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		threshold *= coef;
	}
}
