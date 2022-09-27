package xt.coloralgo.effect;

import xt.coloralgo.CyclicPalette;
import xt.coloralgo.Palette;
import xt.math.Complex;

public class IterationPalette implements Effect {

	private Palette palette;
	private double period[];
	private double phase[];
	
	public IterationPalette(
			Palette palette,
			double redPeriod, double redPhase,
			double greenPeriod, double greenPhase,
			double bluePeriod, double bluePhase) {
		this.palette = palette;
		period = new double[3];
		phase = new double[3];
		period[0] = redPeriod;
		period[1] = greenPeriod;
		period[2] = bluePeriod;
		phase[0] = redPhase;
		phase[1] = greenPhase;
		phase[2] = bluePhase;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IterationPalette(");
		builder.append(palette);
		builder.append(", ");
		builder.append(period[0]);
		builder.append(", ");
		builder.append(phase[0]);
		builder.append(", ");
		builder.append(period[1]);
		builder.append(", ");
		builder.append(phase[1]);
		builder.append(", ");
		builder.append(period[2]);
		builder.append(", ");
		builder.append(phase[2]);
		builder.append(")");
		return builder.toString();
	}	
	
	public IterationPalette(Palette palette, double period) {
		this.palette = palette;
		this.period = new double[3];
		phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		phase[0] = 0.0;
		phase[1] = 0.0;
		phase[2] = 0.0;
	}
	
	public IterationPalette(Palette palette, double period, double phase) {
		this.palette = palette;
		this.period = new double[3];
		this.phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		this.phase[0] = phase;
		this.phase[1] = phase;
		this.phase[2] = phase;
	}

	@Override
	public double apply(int iColor, Complex z, double iReel) {
		return CyclicPalette.apply(palette, iColor, iReel / period[iColor] + phase[iColor]);
	}
}
