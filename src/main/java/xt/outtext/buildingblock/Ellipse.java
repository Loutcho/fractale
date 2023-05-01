package xt.outtext.buildingblock;

import java.util.function.Function;

import xt.math.Complex;
import xt.outtext.Util;

public class Ellipse implements Function<Complex, Double> {

	private double a;
	private double b;

	public Ellipse(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Double apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double q = Math.abs((x * x) / (a * a) + (y * y) / (b * b) - 1.0) / 2.0; 
		return Util.nearZero(q);
	}
}
