package xt.coloralgo.effect;

import xt.math.Complex;
import xt.math.MyMath;

public class FancyGradient003 implements Effect {

	private double threshold;
	
	public FancyGradient003(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		this.threshold *= coef;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = Math.abs(z.re());
		double y = Math.abs(z.im());
		
		double xx = x > threshold ? 0.0 : Math.sqrt(1.0 - MyMath.sq(x / threshold)); 
		double yy = y > threshold ? 0.0 : Math.sqrt(1.0 - MyMath.sq(y / threshold));
		
		return Math.max(xx, yy);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FancyGradient003(");
		builder.append(threshold);
		builder.append(")");
		return builder.toString();
	}
	
	
}
