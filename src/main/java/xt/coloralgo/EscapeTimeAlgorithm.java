package xt.coloralgo;

import java.util.function.Function;
import java.util.function.Predicate;

import xt.coloralgo.effect.Effect;
import xt.math.Complex;
import xt.math.MyMath;

public class EscapeTimeAlgorithm implements ColorAlgo {

	private Function<Complex, Complex> function;
	private Complex zJulia;
	private int iMax;
	private boolean smoothMode;
	private Color iMaxReachedColor;
	private Effect effect;
	private Predicate<Complex> stopCriterion;

	public EscapeTimeAlgorithm(
			Function<Complex, Complex> function, Complex zJulia, int iMax, boolean smoothMode, Predicate<Complex> stopCriterion, 
			Color iMaxReachedColor, Effect effect) {
		this.function = function;
		this.zJulia = zJulia;
		this.iMax = iMax;
		this.stopCriterion = stopCriterion;
		this.iMaxReachedColor = iMaxReachedColor;
		this.smoothMode = smoothMode;
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
			z = function.apply(z);
			z = Complex.add(z, c);
			if (stopCriterion.test(z)) {
				return divergenceColorAlgo(i, iMax, z);
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
	
	/*
	public void incKphi() {
		kphi += DKPHI;
		if (kphi >= 1.0) {
			kphi -= 1.0;
		}
	}
	
	public void decKphi() {
		kphi -= DKPHI;
		if (kphi <= 0.0)
		{
			kphi += 1.0;
		}
	}
	*/

	/*
	@Override
	public void processKeyEvent(int key) {
		switch (key) {
			case KeyEvent.VK_INSERT:
				period *= 2.0;
				break;
			case KeyEvent.VK_DELETE:
				period /= 2.0;
				break;
			case KeyEvent.VK_HOME:
				period *= 2.0;
				break;
			case KeyEvent.VK_END:
				period /= 2.0;
				break;
			case KeyEvent.VK_PAGE_UP:
				period *= 2.0;
				break;
			case KeyEvent.VK_PAGE_DOWN:
				period /= 2.0;
				break;
			case KeyEvent.VK_A:
				period *= KGEOM_20R2;
				break;
			case KeyEvent.VK_Q:
				period /= KGEOM_20R2;
				break;
			case KeyEvent.VK_E:
				incKphi();
				break;
			case KeyEvent.VK_D:
				decKphi();
				break;
			case KeyEvent.VK_W:
				degrade2_i[0] = (degrade2_i[0] + 0.1) % 1;
				degrade2_i[1] = (degrade2_i[1] + 0.1) % 1;
				degrade2_i[2] = (degrade2_i[2] + 0.1) % 1;
				break;
			case KeyEvent.VK_X:
				degrade2_j[0] = (degrade2_j[0] + 0.1) % 1;
				degrade2_j[1] = (degrade2_j[1] + 0.1) % 1;
				degrade2_j[2] = (degrade2_j[2] + 0.1) % 1;
				break;
		}
	}
	*/
}
