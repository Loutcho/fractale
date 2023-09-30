package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

public class Stomoxe implements Function<Complex, Complex> {
	
	private double a;
	private double b;
	
	public Stomoxe(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
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
		
		Complex z1 = Complex.mul(a, z);
		Complex z2 = Complex.add(Complex.mul(b, z), One);
		
		return Complex.add(Complex.mul(p, z1), Complex.mul(q, z2));
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stomoxe(");
		builder.append(a);
		builder.append(",");
		builder.append(b);
		builder.append(")");
		return builder.toString();
	}
}
