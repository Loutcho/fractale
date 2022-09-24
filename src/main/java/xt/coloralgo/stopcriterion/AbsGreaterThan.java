package xt.coloralgo.stopcriterion;

import java.util.function.Predicate;

import xt.math.Complex;

public class AbsGreaterThan implements Predicate<Complex> {

	private double threshold;
	
	public AbsGreaterThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean test(Complex t) {
		return (t.abs() > threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbsGreaterThan(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
