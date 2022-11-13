package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class F18 implements Function<Complex, Complex> {
	
	private RationalFraction r;

	public F18() {
		List<Complex> zeros;
		List<Complex> poles;

		zeros = new ArrayList<Complex>();
		zeros.add(new Complex( 0.0,  0.0));
		zeros.add(new Complex(-0.9, -0.9));
		zeros.add(new Complex(+0.9, +0.9));
		zeros.add(new Complex(+0.9, -0.9));
		zeros.add(new Complex(-0.9, +0.9));

		poles = new ArrayList<Complex>();
		poles.add(new Complex(+1.1,  0.0));
		poles.add(new Complex(-1.1,  0.0));
		poles.add(new Complex( 0.0, +1.1));
		poles.add(new Complex( 0.0, -1.1));
		
		r = new RationalFraction(zeros, poles);
	}

	@Override
	public Complex apply(Complex z) {
		return r.apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F18");
		return builder.toString();
	}
}
