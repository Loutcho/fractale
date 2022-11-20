package xt.coloralgo.realexpression;

import xt.math.Complex;

public class Constant implements RealExpression {

	private double constant;
	
	public Constant(double constant) {
		this.constant = constant;
	}
	
	@Override
	public double evaluate(int i, Complex z) {
		return constant;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(constant);
		return builder.toString();
	}
}
