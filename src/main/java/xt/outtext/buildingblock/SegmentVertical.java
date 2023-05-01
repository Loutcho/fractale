package xt.outtext.buildingblock;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Util;

public class SegmentVertical implements Function<Complex, Double> {

	private double y1;
	private double y2;

	public static Function<Complex, Double> vseg(double y1, double y2) {
		return new SegmentVertical(y1, y2);
	}
	
	private SegmentVertical(double y1, double y2) {
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public Double apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double qx = Math.abs(x);
		double qy = (Math.abs(y - y1) + Math.abs(y - y2)) / 2.0 - Math.abs(y1 - y2) / 2.0;
		double q = Math.sqrt(qx * qx + qy * qy);
		return Util.nearZero(q);
	}
}
