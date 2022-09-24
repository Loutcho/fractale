package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Identity implements Function<Complex, Complex> {
	public Complex apply(Complex z)	{
		return z;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Identity");
		return builder.toString();
	}
}
