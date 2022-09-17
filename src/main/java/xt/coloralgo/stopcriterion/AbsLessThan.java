package xt.coloralgo.stopcriterion;

import java.util.function.Predicate;

import xt.math.Complex;

public class AbsLessThan implements Predicate<Complex> {

	private double threshold;
	
	public AbsLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean test(Complex t) {
		return (t.abs() < threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new AbsLessThan(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
