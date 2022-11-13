package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F17 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		return Complex.mul(z, MyMath.cos(z));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F17");
		return builder.toString();
	}
}
