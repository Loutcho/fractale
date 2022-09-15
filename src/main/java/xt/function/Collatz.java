package xt.function;

import xt.math.MyMath;

import java.util.function.Function;

import xt.math.Complex;

public class Collatz implements Function<Complex, Complex> {

	@Override
	public Complex apply(Complex z) {
		Complex piz = Complex.mul(Math.PI, z);
		Complex cinqz = Complex.mul(5.0, z);
		Complex septz = Complex.mul(7.0, z);
		Complex deux = new Complex(2.0, 0.0);
		Complex deuxpluscinqz = Complex.add(deux, cinqz);
		Complex deuxplusseptz = Complex.add(deux, septz);
		Complex zz = Complex.mul(deuxpluscinqz, MyMath.cos(piz));
		zz = zz.neg();
		zz = Complex.add(zz, deuxplusseptz);
		return Complex.mul(0.25, zz);
	}
}
