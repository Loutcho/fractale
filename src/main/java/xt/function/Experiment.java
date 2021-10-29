package xt.function;

import xt.math.Complex;

public class Experiment implements Function {

	public Complex apply(Complex z) {
		Complex un = new Complex(1, 0);
		Complex i = new Complex(1, 1);
		return Complex.div(Complex.sub(z, i), Complex.add(z, i));
	}

	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}
}
