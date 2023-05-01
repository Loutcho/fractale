package xt.outtext.charfunction;

import static xt.outtext.Union.u;
import static xt.outtext.Translate.t;
import static xt.outtext.buildingblock.SegmentHorizontal.hseg;
import static xt.outtext.buildingblock.SegmentVertical.vseg;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Compose;

public class Char5 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char5() {
		Function<Complex, Double> h = hseg(-1.0, +1.0);
		Function<Complex, Double> v = vseg(-0.5, +0.5);
		Function<Complex, Double> s1 = new Compose<>(h, t( 0.0, -1.0));
		Function<Complex, Double> s2 = new Compose<>(v, t(+1.0, -0.5));
		Function<Complex, Double> s3 = new Compose<>(h, t( 0.0,  0.0));
		Function<Complex, Double> s4 = new Compose<>(v, t(-1.0, +0.5));
		Function<Complex, Double> s5 = new Compose<>(h, t( 0.0, +1.0));
		s = u(s1, s2, s3, s4, s5);
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
