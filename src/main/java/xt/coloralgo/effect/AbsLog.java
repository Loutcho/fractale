package xt.coloralgo.effect;

import xt.math.Complex;

public class AbsLog implements Effect {

	private double k;
	
	public AbsLog(double k) {
		this.k = k;
	}
	
	@Override
	public String toString() {
		return "AbsLog";
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double r = z.abs();
		double l = Math.log(r);
		return Math.tanh(l / k);
	}
}
