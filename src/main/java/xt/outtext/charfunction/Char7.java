package xt.outtext.charfunction;

import static xt.outtext.Union.u;
import static xt.outtext.Translate.t;
import static xt.outtext.buildingblock.SegmentHorizontal.hseg;
import static xt.outtext.buildingblock.SegmentVertical.vseg;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Compose;
import xt.outtext.Rotate;

public class Char7 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char7() {
		Function<Complex, Double> h = new Compose<>(hseg(-1.0, +1.0), t(0.0, -1.0));
		Function<Complex, Double> d = new Rotate(- Math.PI / 4.0, vseg(-Math.sqrt(2.0), +Math.sqrt(2.0)));
		s = u(h, d);
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
