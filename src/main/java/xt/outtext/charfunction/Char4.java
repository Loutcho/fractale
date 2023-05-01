package xt.outtext.charfunction;

import static xt.outtext.Union.u;
import static xt.outtext.Translate.t;
import static xt.outtext.buildingblock.SegmentHorizontal.hseg;
import static xt.outtext.buildingblock.SegmentVertical.vseg;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Compose;

public class Char4 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char4() {
		Function<Complex, Double> h = hseg(-1.0, +1.0);
		Function<Complex, Double> v = vseg(-1.0, +0.5);
		Function<Complex, Double> v1 = new Compose<>(v, t(-0.5,  0.0));
		Function<Complex, Double> w = vseg(0.0, +1.0);
		Function<Complex, Double> w1 = new Compose<>(w, t(+1.0,  0.0));
		s = u(h, v1, w1);
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
