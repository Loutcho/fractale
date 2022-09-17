package xt.coloralgo.effect;

import xt.math.Complex;

public class ConstantColor implements Effect {

	private double tab[];

	public ConstantColor(double r, double g, double b) {
		tab = new double[3];
		tab[0] = r;
		tab[1] = g;
		tab[2] = b;
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return tab[iColor];
	}
}
