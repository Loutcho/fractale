package xt.coloralgo.effect;

import xt.coloralgo.CyclicPalette;
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
		builder.append("ArgPalette(");
		builder.append(palette);
		builder.append(", ");
		builder.append(period);
		builder.append(", ");
		builder.append(phase);
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		return CyclicPalette.apply(palette, iColor, z.arg() / (2.0 * Math.PI) / period + phase);
	}

	@Override
	public void multiplyPeriod(double coef) {
		period *= coef;
	}
	
	@Override
	public void incrementPhase(double deltaPhase) {
		phase = (phase + deltaPhase) % 1.0;
	}
}
