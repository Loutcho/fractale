package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F44 implements Function<Complex, Complex> {

	public F44(Complex v, Complex w, Complex p) {
		this.v = v;
		this.w = w;
		this.p = p;
	}
	
	private Complex v;
	private Complex w;
	private Complex p;
	
	private Complex f(Complex z) {
		Complex vz = Complex.mul(v, z);
		double x = vz.re();
		double y = vz.im();
		double xx = repliage(x);
		double yy = y + 1.5 * Math.sqrt(Math.sqrt(x));
		return Complex.add(Complex.mul(w, new Complex(xx, yy)), p);
	}

	private static double repliage(double x) {
		if (x < -1.0) return MyMath.sq(-2.0 - x);
		if (+1.0 < x) return MyMath.sq(+2.0 - x);
		return x;
	}
	
	public Complex apply(Complex z) {
		return f(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F44(");
		builder.append("v = " + v);
		builder.append(",");
		builder.append("w = " + w);
		builder.append(",");
		builder.append("p = " + p);
		builder.append(")");
		return builder.toString();
	}
}
