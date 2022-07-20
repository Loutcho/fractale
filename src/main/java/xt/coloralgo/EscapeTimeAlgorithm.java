package xt.coloralgo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import xt.function.Function;
import xt.math.Complex;
import xt.math.MyMath;

public class EscapeTimeAlgorithm implements ColorAlgo {

	// private static final double DKPHI = 0.05;
	private static final int DEFAULT_I_MAX = 500;
	// private static final double KGEOM_20R2 = 1.0352649238413775043477881942112;
	
	private Function function;
	private Complex zJulia;
	private int iMax = DEFAULT_I_MAX;
	private boolean smoothMode;
	private Color iMaxReachedColor;
	private Palette palette;
	private Effect effect;
	private double Lmax;

	public EscapeTimeAlgorithm(
			Function function, Complex zJulia, int iMax, boolean smoothMode, double Lmax, 
			Color iMaxReachedColor, Palette palette, Effect effect) {
		this.function = function;
		this.zJulia = zJulia;
		this.iMax = iMax;
		this.Lmax = Lmax;
		this.iMaxReachedColor = iMaxReachedColor;
		this.smoothMode = smoothMode;
		this.palette = palette;
		this.effect = effect;
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
			double L = z.abs();
			if (L > Lmax) {
				return divergenceColorAlgo(i, iMax, z, L);
			}
			i ++;
		}
		return iMaxReachedColor;
	}
	
	public Color divergenceColorAlgo(int iteration, int iterationMax, Complex z, double divergence) {
		Color color = Color.BLACK;
		int[] colors = new int[3];
		int iColor;
		
		double iReel = (double) iteration;
		if (smoothMode) {
			iReel += MyMath.smooth(divergence);			
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
		double x = effect.apply(palette, iColor, z, iReel);
		return (int)(255.0 * x);
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
	
	public void processKeyEvent(int key) {
		switch (key) {
			case KeyEvent.VK_ADD:
				iMax = iMax * 2;
				break;
			case KeyEvent.VK_SUBTRACT:
				iMax = iMax / 2;
				break;
			case KeyEvent.VK_MULTIPLY:
				break;
			case KeyEvent.VK_DIVIDE:
				break;
			/*
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
			*/
			case KeyEvent.VK_Z:
				smoothMode = (! smoothMode);
				break;
			case KeyEvent.VK_W:
				/*
				degrade2_i[0] = (degrade2_i[0] + 0.1) % 1;
				degrade2_i[1] = (degrade2_i[1] + 0.1) % 1;
				degrade2_i[2] = (degrade2_i[2] + 0.1) % 1;
				*/
				break;
			case KeyEvent.VK_X:
				/*
				degrade2_j[0] = (degrade2_j[0] + 0.1) % 1;
				degrade2_j[1] = (degrade2_j[1] + 0.1) % 1;
				degrade2_j[2] = (degrade2_j[2] + 0.1) % 1;
				*/
				break;
			case KeyEvent.VK_J:
				// FIXME: juliaMode = ! juliaMode;
				break;
		}
	}

	@Override
	public String toString() {
		return "EscapeTime{" +
				"julia=" + zJulia +
				", iMax=" + iMax +
				", smoothMode=" + smoothMode +
				", effect=" + effect +
				'}';
	}
}
