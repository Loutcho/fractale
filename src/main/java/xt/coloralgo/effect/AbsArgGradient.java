package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class AbsArgGradient implements Effect {

	public AbsArgGradient() {
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double theta = z.arg();
		double modifiedAbs = MyMath.ff((z.abs() - 2.0) / 2.0);
		return Math.max((1.0 + MyMath.sqcosdemi(theta + iColor * Math.PI / 2.0)) / 2.0, (1.0 + modifiedAbs) / 2.0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsArgGradient");
		return builder.toString();
	}
}
