package xt.coloralgo.effect;

import xt.coloralgo.CyclicPalette;
import xt.coloralgo.Palette;
import xt.math.Complex;
import xt.math.MyMath;

public class IterationPalette implements Effect {

	private Palette palette;
	private double period[];
	private double phase[];
	private boolean smooth;

	public IterationPalette(
			Palette palette,
			double redPeriod, double redPhase,
			double greenPeriod, double greenPhase,
			double bluePeriod, double bluePhase,
			boolean smooth) {
		this.palette = palette;
		period = new double[3];
		phase = new double[3];
		period[0] = redPeriod;
		period[1] = greenPeriod;
		period[2] = bluePeriod;
		phase[0] = redPhase;
		phase[1] = greenPhase;
		phase[2] = bluePhase;
		this.smooth = smooth;
	}

	public IterationPalette(Palette palette, double period, double phase, boolean smooth) {
		this.palette = palette;
		this.period = new double[3];
		this.phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		this.phase[0] = phase;
		this.phase[1] = phase;
		this.phase[2] = phase;
		this.smooth = smooth;
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		double ii = (double) i;
		if (smooth) {
			ii += MyMath.smooth(z.abs());
		}
		return CyclicPalette.apply(palette, iColor, ii / period[iColor] + phase[iColor]);
	}

	@Override
	public void multiplyPeriod(double coef) {
		period[0] *= coef;
		period[1] *= coef;
		period[2] *= coef;
	}

	@Override
	public void incrementPhase(double deltaPhase) {
		phase[0] = (phase[0] + deltaPhase) % 1.0;
		phase[1] = (phase[1] + deltaPhase) % 1.0;
		phase[2] = (phase[2] + deltaPhase) % 1.0;
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
}
