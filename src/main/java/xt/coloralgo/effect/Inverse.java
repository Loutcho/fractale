package xt.coloralgo.effect;

import xt.math.Complex;

public class Inverse implements Effect {

	private Effect effect;
	
	public Inverse(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return 1.0 - effect.apply(iColor, z, iReel);
	}
}