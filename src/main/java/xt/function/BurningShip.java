package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class BurningShip implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		
		double xx = Math.abs(x); 
		double yy = Math.abs(y);
		Complex zz = new Complex(xx, yy);
		return Complex.mul(zz, zz);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BurningShip");
		return builder.toString();
	}
}
