package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Heart implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		Complex un = new Complex(1.0, 0.0);
		Exp exp = new Exp();
		Logarithm log = new Logarithm();
		Complex zz = log.apply(Complex.add(un, exp.apply(z)));
		return zz;
	}
}
