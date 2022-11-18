package xt.coloralgo.effect;

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
	public double apply(int iColor, Complex z, int i) {
		return (1.0 - attenuation[iColor] * MyMath.sqcosdemi(z.arg()));
	}
}
