package xt.function;

import xt.math.Complex;

public class Identity implements Function {
	public Complex apply(Complex z)
	{
		return z;
	}

	@Override
	public String getHumanReadableFormula() {
		return "z";
	}

}
