package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class EuclidStopCriterion implements BooleanExpression {

	private static final double TWO_PI = 2.0 * Math.PI;
	
	@Override
	public boolean evaluate(int i, Complex z) {
		double r = z.abs();
		double t = z.arg(); if (t < 0.0) { t += TWO_PI; }
		int b = ((int) Math.rint(r * t / TWO_PI));
		return (b == 0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EuclidStopCriterion(");
		builder.append(")");
		return builder.toString();
	}
}
