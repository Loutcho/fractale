package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F14 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		return Complex.div(new Complex(1.0, 0.0), MyMath.sin(z));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F14");
		return builder.toString();
	}
}
