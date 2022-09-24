package xt.coloralgo;

import java.awt.Color;
import java.util.function.Function;

import xt.coloralgo.effect.Effect;
import xt.math.Complex;

public class DomainColoring implements ColorAlgo {

	private Function<Complex, Complex> function;
	private Effect effect;
	
	public DomainColoring(Function<Complex, Complex> function, Effect effect) {
		this.function = function;
		this.effect = effect;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DomainColoring(");
		builder.append(function);
		builder.append(", ");
		builder.append(effect);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public Color getColor(Complex pixel) {
		Complex z = function.apply(pixel);
		Color color = Color.BLACK;
		int[] colors = new int[3];
		for (int iColor = 0; iColor < 3; iColor ++) {
			colors[iColor] = composanteCouleur(iColor, z);
		}
		try {
			color = new Color(colors[0], colors[1], colors[2]);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("new Color() - ARGL");
		}
		
		return color;
	}
	
	private int composanteCouleur(int iColor, Complex z) {
		double x = effect.apply(iColor, z, 0.0);
		return (int)(255.0 * x);
	}
}
