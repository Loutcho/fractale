package xt.outtext.buildingblock;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Util;

public class SegmentHorizontal implements Function<Complex, Double> {

	private double x1;
	private double x2;

	public static SegmentHorizontal hseg(double x1, double x2) {
		return new SegmentHorizontal(x1, x2);
	}
	
	private SegmentHorizontal(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}
	
	public Double apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double qy = Math.abs(y);
		double qx = (Math.abs(x - x1) + Math.abs(x - x2)) / 2.0 - Math.abs(x1 - x2) / 2.0;
		double q = Math.sqrt(qx * qx + qy * qy);
		return Util.nearZero(q);
	}
}
