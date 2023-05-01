package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;

import static xt.outtext.buildingblock.SegmentVertical.vseg;

public class CharComma implements Function<Complex, Double> {

	private Function<Complex, Double> s;
	
	public CharComma() {
		s = vseg(-1.0, -0.5);
	}
	
	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
