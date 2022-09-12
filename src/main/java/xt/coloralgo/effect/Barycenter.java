package xt.coloralgo.effect;

import xt.coloralgo.Effect;
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
}
