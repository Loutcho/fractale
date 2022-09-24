package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class B implements Function<Complex, Complex> {

	private RationalFraction r;
	
	public B() {
		List<Complex> z = new ArrayList<>();
		List<Complex> p  = new ArrayList<>();
		
		p.add(new Complex(0.0, 0.0));
		p.add(new Complex(0.0, 1.0));
		z.add(new Complex(2.0, 1.0));
		p.add(new Complex(0.0, 2.0));
		p.add(new Complex(0.0, 3.0));
		z.add(new Complex(2.0, 3.0));
		p.add(new Complex(0.0, 4.0));
		z.add(new Complex(0.5, 0.0));
		z.add(new Complex(0.5, 2.0));
		z.add(new Complex(0.5, 4.0));
		p.add(new Complex(0.0, 0.5));
		p.add(new Complex(0.0, 1.5));
		p.add(new Complex(0.0, 2.5));
		p.add(new Complex(0.0, 3.5));
		p.add(new Complex(-0.5, 4.0));
		z.add(new Complex(-0.5, 0.0));
		p.add(new Complex(1.0, 0.0));
		p.add(new Complex(1.0, 2.0));
		z.add(new Complex(1.0, 4.0));
		p.add(new Complex(1.0 + 0.259, 3 - 0.966)); // 15�
		p.add(new Complex(1.0 + 0.500, 3 - 0.866)); // 30�
		z.add(new Complex(1.0 + 0.707, 3 - 0.707)); // 45�
		p.add(new Complex(1.0 + 0.866, 3 - 0.500)); // 60�
		p.add(new Complex(1.0 + 0.966, 3 - 0.259)); // 75�
		z.add(new Complex(1.0 + 0.259, 3 + 0.966)); // 15�
		p.add(new Complex(1.0 + 0.500, 3 + 0.866)); // 30�
		p.add(new Complex(1.0 + 0.707, 3 + 0.707)); // 45�
		z.add(new Complex(1.0 + 0.866, 3 + 0.500)); // 60�
		p.add(new Complex(1.0 + 0.966, 3 + 0.259)); // 75�
		p.add(new Complex(1.0 + 0.259, 1 - 0.966)); // 15�
		z.add(new Complex(1.0 + 0.500, 1 - 0.866)); // 30�
		p.add(new Complex(1.0 + 0.707, 1 - 0.707)); // 45�
		p.add(new Complex(1.0 + 0.866, 1 - 0.500)); // 60�
		z.add(new Complex(1.0 + 0.966, 1 - 0.259)); // 75�
		p.add(new Complex(1.0 + 0.259, 1 + 0.966)); // 15�
		p.add(new Complex(1.0 + 0.500, 1 + 0.866)); // 30�
		z.add(new Complex(1.0 + 0.707, 1 + 0.707)); // 45�
		p.add(new Complex(1.0 + 0.866, 1 + 0.500)); // 60�
		p.add(new Complex(1.0 + 0.966, 1 + 0.259)); // 75�	
		r = new RationalFraction(z, p);
	}
	
	public Complex apply(Complex z) {
		return r.apply(z);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("B");
		return builder.toString();
	}
}
