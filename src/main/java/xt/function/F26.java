package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F26 implements Function<Complex, Complex> {
	
	private static final Complex K = Complex.polar(1.3, 0.5);
	
	private static final double A = -0.5;
	private static final double B = -0.5;
	private static final double C = +1.5;
	private static final double D = +0.5;

	@Override
	public Complex apply(Complex z) {
		Complex zz = Complex.mul(z, z);
		Complex zzz = Complex.mul(zz, z);
		Complex sum = Complex.ZERO;
		sum = Complex.add(sum, Complex.mul(A, zzz));
		sum = Complex.add(sum, Complex.mul(B, zz));
		sum = Complex.add(sum, Complex.mul(C, z));
		sum = Complex.add(sum, new Complex(D, 0.0));
		return Complex.mul(K, sum);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F26");
		return builder.toString();
	}
}
