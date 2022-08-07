package xt.function;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;
import xt.math.MyMath;

public class Fleur implements Function {
	
	private RationalFraction r;
	
	public Fleur()
	{
		List<Complex> z = new ArrayList<>();
		List<Complex> p  = new ArrayList<>();

		p.add(new Complex(0.0, 0.0));
		p.add(new Complex(0.0, 0.0));
		p.add(new Complex(0.0, 0.0));
		
		r = new RationalFraction(z, p);
	}
	
	public Complex apply(Complex z)
	{
		return Complex.mul(MyMath.cos(z), r.apply(z));
	}

	@Override
	public String getHumanReadableFormula() {
		return "";
	}
}
