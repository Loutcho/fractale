package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Experiment implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		return Complex.mul(MyMath.cos(z), MyMath.sinh(z));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Experiment");
		return builder.toString();
	}
}
