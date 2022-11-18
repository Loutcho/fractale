package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class ColorFunction3 implements Effect {

	private double f(double x) {
		return 1.0 / (1.0 + x * x);
	}
	
	private static final double K = 2.0;
	private static final double E = 100.0;
	
	private double proximity(int iColor, Complex z) {
		double r = z.abs();
		Complex p = Complex.sub(z, new Complex(1.0, 0.0));
		double rp = p.abs();
		double vp = Math.max(f(K * rp), f(r));
		
		Complex i = Complex.sub(z, new Complex(0.0, 1.0));
		double ri = i.abs();
		double vi = Math.max(f(K * ri), f(r));
		
		Complex m = Complex.sub(z, new Complex(-1.0, 0.0));
		double rm = m.abs();
		double vm = Math.max(f(K * rm), f(r));
		
		Complex c = Complex.sub(z, new Complex(0.0, -1.0));
		double rc = c.abs();
		double vc = Math.max(f(K * rc), f(r));
		
		switch (iColor) {
		case 0:
			return Math.max(vp, vc);
		case 1:
			return Math.max(vc, vi);
		case 2:
			return Math.max(vi, vm);
		default:
			return 1.0;
		}
	}
	
	private double integer(double w) {
		return Math.pow(MyMath.sq(Math.cos(Math.PI * w)), E);
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double q = 0.0;
		double x = integer(z.re());
		double y = integer(z.im());
		q = MyMath.sq(x - y);
		q = Math.max(q, proximity(iColor, z));
		return q;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ColorFunction3()");
		return builder.toString();
	}
}
