package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class ArgGrid implements Effect {

	private int nbSlices;
	private double thickness;

	public ArgGrid(int nbSlices, double thickness) {
		this.nbSlices = nbSlices;
		this.thickness = thickness;
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return Math.pow(MyMath.sqcosdemi(nbSlices * z.arg()), thickness);
	}
}
