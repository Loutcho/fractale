package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class Hiroshima implements Function<Complex, Complex> {

	RationalFraction r;
	
	public Hiroshima() {
		List<Complex> zeros = new ArrayList<>();
		List<Complex> poles = new ArrayList<>();
		zeros.add(new Complex(0.0,  0.0));
		zeros.add(new Complex(-1.2, -0.7));
		zeros.add(new Complex(-0.3, -0.3));
		r = new RationalFraction(zeros, poles);
	}
	
	public Complex apply(Complex z) {
		return r.apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hiroshima");
		return builder.toString();
	}
}
