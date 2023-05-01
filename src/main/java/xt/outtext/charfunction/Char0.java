package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.buildingblock.Ellipse;

public class Char0 implements Function<Complex, Double> {

	private Function<Complex, Double> s;
	
	private static final double A = 1.0;
	private static final double B = 1.0;
	
	public Char0() {
		s = new Ellipse(A, B);
	}
	
	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
