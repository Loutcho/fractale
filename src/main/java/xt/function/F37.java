package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F37 implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		Complex z0 = Complex.UN;
		Complex z1 = z;
		Complex z2 = Complex.mul(z, z);
		Complex z3 = Complex.mul(z2, z);
		Complex p = Complex.ZERO;
		p = Complex.add(p, Complex.mul( 1.0, z3));
		p = Complex.add(p, Complex.mul(-1.0, z2));
		p = Complex.add(p, Complex.mul( 2.0, z1));
		p = Complex.add(p, Complex.mul(-1.0, z0));
		Complex q = Complex.ZERO;
		q = Complex.add(q, Complex.mul( 1.0, z3));
		q = Complex.add(q, Complex.mul( 1.0, z2));
		q = Complex.add(q, Complex.mul( 0.0, z1));
		q = Complex.add(q, Complex.mul(-1.0, z0));

		return Complex.mul(0.55, Complex.div(q, p));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F37");
		return builder.toString();
	}
}
