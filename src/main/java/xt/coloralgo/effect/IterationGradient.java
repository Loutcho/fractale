package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.Complex;

public class IterationGradient implements Effect {

	private double tau;
	private double iBase;
	
	public IterationGradient(double tau, double iBase) {
		this.tau = tau;
		this.iBase = iBase;
	}

	@Override
	public double apply(Palette palette, int iColor, Complex z, double iReel) {
		if (iReel < iBase) {
			System.err.println("ARGL: (iBase = " + iBase + ") > (iReel = " + iReel + ")");
			return 1.0;
		}
		return Math.exp(- tau * (iReel - iBase));
	}
}
