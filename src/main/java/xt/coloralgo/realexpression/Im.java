package xt.coloralgo.realexpression;

import xt.math.Complex;

public class Im implements RealExpression {

	@Override
	public double evaluate(int i, Complex z) {
		return z.im();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Im()");
		return builder.toString();
	}
}
