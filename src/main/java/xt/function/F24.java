package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class F24 implements Function<Complex, Complex> {
	
	RationalFraction p;
	
	public F24() {
		List<Complex> zeros = new ArrayList<>();
		List<Complex> poles = new ArrayList<>();
		zeros.add(new Complex(+1.0,  0.0));
		zeros.add(new Complex(-1.0,  0.0));
		poles.add(new Complex( 0.0,  0.0));
		poles.add(new Complex( 0.0, -1.0));
		poles.add(new Complex( 0.0, +1.0));
		p = new RationalFraction(zeros, poles);
	}
	
	@Override
	public Complex apply(Complex z) {
		return p.apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F24");
		return builder.toString();
	}
}
