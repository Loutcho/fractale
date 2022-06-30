package xt.coloralgo.effect;

import java.util.ArrayList;
import java.util.List;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
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
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		if (effects.isEmpty()) {
			return 1.0;
		}
		double max = 0.0;
		for (Effect effect : effects) {
			double k = effect.apply(palette, iColor, z, iReel);
			if (k > max) {
				max = k;
			}
		}
		return max;
	}
	
}
