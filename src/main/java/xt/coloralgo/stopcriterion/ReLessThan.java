package xt.coloralgo.stopcriterion;

import java.util.function.Predicate;

import xt.math.Complex;

public class ReLessThan implements Predicate<Complex> {

	private double threshold;
	
	public ReLessThan(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public boolean test(Complex t) {
		return (t.re() < threshold);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReLessThan(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
