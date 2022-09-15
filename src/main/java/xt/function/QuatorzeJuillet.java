package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class QuatorzeJuillet implements Function<Complex, Complex> {
	
	private RationalFraction r;

	public QuatorzeJuillet() {
		List<Complex> z = new ArrayList<>();
		List<Complex> p  = new ArrayList<>();

		p.add(new Complex(-1.0, 0.0));
		p.add(new Complex( 0.0, 1.0));
		p.add(new Complex(+1.0, 0.0));
		
		r = new RationalFraction(z, p);
	}

	@Override
	public Complex apply(Complex z) {
		return r.apply(z);
	}
}
