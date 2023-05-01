package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;

import static xt.outtext.buildingblock.SegmentVertical.vseg;

public class Char1 implements Function<Complex, Double> {

	private Function<Complex, Double> s;
	
	public Char1() {
		s = vseg(-1.0, +1.0);
	}
	
	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
