package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Exp implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		return MyMath.exp(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Exp");
		return builder.toString();
	}
}
