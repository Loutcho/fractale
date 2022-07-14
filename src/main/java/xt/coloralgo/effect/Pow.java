package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;

public class Pow implements Effect {
	
	private double power;
	private Effect effect;
	
	public Pow(double power, Effect effect) {
		this.power = power;
		this.effect = effect;
	}

	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		return Math.pow(effect.apply(palette, iColor, z, iReel), power);
	}
	
}
