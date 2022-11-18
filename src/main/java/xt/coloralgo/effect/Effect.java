package xt.coloralgo.effect;

import xt.math.Complex;

public interface Effect {
	public double apply(int iColor, Complex z, int i);
	default void multiplyPeriod(double coef) {};
	default void incrementPhase(double deltaPhase) {};
	default void multiplyThreshold(double coef) {};
}