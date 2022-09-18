package xt.coloralgo.effect;

import xt.coloralgo.Palette;
import xt.math.Complex;

public class ArgPalette implements Effect {

	private Palette palette;
	private double period;
	private double phase;
	
	public ArgPalette(Palette palette, double period, double phase) {
		this.palette = palette;
		this.period = period;
		this.phase = phase;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ArgPalette(");
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
		return fonction_1periodique_amplitude1(palette, iColor, z.arg() / (2.0 * Math.PI) / period + phase);
	}
	
	private double fonction_1periodique_amplitude1(Palette palette, int iColor, double x) {
		x -= Math.floor(x);
		int n = palette.getNbColors();
		int i = (int)(n * x);
		int j = (i + 1) % n;
		double coef = n * x - i;
		int mask;
		switch (iColor)
		{
		case 0: mask = 0xFF0000; break;
		case 1: mask = 0x00FF00; break;
		case 2: mask = 0x0000FF; break;
		default: mask = 0xFFFFFF;
		}
		int vali = (palette.getColor(i) & mask) >> (8 * (2 - iColor));
		double alpha = ((double)vali) / 255.0;
		int valj = (palette.getColor(j) & mask) >> (8 * (2 - iColor));
		double beta = ((double)valj) / 255.0;
		return (1.0 - coef) * alpha + coef * beta;
	}
}
