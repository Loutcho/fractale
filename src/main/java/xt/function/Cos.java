package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Cos implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		return MyMath.cos(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cos");
		return builder.toString();
	}
}
