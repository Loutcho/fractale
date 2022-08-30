package xt.coloralgo.effect;

import java.util.ArrayList;
import java.util.List;

import xt.coloralgo.Effect;
import xt.math.Complex;

public class Min implements Effect {
	
	private List<Effect> effects;
	
	public Min(Effect... effects) {
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
		double min = 1.0;
		for (Effect effect : effects) {
			double k = effect.apply(iColor, z, iReel);
			if (k < min) {
				min = k;
			}
		}
		return min;
	}
	
}
