package xt.coloralgo;

import java.util.function.Function;

import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.effect.Effect;
import xt.math.Complex;

public class EscapeTimeAlgorithm implements ColorAlgo {

	private Function<Complex, Complex> function;
	private Complex zJulia;
	private Effect effect;
	private BooleanExpression stopCriterion;
	private ApplyTestOrder order;

	public EscapeTimeAlgorithm(
			Function<Complex, Complex> function,
			Complex zJulia,
			BooleanExpression stopCriterion,
			Effect effect,
			ApplyTestOrder order
			) {
		this.function = function;
		this.zJulia = zJulia;
		this.stopCriterion = stopCriterion;
		this.order = order;
		this.effect = effect;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EscapeTimeAlgorithm(");
		builder.append(function);
		builder.append(", ");
		builder.append(zJulia);
		builder.append(", ");
		builder.append(stopCriterion);
		builder.append(", ");
		builder.append(order);
		builder.append(", ");
		builder.append(effect);
		builder.append(")");
		return builder.toString();
	}
	
	public Color getColor(Complex pixel) {
		// Mandelbrot : z = 0    , c = pixel     (un seul ensemble de Mandelbrot existe)
		// Julia      : z = pixel, c = parametre (toute une famille d'ensembles de Julia existe)
		
		Complex z, c;
		if (zJulia == null) { // Mandelbrot:
			z = new Complex(0, 0);
			c = pixel;
		} else { // Julia:
			z = pixel;
			c = zJulia;
		}
		
		int i = 0;
		boolean stop = false;

		switch (order) {
		case FIRST_APPLY_THEN_TEST:
			while (! stop) {
				z = Complex.add(function.apply(z), c);
				stop = (stopCriterion.evaluate(i, z));
				if (! stop) {
					i ++;
				}
			}
			break;
		case FIRST_TEST_THEN_APPLY:
			while (! stop) {
				stop = stopCriterion.evaluate(i, z);
				if (! stop) {
					z = Complex.add(function.apply(z), c);
					i ++;
				}
			}
			break;
		}

		return colorAlgo(i, z);
	}
	
	public Color colorAlgo(int iteration, Complex z) {
		Color color = new Color(0x000000);
		int[] colors = new int[3];
		int iColor;
		
		for (iColor = 0; iColor < 3; iColor ++) {
			colors[iColor] = composanteCouleur(iColor, iteration, z);
		}
		
		try {
			color = new Color(colors[0], colors[1], colors[2]);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("new Color() - ARGL: " + colors[0] + "," + colors[1] + "," + colors[2]);
		}
		
		return color;
	}
	
	private int composanteCouleur(int iColor, int i, Complex z) {
		double x = effect.apply(iColor, z, i);
		return (int)(255.0 * x);
	}

	public Complex getzJulia() {
		return zJulia;
	}

	public void setzJulia(Complex zJulia) {
		this.zJulia = zJulia;
	}

	@Override
	public void multiplyPeriod(double coef) {
		effect.multiplyPeriod(coef);
	}

	@Override
	public void incrementPhase(double deltaPhase) {
		effect.incrementPhase(deltaPhase);
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		stopCriterion.multiplyThreshold(coef);
		effect.multiplyThreshold(coef);
	}
}
