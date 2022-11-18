package xt.coloralgo.effect;

import java.util.Arrays;

import xt.math.Complex;
import xt.math.MyMath;

public class Bubble implements Effect {

	double period[];
	double phase[];
	boolean smooth;
	
	public Bubble(double redPeriod, double redPhase, double greenPeriod, double greenPhase, double bluePeriod, double bluePhase, boolean smooth) {
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
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double ii = (double) i;
		if (smooth) {
			i += MyMath.smooth(z.abs());
		}
		return Math.max(MyMath.sqcosdemi(z.arg()), MyMath.sqcosdemi(Math.PI * (ii / period[iColor] + phase[iColor])));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bubble [period=");
		builder.append(Arrays.toString(period));
		builder.append(", phase=");
		builder.append(Arrays.toString(phase));
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void multiplyPeriod(double coef) {
		period[0] *= coef;
		period[1] *= coef;
		period[2] *= coef;
	}
	
	@Override
	public void incrementPhase(double deltaPhase) {
		period[0] = (period[0] + deltaPhase) % 1.0;
		period[1] = (period[1] + deltaPhase) % 1.0;
		period[2] = (period[2] + deltaPhase) % 1.0;
	}
}
