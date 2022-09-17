package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class Bubble implements Effect {

	double period[];
	double phase[];
	
	public Bubble(double redPeriod, double redPhase, double greenPeriod, double greenPhase, double bluePeriod, double bluePhase) {
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
	public double apply(int iColor, Complex z, double iReel) {
		return Math.max(MyMath.sqcosdemi(z.arg()), MyMath.sqcosdemi(Math.PI * (iReel / period[iColor] + phase[iColor])));
	}
}
