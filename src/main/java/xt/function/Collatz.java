package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Collatz implements Function<Complex, Complex> {

	private static final Complex ONE = new Complex(1.0, 0.0);
	
	private Function<Complex, Complex> ft;
	
	public Collatz() {
		this.ft = null;
	}
	
	public Collatz(Function<Complex, Complex> ft) {
		this.ft = ft;
	}
	
	private Complex evenCase(Complex z) {
		return Complex.mul(0.5, z);
	}
	
	private Complex oddCase(Complex z) {
		return Complex.add(Complex.mul(3.0, z), ONE); 
	}
	
	@Override
	public Complex apply(Complex z) {
		if (ft == null) {
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
		} else {
			Complex t = ft.apply(z);
			Complex u = Complex.sub(ONE, t);
			return Complex.add(Complex.mul(u, evenCase(z)), Complex.mul(t, oddCase(z)));
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Collatz(");
		builder.append(ft);
		builder.append(")");
		return builder.toString();
	}
}
