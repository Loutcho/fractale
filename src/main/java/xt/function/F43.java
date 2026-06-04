package xt.function;

import static xt.math.Complex.add;
import static xt.math.Complex.mul;
import static xt.math.Complex.sub;

import java.util.function.Function;

import xt.math.Complex;

public class F43 implements Function<Complex, Complex> {

	private static final Complex DEMI = new Complex(0.5, 0.0);
	private static final Complex ROTM = Complex.ei(0.0);
	private static final Complex ROTP = Complex.ei(Math.PI / 4.0);
	
	private Complex f(Complex z) {
		Complex zz;
		
		zz = add(z, DEMI);
		if (zz.abs() <= 0.5)
		{
			return mul(2.0, mul(ROTM, add(z, DEMI)));			
		}
		
		zz = sub(z, DEMI);
		
		if (zz.abs() <= 0.5)
		{
			return mul(2.0, mul(ROTP, sub(z, DEMI)));			
		}
		
		return z.inv();
	}
	
	public Complex apply(Complex z) {
		return f(z);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("F43(");
		builder.append(")");
		return builder.toString();
	}
}
