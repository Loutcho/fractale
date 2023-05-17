package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class Donut implements Effect {

	private double internalRadius;
	private double externalRadius;
	private double p[];
	private double rc;
	private double rr;
	
	public Donut(double internalRadius, double externalRadius, double p0, double p1, double p2) {
		this.internalRadius = internalRadius;
		this.externalRadius = externalRadius;
		this.rc = (internalRadius + externalRadius) / 2.0;
		this.rr = (externalRadius - internalRadius) / 2.0;
		this.p = new double[3];
		this.p[0] = p0;
		this.p[1] = p1;
		this.p[2] = p2;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {

		double x = z.re();
		double y = z.im();
		double r = Math.pow(Math.pow(Math.abs(x), p[iColor]) + Math.pow(Math.abs(y), p[iColor]), 1.0 / p[iColor]);

		if ((r < internalRadius) || (externalRadius < r)) {
			return 0.0;
		}
		return Math.sqrt(MyMath.sq(rr) - MyMath.sq(r - rc)) / rr;
		
	}

	@Override
	public String toString() {
		return String.format("Donut(%f, %f, %f, %f, %f)", internalRadius, externalRadius, p[0], p[1], p[2]);
	}
}
