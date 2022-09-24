package xt.coloralgo.effect;

import java.util.Arrays;

import xt.math.Complex;
import xt.math.MyMath;

/**
 * Does not work very well in DomainColoring.
 * Intended to be used in EscapeTimeColoring and AbsGreaterThan(2.0)
 */
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsGradient1(");
		builder.append(Arrays.toString(attenuation));
		builder.append(")");
		return builder.toString();
	}
}
