package xt.outtext;

import java.util.function.Function;

import xt.math.Complex;

public class Rotate implements Function<Complex, Double> {
	
	private double cos;
	private double sin;
	private Function<Complex, Double> function;

	public Rotate(double angle, Function<Complex, Double> function) {
		cos = Math.cos(angle);
		sin = Math.sin(angle);
		this.function = function;
	}

	@Override
	public Double apply(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx =   x * cos + y * sin;
		double yy = - x * sin + y * cos;
		Complex zz = new Complex(xx, yy);
		return function.apply(zz);
	}
}
