package xt.coloralgo.effect;

import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.realexpression.RealExpression;
import xt.math.Complex;

public class GreaterThan implements BooleanExpression {

	private RealExpression left;
	private RealExpression right;

	public GreaterThan(RealExpression left, RealExpression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean evaluate(int i, Complex z) {
		double l = left.evaluate(i, z);
		double r = right.evaluate(i,z);
		return l > r;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GreaterThan(");
		builder.append(left);
		builder.append(", ");
		builder.append(right);
		builder.append(")");
		return builder.toString();
	}
}
