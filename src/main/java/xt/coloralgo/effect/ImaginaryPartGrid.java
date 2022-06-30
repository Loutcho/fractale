package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;
import xt.math.MyMath;

public class ImaginaryPartGrid implements Effect {

	private double targetIntensity[];
	private double thickness;
	
	public ImaginaryPartGrid(double thickness, double targetIntensityRed, double targetIntensityGreen, double targetIntensityBlue) {
		this.thickness = thickness;
		this.targetIntensity = new double[3];
		this.targetIntensity[0] = targetIntensityRed;
		this.targetIntensity[1] = targetIntensityGreen;
		this.targetIntensity[2] = targetIntensityBlue;
	}
	
	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		double im = z.im();
		double t = 1.0 - Math.pow(MyMath.sq(im - Math.round(im)), thickness);
		return t * targetIntensity[iColor];
	}
}
