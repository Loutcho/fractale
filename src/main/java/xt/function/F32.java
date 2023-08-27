package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class F32 implements Function<Complex, Complex> {

	private double k;
	private double a;
	
	public F32(double k, double a) {
		this.k = k;
		this.a = a;
	}
	
	@Override
	public Complex apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = x * x;
		double yy = y * y;
		double f = (1 - k) * (yy - xx * (1 - xx)) + k * (MyMath.sq(xx + yy) - 2 * (xx - yy));
		return Complex.polar(f, a * z.arg());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F32(");
		builder.append("k=" + k);
		builder.append(",");
		builder.append("a=" + a);
		builder.append(")");
		return builder.toString();
	}
}
