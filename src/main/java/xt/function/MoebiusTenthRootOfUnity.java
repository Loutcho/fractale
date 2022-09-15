package xt.function;

import java.util.function.Function;

import xt.math.Complex;

public class MoebiusTenthRootOfUnity implements Function<Complex, Complex> {

	public Complex apply(Complex z) {
		Complex accu = new Complex(1.0, 0.0);
		accu = f(z, accu, 1);
		accu = g(z, accu, 2);
		accu = g(z, accu, 3);
		accu = g(z, accu, 5);
		accu = f(z, accu, 6);
		accu = g(z, accu, 7);
		accu = f(z, accu, 10);
		return accu;
	}

	public Complex f(Complex z, Complex accu, int n) {
		for (int k = 0; k < n; k ++) {
			double theta = 2.0 * Math.PI * k / n;
			Complex z0 = Complex.ei(theta);
			accu = Complex.mul(accu, Complex.sub(z, z0));
		}
		return accu;
	}

	public Complex g(Complex z, Complex accu, int n) {
		for (int k = 0; k < n; k ++) {
			double theta = 2.0 * Math.PI * k / n;
			Complex z0 = Complex.ei(theta);
			accu = Complex.div(accu, Complex.sub(z, z0));
		}
		return accu;
	}
}
