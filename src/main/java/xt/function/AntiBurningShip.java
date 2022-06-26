package xt.function;

import xt.math.Complex;

public class AntiBurningShip implements Function {

	public AntiBurningShip()
	{
	}
	
	public Complex apply(Complex z)
	{
		double x = z.re();
		double y = z.im();
		
		double xx = Math.abs(x); 
		double yy = Math.abs(y);
		Complex zz = new Complex(xx, -yy);
		return Complex.mul(zz, zz);
	}

	@Override
	public String getHumanReadableFormula() {
		return "(|re(z)| - I*|im(z)|)^2";
	}


}
