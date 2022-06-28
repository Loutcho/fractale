package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;

public class AbsGradient implements Effect {

	final boolean activated;
	final double attenuation[];
	
	public AbsGradient(double redAttenuation, double greenAttenuation, double blueAttenuation) {
		activated = true;
		attenuation = new double[3];
		attenuation[0] = redAttenuation;
		attenuation[1] = greenAttenuation;
		attenuation[2] = blueAttenuation;
	}

	public boolean isActivated() {
		return activated;
	}

	public double getAttenuation(int iColor) {
		return attenuation[iColor];
	}
	
	private AbsGradient() {
		activated = false;
		attenuation = null;
	}
	
	public static final AbsGradient OFF = new AbsGradient();

	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			return x * (1.0 - attenuation[iColor] * (1.0 - modifiedDivergence));
		} else {
			return x;
		}
	}
}
