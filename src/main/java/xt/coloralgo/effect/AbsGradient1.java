package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.math.Complex;
import xt.math.MyMath;

public class AbsGradient1 implements Effect {

	final double attenuation[];
	
	public AbsGradient1(double redAttenuation, double greenAttenuation, double blueAttenuation) {
		attenuation = new double[3];
		attenuation[0] = redAttenuation;
		attenuation[1] = greenAttenuation;
		attenuation[2] = blueAttenuation;
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double modifiedAbs = MyMath.ff((z.abs() - 2.0) / 2.0);
		return (1.0 - attenuation[iColor] * (1.0 - modifiedAbs));
	}
}
