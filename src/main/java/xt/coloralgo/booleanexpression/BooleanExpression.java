package xt.coloralgo.booleanexpression;

import xt.math.Complex;

public interface BooleanExpression {

	default void multiplyThreshold(double coef) {}
	public boolean evaluate(int i, Complex z);
}
