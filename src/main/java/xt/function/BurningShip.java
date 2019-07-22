package xt.function;

import xt.math.Complex;

public class BurningShip implements Function {

	public BurningShip()
	{
	}
	
	public Complex apply(Complex z)
	{
		double x = z.re();
		double y = z.im();
		
		double xx = Math.abs(x); 
		double yy = Math.abs(y);
		Complex zz = new Complex(xx, yy);
		return Complex.mul(zz, zz);
	}
}
