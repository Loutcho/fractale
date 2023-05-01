package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;

import static xt.outtext.buildingblock.SegmentHorizontal.hseg;

public class CharMinus implements Function<Complex, Double> {

	private Function<Complex, Double> s;
	
	public CharMinus() {
		s = hseg(-0.5, +0.5);
	}
	
	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
