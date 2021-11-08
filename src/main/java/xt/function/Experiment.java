package xt.function;

import xt.math.Complex;

public class Experiment implements Function {

	public Complex apply(Complex z) {
		Complex accu = new Complex(1.0, 0.0);
		accu = f(z, accu, 1);
		accu = g(z, accu, 2);
		accu = g(z, accu, 3);
		accu = g(z, accu, 5);
		accu = f(z, accu, 6);
		accu = g(z, accu, 7);
		accu = f(z, accu, 10);
		/*
		accu = g(z, accu, 11);
		accu = g(z, accu, 13);
		accu = f(z, accu, 14);
		accu = f(z, accu, 15);
		accu = g(z, accu, 17);
		accu = g(z, accu, 19);
		accu = f(z, accu, 21);
		accu = f(z, accu, 22);
		accu = g(z, accu, 23);
		accu = f(z, accu, 26);
		accu = g(z, accu, 29);
		accu = g(z, accu, 30);
		accu = g(z, accu, 31);
		accu = f(z, accu, 33);
		accu = f(z, accu, 34);
		accu = f(z, accu, 35);
		accu = g(z, accu, 37);
		accu = f(z, accu, 38);
		accu = f(z, accu, 39);
		accu = g(z, accu, 41);
		accu = g(z, accu, 42);
		accu = g(z, accu, 43);
		accu = f(z, accu, 46);
		accu = g(z, accu, 47);
		accu = f(z, accu, 51);
		accu = g(z, accu, 53);
		accu = f(z, accu, 55);
		accu = f(z, accu, 57);
		accu = f(z, accu, 58);
		accu = g(z, accu, 59);
		accu = g(z, accu, 61);
		accu = f(z, accu, 62);
		accu = f(z, accu, 65);
		accu = g(z, accu, 66);
		accu = g(z, accu, 67);
		accu = f(z, accu, 69);
		accu = g(z, accu, 70);
		*/
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

	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}
}
