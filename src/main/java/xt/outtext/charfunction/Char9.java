package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Rotate;

public class Char9 implements Function<Complex, Double> {
	
	private Function<Complex, Double> s;
	
	public Char9() {
		s = new Rotate(Math.PI, new Char6());
	}

	@Override
	public Double apply(Complex z) {
		return s.apply(z);
	}
}
