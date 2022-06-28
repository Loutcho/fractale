package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;

/**
 * Raises x to the provided power
 * This alters luminosity.
 * When power = 0.0: everything becomes white
 * When power = 1.0: nothing changes
 * When power > 1.0: everything becomes darker
 * To be called, normally, as a last effect.
 */

public class LuminosityPower implements Effect {

	boolean activated;
	double power;

	public LuminosityPower(double power) {
		this.activated = true;
		this.power = power;
	}
	
	private LuminosityPower() {
		this.activated = false;
	}

	public boolean isActivated() {
		return activated;
	}	
	
	public double getPower() {
		return power;
	}
	
	public static final LuminosityPower OFF = new LuminosityPower();

	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			return Math.pow(x, power);
		} else {
			return x;
		}
	}
}
