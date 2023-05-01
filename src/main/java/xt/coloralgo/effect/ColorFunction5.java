package xt.coloralgo.effect;

import xt.math.Complex;
import xt.outtext.OutText;

public class ColorFunction5 implements Effect {

	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = z.re();
		double y = z.im();
		int xx = (int) Math.rint(x);
		int yy = (int) Math.rint(y);
		String string = new Complex(xx, yy).toString();
		double n = string.length();
		return new OutText(new Complex(xx, yy), 1.0 / (5.0 * n), string).apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ColorFunction5()");
		return builder.toString();
	}
}
