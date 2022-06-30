package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;
import xt.math.MyMath;

public class RealPartGrid implements Effect {

	private double targetIntensity[];
	private double thickness;
	
	public RealPartGrid(double thickness, double targetIntensityRed, double targetIntensityGreen, double targetIntensityBlue) {
		this.thickness = thickness;
		this.targetIntensity = new double[3];
		this.targetIntensity[0] = targetIntensityRed;
		this.targetIntensity[1] = targetIntensityGreen;
		this.targetIntensity[2] = targetIntensityBlue;
	}
	
	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		double re = z.re();
		double t = 1.0 - Math.pow(MyMath.sq(re - Math.round(re)), thickness);
		return t * targetIntensity[iColor];
	}
}
