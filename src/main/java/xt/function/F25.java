package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F25 implements Function<Complex, Complex> {
	
	private static final double K = 0.2;
	
	@Override
	public Complex apply(Complex z) {
		return Complex.sub(Complex.mul(z, MyMath.tan(Complex.mul(K, z))), z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F25");
		return builder.toString();
	}
}
