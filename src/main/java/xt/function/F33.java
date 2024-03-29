package xt.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import xt.math.Complex;

public class F33 implements Function<Complex, Complex> {

	RationalFraction r;
	
	public F33() {
		Map<Integer, List<Complex>> p = new HashMap<Integer, List<Complex>>();
		List<Complex> l;

		l = new ArrayList<Complex>();
		l.add(new Complex(-1.0,  0.0));
		l.add(new Complex(-1.0,  0.0));
		p.put(0, l);

		l = new ArrayList<Complex>();
		l.add(new Complex(+1.0, +0.25));
		l.add(new Complex(+1.0, -0.25));
		p.put(1, l);
		
		r = new RationalFraction(p.get(0), p.get(1));
	}
	
	public Complex apply(Complex z) {
		return r.apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F33");
		return builder.toString();
	}
}
