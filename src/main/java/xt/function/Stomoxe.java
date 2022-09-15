package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Stomoxe implements Function<Complex, Complex> {
	
	private static final Complex One = new Complex(1.0, 0.0);
	
	private static Complex t(Complex z) {
		double x = z.re();
		double y = z.im();
		x = MyMath.sq(Math.sin(Math.PI * x / 2.0));
		return new Complex(x, y);
	}
	
	@Override
	public Complex apply(Complex z) {

		Complex q = t(z);
		Complex p = Complex.sub(One, q);
		
		Complex z1 = Complex.mul(0.5, z);
		Complex z2 = Complex.add(Complex.mul(3.0, z), One);
		
		return Complex.add(Complex.mul(p, z1), Complex.mul(q, z2));
	}
}
