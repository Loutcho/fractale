package xt.function;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;

public class Experiment implements Function {
	
	private RationalFraction r;

	public Experiment() {
		List<Complex> z = new ArrayList<>();
		List<Complex> p  = new ArrayList<>();

		p.add(new Complex(-1.0,  0.0));
		p.add(new Complex( 0.0, +1.0));
		p.add(new Complex(+1.0,  0.0));
		z.add(new Complex( 0.0, -1.0));
		
		r = new RationalFraction(z, p);
	}

	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}

	private static final double C = 2.0;
	private static final double K = 4.0;
	
	@Override
	public Complex apply(Complex z) {
		double r = z.abs();
		double t = z.arg();
		return Complex.polar(C * Math.cos(r) * Math.cos(K * t), C * Math.sin(r) * Math.sin(K * t));
	}
}
