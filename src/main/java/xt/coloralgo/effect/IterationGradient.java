package xt.coloralgo.effect;

import xt.math.Complex;

public class IterationGradient implements Effect {

	private double tau;
	private double iBase;
	
	public IterationGradient(double tau, double iBase) {
		this.tau = tau;
		this.iBase = iBase;
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		if (i < iBase) {
			// System.err.println("ARGL: (iBase = " + iBase + ") > (iReel = " + iReel + ")");
			return 1.0;
		}
		return Math.exp(- tau * (i - iBase));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IterationGradient(");
		builder.append(tau);
		builder.append(", ");
		builder.append(iBase);
		builder.append(")");
		return builder.toString();
	}
}
