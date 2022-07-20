package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;

public class AbsGradient2 implements Effect {

	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		return (Math.atan(Math.log(z.abs()) / Math.E) / Math.PI + 0.5);
	}
}
