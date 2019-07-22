package xt.function;

import xt.math.Complex;

public class ZPower implements Function {

	private int n;
	
	public ZPower(int n)
	{
		this.n = n;
	}
	
	@Override
	public Complex apply(Complex z) {
		Complex accu = new Complex(1.0, 0.0);
		for (int i = 0; i < n; i ++)
		{
			accu = Complex.mul(accu, z);
		}
		return accu;
	}

}
