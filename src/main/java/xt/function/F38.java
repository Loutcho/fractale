package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F38 implements Function<Complex, Complex> {

	private static final Complex A1 = Complex.mul(1.5, Complex.ei( 0.00000000 * Math.PI));
	private static final Complex A2 = Complex.mul(1.5, Complex.ei(-0.59700000 * Math.PI));
	private static final Complex A3 = Complex.mul(1.5, Complex.ei( 0.50000000 * Math.PI));
	
	public Complex apply(Complex z) {
		if (z.abs() < 1.0) {
			Complex zz = Complex.mul(z.conj().inv(), Complex.ei(0.0));
			return zz;
		}
		Complex z1;
		double r1;

		z1 = Complex.sub(z, A1);
		r1 = 2.0 * (0.5 - z1.abs()); 
		if (r1 > 0.0) {
			return Complex.mul(Complex.ei(+ 2.0 * r1 * Math.PI), Complex.mul(2.0, z1));
		}

		z1 = Complex.sub(z, A2);
		r1 = 2.0 * (0.5 - z1.abs()); 
		if (r1 > 0.0) {
			return Complex.mul(Complex.ei(- (1.0 / 3.0) * r1 * Math.PI), Complex.mul(2.0, z1));
		}
		
		z1 = Complex.sub(z, A3);
		r1 = 2.0 * (0.5 - z1.abs()); 
		if (r1 > 0.0) {
			return Complex.mul(Complex.ei(- (1.0 / 5.0) * r1 * Math.PI), Complex.mul(2.0, z1));
		}

		return Complex.mul(z, z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F38");
		return builder.toString();
	}
}
