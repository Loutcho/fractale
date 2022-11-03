package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class F12 implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		int d = 6;
		Complex sum = new Complex(0.0, 0.0);
		Complex zn = new Complex(1.0, 0.0);
		Complex a[] = new Complex[d + 1];
		a[0] = new Complex(+1.0,  0.0);
		a[1] = new Complex( 0.0, -2.0);
		a[2] = new Complex(-6.0,  0.0);
		a[3] = new Complex( 0.0, +17.0);
		a[4] = new Complex(+6.0,  0.0);
		a[5] = new Complex( 0.0, -2.0);
		a[6] = new Complex(-1.0,  0.0);
		for (int n = 0; n <= d; n ++) {
			sum = Complex.add(sum, Complex.mul(a[n], zn));
			zn = Complex.mul(zn, z);
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F12");
		return builder.toString();
	}
}
