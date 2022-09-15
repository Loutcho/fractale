package xt.function;

import xt.math.MyMath;

import java.util.function.Function;

import xt.math.Complex;

public class Sin implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		return MyMath.sin(z);
	}
}
