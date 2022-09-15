package xt.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class F5 implements Function<Complex, Complex> {

	private RationalFraction r;

	public F5() {
		int n = 12;

		List<Complex> num = new ArrayList<Complex>();
		for (int k = 0; k < n; k++) {
			if (k % 2 == 1) {
				num.add(Complex.ei(k * ((2.0 * Math.PI) / n)));
			}
		}

		List<Complex> den = new ArrayList<Complex>();
		for (int k = 0; k < n; k++) {
			if (k % 2 == 0) {
				den.add(Complex.ei(k * ((2.0 * Math.PI) / n)));
			}
		}

		r = new RationalFraction(num, den);
	}

	@Override
	public Complex apply(Complex z) {
		return r.apply(z);
	}
}
