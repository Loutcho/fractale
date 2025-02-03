package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class UniformNormLessThan1 implements BooleanExpression {

	@Override
	public boolean evaluate(int i, Complex t) {
		return (Math.abs(t.re()) <= 1.0) && (Math.abs(t.im()) <= 1.0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UniformNormLessThan1(");
		builder.append(")");
		return builder.toString();
	}
}
