package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.MyMath;

public class ArgGradient implements Effect {

	boolean activated;
	double attenuation[];
	
	public ArgGradient(double redAttenuation, double greenAttenuation, double blueAttenuation) {
		activated = true;
		attenuation = new double[3];
		attenuation[0] = redAttenuation;
		attenuation[1] = greenAttenuation;
		attenuation[2] = blueAttenuation;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public double getAttenuation(int iColor) {
		return attenuation[iColor];
	}
	
	private ArgGradient() {
		activated = false;
	}
	
	public static final ArgGradient OFF = new ArgGradient();

	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			return x * (1.0 - attenuation[iColor] * MyMath.sqcosdemi(theta));
		} else {
			return x;
		}

	}
}
