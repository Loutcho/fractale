package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class ReLessThan implements BooleanExpression {

	private double threshold;
	
	public ReLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean evaluate(int i, Complex t) {
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
