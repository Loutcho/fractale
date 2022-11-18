package xt.coloralgo.effect;

import xt.math.Complex;

public class AbsGradient0 implements Effect {

	private static final double C = 2.0 / Math.PI;
	
	public AbsGradient0() {
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		double r = z.abs();
		return C * Math.atan(r);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsGradient0");
		return builder.toString();
	}
}
