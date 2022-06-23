package xt.function;

import java.util.List;

import xt.math.Complex;

public class RationalFraction implements Function {

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
	public String getHumanReadableFormula() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (Complex pole: poles) {
			sb.append(String.format("(z - (%s))", pole.toString()));
		}
		sb.append(") / (");
		for (Complex zero: zeros) {

			sb.append(String.format("(z - (%s))", zero.toString()));
		}
		sb.append(")");
		return sb.toString();
	}
}
