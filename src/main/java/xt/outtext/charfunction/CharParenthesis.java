package xt.outtext.charfunction;

import java.util.function.Function;

import xt.math.Complex;
import xt.math.MyMath;
import xt.outtext.Util;

public class CharParenthesis implements Function<Complex, Double> {

	Function<Complex, Double> s;
	
	public CharParenthesis(double epsilon) {
		s = z -> {
			double x = z.re();
			double y = z.im();
			return MyMath.sq(Math.abs(y * y + epsilon * 2 * x - 1) + (Math.abs(y - 1.0) + Math.abs(y + 1.0)) / 2.0 - 1.0);
		};
	}
	
	@Override
	public Double apply(Complex z) {
		double q = s.apply(z);
		return Util.nearZero(q);
	}
}
