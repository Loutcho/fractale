package xt.function;

import java.util.List;

import xt.math.Complex;

public class Rational implements Function {

	private List<Complex> zeros;
	private List<Complex> poles;

	public Rational(List<Complex> zeros, List<Complex> poles) {
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

	public List<Complex> getZeros() {
		return zeros;
	}

	public void setZeros(List<Complex> zeros) {
		this.zeros = zeros;
	}

	public List<Complex> getPoles() {
		return poles;
	}

	public void setPoles(List<Complex> poles) {
		this.poles = poles;
	}
}
