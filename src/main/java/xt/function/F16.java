package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F16 implements Function<Complex, Complex> {
	
	@Override
	public Complex apply(Complex z) {
		double t = z.arg();
		double r = z.abs();
		Complex zz = Complex.polar(r, t / 2.0);
		return Complex.div(MyMath.sin(zz), MyMath.cosh(zz));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F16");
		return builder.toString();
	}
}
