package xt.coloralgo.effect;

import java.util.Arrays;

import xt.math.Complex;
import xt.math.MyMath;

public class GridRe implements Effect {

	private double targetIntensity[];
	private double thickness;
	
	public GridRe(double thickness, double targetIntensityRed, double targetIntensityGreen, double targetIntensityBlue) {
		this.thickness = thickness;
		this.targetIntensity = new double[3];
		this.targetIntensity[0] = targetIntensityRed;
		this.targetIntensity[1] = targetIntensityGreen;
		this.targetIntensity[2] = targetIntensityBlue;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double re = z.re();
		double t = 1.0 - Math.pow(MyMath.sq(re - Math.round(re)), thickness);
		return t * targetIntensity[iColor];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GridRe(");
		builder.append(Arrays.toString(targetIntensity));
		builder.append(", ");
		builder.append(thickness);
		builder.append(")");
		return builder.toString();
	}
}
