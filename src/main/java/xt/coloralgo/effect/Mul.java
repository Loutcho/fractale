package xt.coloralgo.effect;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;

public class Mul implements Effect {

	private List<Effect> effects;
	
	public Mul(Effect... effects) {
		this.effects = new ArrayList<Effect>();
		for (int i = 0; i < effects.length; i ++) {
			this.effects.add(effects[i]);
		}
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		double product = 1.0;
		for (Effect effect : effects) {
			product *= effect.apply(iColor, z, i);
		}
		return product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mul(");
		for (int i = 0; i < effects.size(); i ++) {
			if (i > 0) {
				builder.append(", ");
			}
			builder.append(effects.get(i).toString());
		}
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public void multiplyPeriod(double coef) {
		for (int i = 0; i < effects.size(); i ++) {
			effects.get(i).multiplyPeriod(coef);
		}
	}
	
	@Override
	public void incrementPhase(double deltaPhase) {
		for (int i = 0; i < effects.size(); i ++) {
			effects.get(i).incrementPhase(deltaPhase);
		}
	}

	@Override
	public void multiplyThreshold(double coef) {
		for (int i = 0; i < effects.size(); i ++) {
			effects.get(i).multiplyThreshold(coef);
		}
	}
}
