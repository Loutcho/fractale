package xt.function;

import java.util.List;
import java.util.function.Function;

import xt.math.Complex;

public class RationalFraction implements Function<Complex, Complex> {

	private List<Complex> zeros;
	private List<Complex> poles;

	public RationalFraction(List<Complex> zeros, List<Complex> poles) {
		this.zeros = zeros;
		this.poles = poles;
	}
	
	@Override
	public Complex apply(Complex z) {
		Complex accu = new Complex(1.0, 0);
		for (Complex zero: zeros) {
			accu = Complex.mul(accu, Complex.sub(z, zero));
		}
		for (Complex pole: poles) {
			accu = Complex.div(accu, Complex.sub(z, pole));
		}
		return accu;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RationalFraction(");
		builder.append(zeros);
		builder.append("/");
		builder.append(poles);
		builder.append(")");
		return builder.toString();
	}
}
