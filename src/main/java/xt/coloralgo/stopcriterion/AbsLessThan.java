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

}
