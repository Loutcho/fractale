package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public interface StopCriterion {

	default void multiplyThreshold(double coef) {}
	public boolean stopsAt(Complex z);
}
