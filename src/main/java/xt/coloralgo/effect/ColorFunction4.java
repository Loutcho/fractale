package xt.coloralgo.effect;

import xt.math.Complex;

public class ColorFunction4 implements Effect {

	private static final double K = 128.0;
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = z.re(); 
		double y = z.im();
		double p = (x * y);
		
		double xx = Math.pow(Math.cos(Math.PI * x), K);
		double yy = Math.pow(Math.cos(Math.PI * y), K);
		double pp = Math.pow(Math.cos(Math.PI * p), K);

		switch (iColor) {
		case 0:
			return xx;
		case 1:
			return yy;
		case 2:
		default:
			return 0.5 * pp;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ColorFunction4()");
		return builder.toString();
	}
}
