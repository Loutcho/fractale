package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class FancyAbsGradient implements Effect {

	@Override
	public double apply(int iColor, Complex z, int i) {
		double r = z.abs();
		return Math.sqrt(1.0 - MyMath.sq((r - 1.0) / 0.05));
	}
}
