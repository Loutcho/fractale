package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public class ReLessThan implements StopCriterion {

	private double threshold;
	
	public ReLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean stopsAt(Complex t) {
		return (t.re() < threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReLessThan(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
