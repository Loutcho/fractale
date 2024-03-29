package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class AbsGrid implements Effect {

	private double base;
	private double thickness = 0.1;
	
	public AbsGrid(double base, double thickness) {
		this.base = base;
		this.thickness = thickness;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		return Math.pow(MyMath.sqsindemi(2.0 * Math.PI * Math.log(z.abs()) / Math.log(base)), thickness);
	}
}
