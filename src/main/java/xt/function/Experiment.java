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
		
		double xx = x; 
		double yy = y;
		Complex zz = new Complex(xx, yy);
		return Complex.mul(zz, zz);
	}
}
