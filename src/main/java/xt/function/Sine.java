package xt.function;

import xt.math.MyMath;
import xt.math.Complex;

public class Sine implements Function {

	@Override
	public Complex apply(Complex z) {
		return MyMath.sin(z);
	}

	@Override
	public String getHumanReadableFormula() {
		return "sin(z)";
	}
}
