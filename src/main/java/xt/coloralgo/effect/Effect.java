package xt.coloralgo.effect;

import xt.math.Complex;

public interface Effect {
	public double apply(int iColor, Complex z, double iReel);
	default void multiplyPeriod(double coef) {};
	default void incrementPhase(double deltaPhase) {};
}