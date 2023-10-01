package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F35 implements Function<Complex, Complex> {

	private double k;
	private double a;
	
	public F35(double k, double a) {
		this.k = k;
		this.a = a;
	}
	
	public Complex apply(Complex z) {
		double rho = z.abs();
		double ktheta = 1.0 + k * Math.cos(z.arg()) / (1.0 + rho);
		double arho = Math.tanh(a * Math.log(rho));
		Complex w = Complex.polar(ktheta, arho);
		return Complex.mul(w, z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F35(");
		builder.append(k);
		builder.append(",");
		builder.append(a);
		builder.append(")");
		return builder.toString();
	}
}
