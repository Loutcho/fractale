package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.math.Complex;

public class Pow implements Effect {
	
	private double power;
	private Effect effect;
	
	public Pow(double power, Effect effect) {
		this.power = power;
		this.effect = effect;
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return Math.pow(effect.apply(iColor, z, iReel), power);
	}
	
}
