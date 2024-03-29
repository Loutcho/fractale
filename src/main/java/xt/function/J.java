package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class J implements Function<Complex, Complex> {

	private RationalFraction r;
	
	private final double DEG = Math.PI / 180.0;
	
	public J() {
		List<Complex> z = new ArrayList<>();
		List<Complex> p  = new ArrayList<>();
		
		p.add(new Complex(-1.0,  3.0));
		z.add(new Complex(-0.5,  3.0));
		p.add(new Complex( 0.0,  3.0));
		z.add(new Complex( 0.5,  3.0));
		p.add(new Complex(1.0, 3.0));	
		z.add(new Complex( 1.5,  3.0));
		p.add(new Complex( 2.0,  3.0));
		z.add(new Complex( 1.0,  2.5));
		p.add(new Complex( 1.0,  2.0));
		z.add(new Complex( 1.0,  1.5));
		p.add(new Complex( 1.0,  1.0));
		z.add(new Complex( 1.0,  0.5));
		p.add(new Complex( 1.0,  0.0));
		p.add(new Complex(0.0 + Math.cos(30.0 * DEG), 0.0 - Math.sin(30.0 * DEG)));
		p.add(new Complex(0.0 + Math.cos(60.0 * DEG), 0.0 - Math.sin(60.0 * DEG)));
		p.add(new Complex( 0.0, -1.0));
		p.add(new Complex(0.0 - Math.cos(60.0 * DEG), 0.0 - Math.sin(60.0 * DEG)));
		p.add(new Complex(0.0 - Math.cos(30.0 * DEG), 0.0 - Math.sin(30.0 * DEG)));
		p.add(new Complex(-1.0, 0.0));
		/*
		for (int i = 1; i <= 9; i ++) {
			z.add(new Complex(0.0, 0.0));	
		}
		*/
		r = new RationalFraction(z, p);
	}
	
	public Complex apply(Complex z) {
		return r.apply(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("J");
		return builder.toString();
	}
}
