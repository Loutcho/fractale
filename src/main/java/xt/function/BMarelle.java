package xt.function;

import xt.math.Complex;

/*
 * Dénominateur de b(n)/(1+t),
 * le numérateur étant : prod(k=1,floor(n/2),(t+u+2*cos((2*k-1)*Pi/n)))
 */
public class BMarelle implements Function {

	private int n;

	public BMarelle(int n) {
		this.n = n;
	}

	private double b1(double t, double u) {
		return t + 1;
	}

	private double b2(double t, double u) {
		return t;
	}

	private double b3(double t, double u) {
		double t2 = t*t;
		return t2 + (u + 1)*t - 1;
	}

	private double b4(double t, double u) {
		double t2 = t*t;
		return t2 + u*t - 1;
	}

	private double b5(double t, double u) {
		double t2 = t*t, t3 = t2*t;
		double u2 = u*u;
		return t3 + (2*u + 1)*t2 + (u2 + u - 2)*t + (-u - 1);
	}

	private double b6(double t, double u) {
		double t2 = t*t, t3 = t2*t;
		double u2 = u*u;
		return t3 + 2*u*t2 + (u2 - 2)*t - u;
	}
	private double b7(double t, double u) {
		double t2 = t*t, t3 = t2*t, t4 = t3*t;
		double u2 = u*u, u3 = u2*u;
		return t4 + (3*u + 1)*t3 + (3*u2 + 2*u - 3)*t2 + (u3 + u2 - 4*u - 2)*t + (-u2 - u + 1);
	}

	private double b8(double t, double u) {
		double t2 = t*t, t3 = t2*t, t4 = t3*t;
		double u2 = u*u, u3 = u2*u;
		return t4 + 3*u*t3 + (3*u2 - 3)*t2 + (u3 - 4*u)*t + (-u2 + 1);
	}

	private double b9(double t, double u) {
		double t2 = t*t, t3 = t2*t, t4 = t3*t, t5 = t4*t;
		double u2 = u*u, u3 = u2*u, u4 = u3*u;
		return (t5 + (4*u + 1)*t4 + (6*u2 + 3*u - 4)*t3 + (4*u3 + 3*u2 - 9*u - 3)*t2 + (u4 + u3 - 6*u2 - 4*u + 3)*t + (-u3 - u2 + 2*u + 1));
	}

	private double b10(double t, double u) {
		double t2 = t*t, t3 = t2*t, t4 = t3*t, t5 = t4*t;
		double u2 = u*u, u3 = u2*u, u4 = u3*u;
		return t5 + 4*u*t4 + (6*u2 - 4)*t3 + (4*u3 - 9*u)*t2 + (u4 - 6*u2 + 3)*t + (-u3 + 2*u);
	}

	private double b11(double t, double u) {
		double t2 = t*t, t3 = t2*t, t4 = t3*t, t5 = t4*t, t6 = t5*t;
		double u2 = u*u, u3 = u2*u, u4 = u3*u, u5 = u4*u;
		return t6 + (5*u + 1)*t5 + (10*u2 + 4*u - 5)*t4 + (10*u3 + 6*u2 - 16*u - 4)*t3 + (5*u4 + 4*u3 - 18*u2 - 9*u + 6)*t2 + (u5 + u4 - 8*u3 - 6*u2 + 9*u + 3)*t + (-u4 - u3 + 3*u2 + 2*u - 1);
	}

	@Override
	public Complex apply(Complex z) {
		double t = z.re();
		double u = z.im();
		double b;
		switch (n) {
			case 1: b = b1(t, u); break;
			case 2: b = b2(t, u); break;
			case 3: b = b3(t, u); break;
			case 4: b = b4(t, u); break;
			case 5: b = b5(t, u); break;
			case 6: b = b6(t, u); break;
			case 7: b = b7(t, u); break;
			case 8: b = b8(t, u); break;
			case 9: b = b9(t, u); break;
			case 10: b = b10(t, u); break;
			case 11: b = b11(t, u); break;
			default: b = 1.0;
		}
		return new Complex(b, 0);
	}

	@Override
	public String getHumanReadableFormula() {
		return "BMarelle(" + n + ")";
	}
}
