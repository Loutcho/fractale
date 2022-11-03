package xt.coloralgo.stopcriterion;

import xt.math.Complex;

public class AbsLessThan implements StopCriterion {

	private Complex z0;
	private double threshold;
	
	public AbsLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	public AbsLessThan(Complex z0, double threshold) {
		this.z0 = z0;
		this.threshold = threshold;
	}
	
	@Override
	public boolean stopsAt(Complex t) {
		if (z0 == null) {
			return (t.abs() < threshold);
		} else {
			return (Complex.sub(t, z0).abs() < threshold);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsLessThan(");
		builder.append(z0);
		builder.append(", ");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		threshold *= coef;
	}
}
