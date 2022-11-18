package xt.coloralgo.effect;

import xt.math.Complex;

public class Pow implements Effect {
	
	private double power;
	private Effect effect;
	
	public Pow(double power, Effect effect) {
		this.power = power;
		this.effect = effect;
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		return Math.pow(effect.apply(iColor, z, i), power);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pow(");
		builder.append(power);
		builder.append(", ");
		builder.append(effect);
		builder.append(")");
		return builder.toString();
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
