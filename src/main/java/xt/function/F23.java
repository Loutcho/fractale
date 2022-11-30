package xt.function;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;

/*
 * Soit un mur d'équation |z| = 1, privé du point 1 -- la porte de sortie. 
 * f(z) := la distance la plus courte pour se rendre de 0 à z en évitant le mur.
 */
public class F23 implements Function<Complex, Complex> {
	
	private double d(Complex z) {
		double x0 = z.re();
		double y0 = z.im();
		double rr0 = x0 * x0 + y0 * y0;
		if (rr0 < 1.0) {
			return Math.sqrt(rr0);
		}
		if (x0 >= 1.0) {
			return 1.0 + Math.sqrt(MyMath.sq(x0 - 1.0) + MyMath.sq(y0));
		}
		double dd = Math.sqrt(rr0 - 1.0);
		double epsilon = (y0 >= 0.0) ? +1.0 : -1.0;
		double x1 = (x0 + epsilon * y0 * dd) / rr0;
		double y1 = (y0 - epsilon * x0 * dd) / rr0;
		double theta = Math.atan2(y1, x1);
		return 1.0 + Math.abs(theta) + Math.sqrt(MyMath.sq(x1 - x0) + MyMath.sq(y1 - y0));
	}
	
	@Override
	public Complex apply(Complex z) {
		return new Complex(d(z), 0.0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F23");
		return builder.toString();
	}
}
