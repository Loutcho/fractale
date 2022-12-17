package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class FancyGradient005 implements Effect {

	private double threshold;
	
	public FancyGradient005(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		this.threshold *= coef;
	}
	
	private static final double A = 15.090;
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double u = (z.abs() / threshold) - 1.0;
		u = A * u;
		if (u > 2.0* Math.PI) {
			return 0.0;
		}
		
		return MyMath.sqsindemi(u);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyGradient005(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
}
