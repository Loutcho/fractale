package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;
import xt.math.MyMath;

public class ArgGradient implements Effect {

	double attenuation[];
	
	public ArgGradient(double redAttenuation, double greenAttenuation, double blueAttenuation) {
		attenuation = new double[3];
		attenuation[0] = redAttenuation;
		attenuation[1] = greenAttenuation;
		attenuation[2] = blueAttenuation;
	}
	
	public double getAttenuation(int iColor) {
		return attenuation[iColor];
	}
	
	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		return (1.0 - attenuation[iColor] * MyMath.sqcosdemi(Complex.arg(z)));
	}
}