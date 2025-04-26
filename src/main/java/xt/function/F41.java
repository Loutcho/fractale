package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class F41 implements Function<Complex, Complex> {

	private RationalFraction r;
	
	public F41() {
		List<Complex> zeros = new ArrayList<>();
		zeros.add(new Complex(-2.0, +1.0));
		zeros.add(new Complex(0.0,  0.0));
		zeros.add(new Complex(+2.0, +1.0));
		
		List<Complex> poles = new ArrayList<>();
		poles.add(new Complex(+1.0, +1.0));
		poles.add(new Complex(-1.0, -1.0));

		r = new RationalFraction(zeros, poles);
	}
	
	public Complex apply(Complex z) {
		return Complex.mul(new Complex(0.006, 1.05), r.apply(z));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F41(");
		builder.append(")");
		return builder.toString();
	}
}
