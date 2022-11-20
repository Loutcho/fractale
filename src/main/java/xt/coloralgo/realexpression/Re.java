package xt.coloralgo.realexpression;

import xt.math.Complex;

public class Re implements RealExpression {

	@Override
	public double evaluate(int i, Complex z) {
		return z.re();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Re()");
		return builder.toString();
	}
}
