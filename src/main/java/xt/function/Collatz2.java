package xt.function;

import xt.math.Complex;
import xt.math.MyMath;

public class Collatz2 implements Function {
	
	// Barycentric approach: f(z) = (1 - t(z)) * (z / 2) + t(z) * (3 * z + 1)
	
	private static final Complex ONE = new Complex(1.0, 0.0);
	private static final Complex I = new Complex(0.0, 1.0);
	
	@Override
	public String getHumanReadableFormula() {
		return "Collatz2";
	}
	
	// constraints:
	// f1(z) = 0 whenever z is an integer of the 2n form
	// f1(z) = 1 whenever z is an integer of the 2n+1 form
	private Complex f1(Complex z) {
		z = Complex.mul(Math.PI, z);
		z = Complex.mul(0.5, z);
		z = MyMath.sin(z);
		z = Complex.mul(z, z);
		return z;
	}

	// constraints:
	// f2(z) = 0 whenever z is an integer
	private Complex f2(Complex z) {
		z = Complex.mul(Math.PI, z);
		z = Complex.mul(3.0, z);
		z = MyMath.sin(z);
		z = Complex.mul(z, z);
		return z;
	}

	// constraints:
	// t(z) = 0 whenever z is an integer of the 2n form
	// t(z) = 1 whenever z is an integer of the 2n+1 form
	private Complex t(Complex z) {
		return Complex.add(f1(z), Complex.mul(I, f2(z)));
	}
	
	// z / 2
	private Complex a(Complex z) {
		return Complex.mul(0.5, z);
	}
	
	// 3 * z + 1
	private Complex b(Complex z) {
		return Complex.add(Complex.mul(3.0, z), ONE);
	}
	
	@Override
	public Complex apply(Complex z) {
		Complex t = t(z); 
		Complex s = Complex.sub(ONE, t);
		return Complex.add(Complex.mul(s, a(z)), Complex.mul(t, b(z)));
	}
}
