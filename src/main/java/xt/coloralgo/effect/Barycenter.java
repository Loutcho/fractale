package xt.coloralgo.effect;

import xt.math.Complex;

public class Barycenter implements Effect {

	private double ka;
	private Effect a;
	private double kb;
	private Effect b;
	
	public Barycenter(double ka, Effect a, double kb, Effect b) {
		this.ka = ka;
		this.a = a;
		this.kb = kb;
		this.b = b;
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double va = a.apply(iColor, z, iReel);
		double vb = b.apply(iColor, z, iReel);
		return ka * va + kb * vb;
	}

	@Override
	public void multiplyPeriod(double coef) {
		a.multiplyPeriod(coef);
		b.multiplyPeriod(coef);
	}
	
	@Override
	public void incrementPhase(double deltaPhase) {
		a.incrementPhase(deltaPhase);
		b.incrementPhase(deltaPhase);
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		a.multiplyThreshold(coef);
		b.multiplyThreshold(coef);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Barycenter(");
		builder.append(ka);
		builder.append(", ");
		builder.append(a);
		builder.append(", ");
		builder.append(kb);
		builder.append(", ");
		builder.append(b);
		builder.append(")");
		return builder.toString();
	}
}
