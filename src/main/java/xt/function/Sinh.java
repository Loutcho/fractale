package xt.function;

import xt.math.MyMath;

import java.util.function.Function;

import xt.math.Complex;

public class Sinh implements Function<Complex, Complex> {

	private double theta;
	Complex w;
	
	public Sinh() {
		this.theta = 0.0;
		this.w = Complex.ei(theta);
	}
	
	public Sinh(double theta) { // experimental variant
		this.theta = theta;
		this.w = Complex.ei(theta);
	}
	
	@Override
	public Complex apply(Complex z) {
		if (theta == 0.0) {
			return MyMath.sinh(z);
		} else {
			return Complex.div(MyMath.sinh(Complex.mul(w, z)), w);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sinh");
		return builder.toString();
	}
}
