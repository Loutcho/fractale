package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public class IGreaterThan implements BooleanExpression {

	private int iMax;
	
	public IGreaterThan(int iMax) {
		this.iMax = iMax;
	}
	
	@Override
	public boolean evaluate(int i, Complex z) {
		return (i > iMax);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("i > ");
		builder.append(iMax);
		return builder.toString();
	}
}
