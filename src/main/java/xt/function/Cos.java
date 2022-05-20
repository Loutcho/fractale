package xt.function;

import xt.math.MyMath;
import xt.math.Complex;

public class Cos implements Function {

	@Override
	public Complex apply(Complex z) {
		return MyMath.cos(z);
	}

	@Override
	public String getHumanReadableFormula() {
		return "cos(z)";
	}
}
