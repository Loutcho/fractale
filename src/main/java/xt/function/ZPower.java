package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class ZPower implements Function<Complex, Complex> {

	private Integer n;
	private Double nn;
	
	public ZPower(int n) {
		this.n = n;
		this.nn = null;
	}
	
	public ZPower(double nn) {
		this.n = null;
		this.nn = nn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZPower(");
		if (n != null) {
			builder.append(n);
		}
		if (nn != null) {
			builder.append(nn);
		}
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public Complex apply(Complex z) {
		if (n != null) {
			Complex accu = new Complex(1.0, 0.0);
			for (int i = 0; i < n; i ++)
			{
				accu = Complex.mul(accu, z);
			}
			return accu;
		} else {
			// z = r*e^(i*t)
			// z^nn = r^nn * e^(nn*i*t)
			double r = z.abs();
			double t = z.arg();
			r = Math.pow(r, nn);
			t = nn * t;
			return Complex.mul(r, Complex.ei(t));
		}
	}
}
