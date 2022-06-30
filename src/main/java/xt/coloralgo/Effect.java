package xt.coloralgo;

import xt.math.Complex;

public interface Effect {
	public double apply(Palette palette, int iColor, Complex z, double iReel);
}