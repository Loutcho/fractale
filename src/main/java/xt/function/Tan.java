package xt.function;

import xt.math.MyMath;
import xt.math.Complex;

public class Tan implements Function {

	@Override
	public Complex apply(Complex z) {
		return MyMath.tan(z);
	}

	@Override
	public String getHumanReadableFormula() {
		return "tan(z)";
	}
}
