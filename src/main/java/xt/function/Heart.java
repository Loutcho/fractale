package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class Heart implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		Complex un = new Complex(1.0, 0.0);
		Exp exp = new Exp();
		Log log = new Log();
		Complex zz = log.apply(Complex.add(un, exp.apply(z)));
		return zz;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Heart");
		return builder.toString();
	}
}
