package xt.coloralgo;

import java.util.function.Function;

import xt.coloralgo.effect.Effect;
import xt.coloralgo.stopcriterion.StopCriterion;
import xt.math.Complex;
import xt.math.MyMath;

public class EscapeTimeAlgorithm implements ColorAlgo {

	private Function<Complex, Complex> function;
	private Complex zJulia;
	private int iMax;
	private boolean smoothMode;
	private Color iMaxReachedColor;
	private Effect effect;
	private StopCriterion stopCriterion;
	private ApplyTestOrder order;

	public EscapeTimeAlgorithm(
			Function<Complex, Complex> function,
			Complex zJulia,
			int iMax,
			boolean smoothMode,
			StopCriterion stopCriterion,
			Color iMaxReachedColor,
			ApplyTestOrder order,
			Effect effect) {
		this.function = function;
		this.zJulia = zJulia;
		this.iMax = iMax;
		this.stopCriterion = stopCriterion;
		this.iMaxReachedColor = iMaxReachedColor;
		this.smoothMode = smoothMode;
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
		builder.append(iMax);
		builder.append(", ");
		builder.append(smoothMode);
		builder.append(", ");
		builder.append(stopCriterion);
		builder.append(", ");
		builder.append(iMaxReachedColor);
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
		while (i < iMax) {
			switch (order) {
			case FIRST_APPLY_THEN_TEST:
				z = function.apply(z);
				z = Complex.add(z, c);
				if (stopCriterion.stopsAt(z)) {
					return divergenceColorAlgo(i, iMax, z);
				}
				break;
			case FIRST_TEST_THEN_APPLY:
				if (stopCriterion.stopsAt(z)) {
					return divergenceColorAlgo(i, iMax, z);
				}
				z = function.apply(z);
				z = Complex.add(z, c);
				break;
			}
			i ++;
		}
		return iMaxReachedColor;
	}
	
	public Color divergenceColorAlgo(int iteration, int iterationMax, Complex z) {
		Color color = new Color(0x000000);
		int[] colors = new int[3];
		int iColor;
		
		double iReel = (double) iteration;
		if (smoothMode) {
			iReel += MyMath.smooth(z.abs());
		}

		for (iColor = 0; iColor < 3; iColor ++) {
			colors[iColor] = composanteCouleur(iColor, iReel, z);
		}
		
		try {
			color = new Color(colors[0], colors[1], colors[2]);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("new Color() - ARGL");
		}
		
		return color;
	}
	
	private int composanteCouleur(int iColor, double iReel, Complex z) {
		double x = effect.apply(iColor, z, iReel);
		return (int)(255.0 * x);
	}

	public int getiMax() {
		return iMax;
	}

	public void setiMax(int iMax) {
		this.iMax = iMax;
	}

	public boolean isSmoothMode() {
		return smoothMode;
	}

	public void setSmoothMode(boolean smoothMode) {
		this.smoothMode = smoothMode;
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
