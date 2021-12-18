package xt.function;

import xt.math.Complex;

public class Experiment implements Function {

	public Complex apply(Complex z) {
		Complex un = new Complex(1.0, 0.0);
		Exponential exp = new Exponential();
		Logarithm log = new Logarithm();
		Complex zz = log.apply(Complex.add(un, exp.apply(z)));
		return zz;
	}

	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}
}
