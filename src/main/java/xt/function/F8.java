package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F8 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		return Complex.mul(MyMath.cos(z), MyMath.sinh(z));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F8");
		return builder.toString();
	}
}
