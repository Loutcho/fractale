package xt.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xt.math.Complex;

public class F4 implements Function {

	private RationalFraction r;
	
	public F4() {
		Map<Integer, List<Complex>> p = new HashMap<Integer, List<Complex>>();
		List<Complex> l;
	
		l = new ArrayList<Complex>();
		l.add(Complex.ei(0.0 * 2.0 * Math.PI / 5.0));
		l.add(Complex.ei(2.0 * 2.0 * Math.PI / 5.0));
		
		p.put(0, l);
	
		l = new ArrayList<Complex>();
		l.add(Complex.ei(1.0 * 2.0 * Math.PI / 5.0));
		l.add(Complex.ei(3.0 * 2.0 * Math.PI / 5.0));
		l.add(Complex.ei(4.0 * 2.0 * Math.PI / 5.0));
		p.put(1, l);
		
		r = new RationalFraction(p.get(0), p.get(1));
	}

	@Override
	public Complex apply(Complex z) {
		return r.apply(z);
	}

	@Override
	public String getHumanReadableFormula() {
		return "F4(z)";
	}
}
