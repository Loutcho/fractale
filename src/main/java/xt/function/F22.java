package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F22 implements Function<Complex, Complex> {
	
	private double n;
	
	public F22(double n) {
		this.n = n;
	}
	
	@Override
	public Complex apply(Complex z) {
		Complex zz = MyMath.exp(Complex.mul(new Complex(0.0, 2.0 * Math.PI / n), z));
		return Complex.add(z, zz);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F22");
		return builder.toString();
	}
}
