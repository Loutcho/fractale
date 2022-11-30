package xt.coloralgo.effect;

import xt.math.Complex;

/*
 * Niveaux de gris.
 * Coloration adaptée aux fonctions
 * prenant une valeur réelle entre 0 et +oo
 * 0 => noir
 * +oo => blanc
 */
public class RealGrayColorFunction implements Effect {

	private double coef;
	
	private static final double K = Math.PI / 2.0;

	public RealGrayColorFunction(double coef) {
		this.coef = coef;
	}
	
	@Override
	public double apply(int iColor, Complex z, int i) {
		double x = z.re(); 
		return Math.atan(coef * x) / K;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ColorFunction4()");
		return builder.toString();
	}
}
