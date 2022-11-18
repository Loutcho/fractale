package xt.coloralgo.effect;

import xt.math.Complex;

public class Inverse implements Effect {

	private Effect effect;
	
	public Inverse(Effect effect) {
		this.effect = effect;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		return 1.0 - effect.apply(iColor, z, i);
	}

	@Override
	public void multiplyPeriod(double coef) {
		effect.multiplyPeriod(coef);
	}

	@Override
	public void incrementPhase(double deltaPhase) {
		effect.incrementPhase(deltaPhase);
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		effect.multiplyThreshold(coef);
	}
}
