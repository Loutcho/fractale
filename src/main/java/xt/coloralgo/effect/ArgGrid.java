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
	public double apply(int iColor, Complex z, int i) {
		return Math.pow(MyMath.sqcosdemi(nbSlices * z.arg()), thickness);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArgGrid(");
		builder.append(nbSlices);
		builder.append(", ");
		builder.append(thickness);
		builder.append(")");
		return builder.toString();
	}
}
