package xt.function;

import xt.math.MyMath;

import java.util.function.Function;

import xt.math.Complex;

public class PrimeHyperbola implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		double n = z.re();
		double t = z.im();
		//double tt = 2.0 * (t - 0.5);
		//n = Math.pow(n, 2.0 - tt);
		//double xx = Math.sin(Math.PI * Math.pow(n, (1 + t) / 2.0));
		double xx = Math.sin(Math.PI * Math.pow(n, t));
		double yy = Math.sin(Math.PI * Math.pow(n, 1 - t));
		double rho = Math.E * Math.sqrt(MyMath.sq(xx) + MyMath.sq(yy));
		//double theta = rho * Math.log(n);
		//Complex zz = new Complex(xx, yy);
		Complex zz = Complex.mul(rho, Complex.ei(0.0)); 
		return zz;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrimeHyperbola");
		return builder.toString();
	}
}
