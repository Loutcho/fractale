package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F7 implements Function<Complex, Complex> {

	private static final Complex A = new Complex(0.0, 3.0);
	private static final Complex One = new Complex(1.0, 0.0); 
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		int xx = (int) Math.rint(x);
		int yy = (int) Math.rint(y);
		if (((xx + yy) % 2) == 0) {
			return Complex.add(Complex.mul(A, z), One);
		} else {
			return new Complex(x / 2.0, y / 2.0);
		}
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F6");
		return builder.toString();
	}
}
