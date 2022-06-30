package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;
import xt.math.MyMath;

public class AbsArgGradient implements Effect {

	public AbsArgGradient() {
	}
	
	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		double theta = Complex.arg(z);
		double modifiedAbs = MyMath.ff((Complex.abs(z) - 2.0) / 2.0);
		return Math.max((1.0 + MyMath.sqcosdemi(theta + iColor * Math.PI / 2.0)) / 2.0, (1.0 + modifiedAbs) / 2.0);
	}
}
