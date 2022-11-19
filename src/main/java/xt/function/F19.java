package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F19 implements Function<Complex, Complex> {
	
	private static final Complex W = new Complex(1.618, 0.618);
	
	@Override
	public Complex apply(Complex z) {
		Complex zz = Complex.mul(W, z);
		if (z.abs() < 1.0) {
			zz = zz.inv().conj();
		}
		return zz;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F19");
		return builder.toString();
	}
}
