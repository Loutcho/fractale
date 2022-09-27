package xt.coloralgo.effect;

import xt.coloralgo.CyclicPalette;
import xt.coloralgo.Palette;
import xt.math.Complex;

public class AbsPalette implements Effect {

	private Palette palette;
	private double period;
	private double phase;
	
	public AbsPalette(Palette palette, double period, double phase) {
		this.palette = palette;
		this.period = period;
		this.phase = phase;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsPalette(");
		builder.append(palette);
		builder.append(", ");
		builder.append(period);
		builder.append(", ");
		builder.append(phase);
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return CyclicPalette.apply(palette, iColor, z.abs() / period + phase);
	}
}
