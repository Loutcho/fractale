package xt.coloralgo.effect;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;

public class Max implements Effect {
	
	private List<Effect> effects;
	
	public Max(Effect... effects) {
		this.effects = new ArrayList<Effect>();
		for (int i = 0; i < effects.length; i ++) {
			this.effects.add(effects[i]);
		}
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		if (effects.isEmpty()) {
			return 1.0;
		}
		double max = 0.0;
		for (Effect effect : effects) {
			double k = effect.apply(iColor, z, iReel);
			if (k > max) {
				max = k;
			}
		}
		return max;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Max(");
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
