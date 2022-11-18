package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class AbsLessThan implements BooleanExpression {

	private double threshold;
	
	public AbsLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean evaluate(int i, Complex t) {
		return (t.abs() < threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("|z| < ");
		builder.append(threshold);
		return builder.toString();
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		threshold *= coef;
	}
}
