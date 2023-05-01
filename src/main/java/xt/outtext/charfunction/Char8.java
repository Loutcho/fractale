package xt.outtext.charfunction;

import static xt.outtext.Union.u;
import static xt.outtext.Translate.t;
import static xt.outtext.buildingblock.SegmentHorizontal.hseg;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Compose;
import xt.outtext.buildingblock.Ellipse;

public class Char8 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char8() {
		Function<Complex, Double> e = new Ellipse(1.0, 0.5);
		Function<Complex, Double> e1 = new Compose<Complex, Complex, Double>(e, t( 0.0, +0.5));
		Function<Complex, Double> e2 = new Compose<Complex, Complex, Double>(e, t( 0.0, -0.5));
		Function<Complex, Double> h = hseg(-0.36, 0.36);
		s = u(e1, e2, h);
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
