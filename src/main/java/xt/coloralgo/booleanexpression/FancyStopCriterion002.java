package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class FancyStopCriterion002 implements BooleanExpression {

	@Override
	public boolean evaluate(int i, Complex z) {
		double r = z.abs();
		return Math.abs(r - 1.0) < 0.05;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyStopCriterion002");
		return builder.toString();
	}
}
