package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.math.Complex;
import xt.math.MyMath;

public class SpecialColorFunction1 implements Effect {

	private double f(double x) {
		return 1.0 / (1.0 + x * x);
	}
	
	private static final double K = 2.0;
	private static final double E = 100.0;
	
	private double proximity(int iColor, Complex z) {
		double r = z.abs();
		switch (iColor) {
		case 0:
			Complex p = Complex.sub(z, new Complex(1.0, 0.0));
			double rp = p.abs();
			return Math.max(f(K * rp), f(r));
		case 1:
			return f(K * r);
		case 2:
			Complex m = Complex.sub(z, new Complex(-1.0, 0.0));
			double rm = m.abs();
			return Math.max(f(K * rm), f(r));
		default:
			return 1.0;
		}
	}
	
	private double integer(double w) {
		return Math.pow(MyMath.sq(Math.cos(Math.PI * w)), E);
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double q = 0.0;
		double x = integer(z.re());
		double y = integer(z.im());
		q = MyMath.sq(x - y);
		q = Math.max(q, proximity(iColor, z));
		return q;
	}
}
