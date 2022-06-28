package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.MyMath;

public class Bubble implements Effect {

	private boolean activated;
	double period[];
	double phase[];
	
	public boolean isActivated() {
		return activated;
	}
	
	public Bubble(double redPeriod, double redPhase, double greenPeriod, double greenPhase, double bluePeriod, double bluePhase) {
		this.activated = true;
		period = new double[3];
		phase = new double[3];
		period[0] = redPeriod;
		period[1] = greenPeriod;
		period[2] = bluePeriod;
		phase[0] = redPhase;
		phase[1] = greenPhase;
		phase[2] = bluePhase;
	}
	
	private Bubble() {
		activated = false;
	}
	
	public static final Bubble OFF = new Bubble();

	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			return x * Math.max(MyMath.sqcosdemi(theta), MyMath.sqcosdemi(Math.PI * (iReel / period[iColor] + phase[iColor])));
		} else {
			return x;
		}
	}
}
