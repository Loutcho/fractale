package xt.coloralgo.effect;

import xt.coloralgo.Palette;
import xt.math.Complex;

public class LogIterationPalette implements Effect {

	private Palette palette;
	private double base;
	
	public LogIterationPalette(Palette palette, double base, boolean cyclic) { //TODO
		this.palette = palette;
		this.base = base;
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		int n = palette.getNbColors();
		double t = Math.log(iReel) / Math.log(base);
		int a = Math.max(0, Math.min((int) Math.floor(t), n - 1));
		int b = Math.max(0, Math.min((int) Math.ceil(t), n - 1));
		t -= a;
		int ca = palette.getColor(a);
		int cb = palette.getColor(b);
		double va = ((double) ((ca >> (8 * (2 - iColor))) & 0xFF)) / 255.0;
		double vb = ((double) ((cb >> (8 * (2 - iColor))) & 0xFF)) / 255.0;
		return (1 - t) * va + t * vb;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new LogIterationPalette(");
		builder.append(palette);
		builder.append(", ");
		builder.append(base);
		builder.append(")");
		return builder.toString();
	}
}
