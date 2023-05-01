package xt.outtext.charfunction;

import static xt.outtext.Union.u;
import static xt.outtext.Translate.t;
import static xt.outtext.buildingblock.SegmentHorizontal.hseg;
import static xt.outtext.buildingblock.SegmentVertical.vseg;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Compose;

public class Char6 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char6() {
		Function<Complex, Double> v1 = new Compose<>(vseg(-1.0, +1.0), t(+1.0,  0.0));
		Function<Complex, Double> v2 = new Compose<>(vseg(-1.0,  0.0), t(-1.0,  0.0));
		Function<Complex, Double> h1 = new Compose<>(hseg(-1.0, +1.0), t( 0.0, +1.0));
		Function<Complex, Double> h2 = new Compose<>(hseg(-1.0, +1.0), t( 0.0,  0.0));
		Function<Complex, Double> h3 = new Compose<>(hseg(-1.0, +1.0), t( 0.0, -1.0));
		s = u(v1, v2, h1, h2, h3);
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
