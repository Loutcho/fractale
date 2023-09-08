package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class ArgGrid implements Effect {

	private int nbSlices;
	private double thickness;
	private double phase;

	public ArgGrid(int nbSlices, double thickness, double phase) {
		this.nbSlices = nbSlices;
		this.thickness = thickness;
		this.phase = phase;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		return Math.pow(MyMath.sqcosdemi(nbSlices * (z.arg() + phase)), thickness);
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
