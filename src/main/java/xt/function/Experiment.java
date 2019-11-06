package xt.function;

import xt.math.Complex;

public class Experiment implements Function {

	public Experiment()
	{
	}
	
	public Complex apply(Complex z)
	{
		double x = z.re();
		double y = z.im();
		double tt = Math.sqrt(x * x - 2 * x * y + y * y + 8 * x + 8 * y);
		double ll = 2.0 * Math.log(2.0);
		double xx = Math.log(tt - x + y) - ll;
		double yy = Math.log(tt + x - y) - ll;
		return new Complex(xx, yy);
	}

	@Override
	public String getHumanReadableFormula() {
		return "experiment";
	}
}
