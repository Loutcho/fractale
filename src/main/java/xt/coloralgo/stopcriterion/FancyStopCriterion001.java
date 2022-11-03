package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public class FancyStopCriterion001 implements StopCriterion {

	@Override
	public boolean stopsAt(Complex z) {
		double r = z.abs();
		return Math.abs(r - 1.0) < 0.05 || Math.abs(z.arg()) < 0.05;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyStopCriterion001");
		return builder.toString();
	}
}
