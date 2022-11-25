package xt.coloralgo.effect;

import xt.math.Complex;

public class EuclidColorFunction implements Effect {

	private static final double TWO_PI = 2.0 * Math.PI;

	double f(double x) {
		return Math.atan(0.15 * (x - 1.0)) / (0.5 * Math.PI);
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double r = z.abs();
		double t = z.arg(); if (t < 0.0) { t += TWO_PI; }
		int a = (int) Math.rint(r);
		if (a == 0.0) {
			return 1.0;
		}
		switch (iColor) {
		case 0:
			return f(a);
		case 1:
			return 0.1 + 0.9 * f(a);
		case 2:
		default:
			return 0.2 + 0.8 * f(a);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EuclidColorFunction");
		return builder.toString();
	}
}
