package xt.coloralgo;

import java.awt.Color;

import xt.math.Complex;

public interface ColorAlgo {
	public Color getColor(Complex pixel);
	public void multiplyPeriod(double coef);
	public void incrementPhase(double deltaPhase);
	default void multiplyThreshold(double coef) {};
}
