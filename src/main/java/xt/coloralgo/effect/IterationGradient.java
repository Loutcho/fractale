package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;

public class IterationGradient implements Effect {

	private boolean activated;
	private double tau;
	private double iBase;
	
	public IterationGradient(double tau, double iBase) {
		this.activated = true;
		this.tau = tau;
		this.iBase = iBase;
	}

	private IterationGradient() {
		activated = false;
	}
	
	public static final IterationGradient OFF = new IterationGradient();

	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			if (iReel < iBase) {
				System.err.println("ARGL: (iBase = " + iBase + ") > (iReel = " + iReel + ")");
				return x;
			} else {
				return x * Math.exp(- tau * (iReel - iBase));
			}
		} else {
			return x;
		}
	}
}
