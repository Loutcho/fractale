package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;

public class Periodicity implements Effect {

	boolean activated;
	double period[];
	double phase[];
	
	public Periodicity(
			double redPeriod, double redPhase,
			double greenPeriod, double greenPhase,
			double bluePeriod, double bluePhase) {
		activated = true;
		period = new double[3];
		phase = new double[3];
		period[0] = redPeriod;
		period[1] = greenPeriod;
		period[2] = bluePeriod;
		phase[0] = redPhase;
		phase[1] = greenPhase;
		phase[2] = bluePhase;
	}
	
	public Periodicity(double period) {
		activated = true;
		this.period = new double[3];
		phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		phase[0] = 0.0;
		phase[1] = 0.0;
		phase[2] = 0.0;
	}
	
	public Periodicity(double period, double phase) {
		activated = true;
		this.period = new double[3];
		this.phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		this.phase[0] = phase;
		this.phase[1] = phase;
		this.phase[2] = phase;
	}

	private Periodicity() {
		activated = false;
	}
	
	public static final Periodicity OFF = new Periodicity();
	
	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) 	{
			return x * fonction_1periodique_amplitude1(palette, iColor, iReel / period[iColor] + phase[iColor]);
		} else {
			return x;
		}
	}
	
	private double fonction_1periodique_amplitude1(Palette palette, int iColor, double x) {
		int n = palette.getNbColors();
		int e = (int)x;
		x -= e;
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
