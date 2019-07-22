package xt.coloralgo;

import java.awt.Color;

import xt.math.Complex;

public class AbsBlackAndWhite implements FunctionColorAlgo {

	private double coef;
	private boolean inverse;
	
	public AbsBlackAndWhite(double coef, boolean inverse)
	{
		this.coef = coef;
		this.inverse = inverse;
	}
	
	public Color getColor(Complex z) {

		double r = Complex.abs(z);
		double rgb2 = Math.tanh(coef * r);
		if (inverse) {
			rgb2 = 1.0 - rgb2;
		}
		
		int rgb = (int)(255.0 * rgb2);
		
		return new Color(rgb, rgb, rgb);
	}
	
	public void processKeyEvent(int key)
	{
	}
}
