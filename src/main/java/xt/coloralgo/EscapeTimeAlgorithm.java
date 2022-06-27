package xt.coloralgo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import xt.math.MyMath;
import xt.math.Complex;
import xt.function.Function;

public class EscapeTimeAlgorithm implements FractalColorAlgo {

	// private static final double DKPHI = 0.05;
	private static final int DEFAULT_I_MAX = 500;
	// private static final double KGEOM_20R2 = 1.0352649238413775043477881942112;
	
	private Function function;
	private Complex zJulia;
	private int iMax = DEFAULT_I_MAX;
	private double iRef = iMax;
	private boolean smoothMode;
	private Palette palette;

	private Periodicity periodicity;
	private GradientWithIteration gIteration;
	private GradientWithModulus gModulus;
	private GradientWithArgument gArgument;
	private BubbleEffect bubbleEffect;
	private PowerEffect powerEffect;

	public EscapeTimeAlgorithm(Function function, Complex zJulia, int iMax, double iRef, boolean smoothMode, Palette palette, Periodicity periodicity,
			GradientWithIteration gIteration, GradientWithModulus gModulus, GradientWithArgument gArgument, BubbleEffect bubbleEffect, PowerEffect powerEffect) {
		this.function = function;
		this.zJulia = zJulia;
		this.iMax = iMax;
		this.iRef = iRef;
		this.smoothMode = smoothMode;
		this.palette = palette;
		this.periodicity = periodicity;
		this.gIteration = gIteration;
		this.gModulus = gModulus;
		this.gArgument = gArgument;
		this.bubbleEffect = bubbleEffect;
		this.powerEffect = powerEffect;
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
			double L = Complex.abs(z);
			if (L > 2.0) {
				return divergenceColorAlgo(i, iMax, z, L);
			}
			i ++;
		}
		return Color.WHITE;
	}
	
	public Color divergenceColorAlgo(int iteration, int iterationMax, Complex z, double divergence) {
		Color color = Color.BLACK;
		int[] colors = new int[3];
		int iColor;
		
		double iReel = (double) iteration;
		if (smoothMode) {
			iReel += MyMath.smooth(divergence);			
		}
		double iRate = iReel / iRef;

		if ((iRate > 1.0) || (iRate < 0.0))
			return color;

		double modifiedDivergence = MyMath.ff((divergence - 2.0) / 2.0);

		for (iColor = 0; iColor < 3; iColor ++) {
			colors[iColor] = composanteCouleur(iColor, iteration, iReel, iRate, modifiedDivergence, z);
		}
		
		try {
			color = new Color(colors[0], colors[1], colors[2]);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println("new Color() - ARGL");
		}
		
		return color;
	}
	
	private int composanteCouleur(int iColor, int iEntier, double iReel, double iRate, double modifiedDivergence, Complex z) {
		double theta = Complex.arg(z);
		double x = 1.0;

		if (periodicity.isActivated()) 	{
			x *= fonction_1periodique_amplitude1(iColor, iReel / periodicity.getPeriod(iColor) + periodicity.getPhase(iColor));
		}
		
		if (gIteration.isActivated()) {
			double tau = gIteration.getTau();
			double iBase = gIteration.getiBase(); 
			if (iReel < iBase) {
				System.err.println("ARGL: (iBase = " + iBase + ") > (iReel = " + iReel + ")");
			} else {
				x *= Math.exp(- tau * (iReel - iBase));
			}
		}

		if (gModulus.isActivated()) {
			x *= 1.0 - gModulus.getAttenuation(iColor) * (1.0 - modifiedDivergence);
		}

		if (gArgument.isActivated()) {
			x *= 1.0 - gArgument.getAttenuation(iColor)	* MyMath.sqcosdemi(theta);
		}

		if (bubbleEffect.isActivated() && periodicity.isActivated()) {
			x *= Math.max(
					MyMath.sqcosdemi(theta),
					MyMath.sqcosdemi(Math.PI * (iReel / periodicity.getPeriod(iColor) + periodicity.getPhase(iColor))));
		}
		
		if (powerEffect.isActivated()) {
			x = Math.pow(x, powerEffect.getPower()); // to alter luminosity. 0.0 (everything becomes white) ... 1.0 (nothing changes) ... +oo (everything becomes darker)
		}
		
		return (int)(255.0 * x);
	}
	
	public double fonction_1periodique_amplitude1(int iColor, double x) {
		int n = palette.getNbColors();
		int e = (int)x;
		x -= e;
		int i = (int)(n * x);
		int j = (i + 1) % n;
		double coef = n * x - i;
		int mask;
		switch (iColor)
		{
		case 0: mask = 0xFF0000; break;
		case 1: mask = 0x00FF00; break;
		case 2: mask = 0x0000FF; break;
		default: mask = 0xFFFFFF;
		}
		int vali = (palette.getColor(i) & mask) >> (8 * (2 - iColor));
		double alpha = ((double)vali) / 255.0;
		int valj = (palette.getColor(j) & mask) >> (8 * (2 - iColor));
		double beta = ((double)valj) / 255.0;
		return (1.0 - coef) * alpha + coef * beta;
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
				iRef = iMax;
				break;
			case KeyEvent.VK_SUBTRACT:
				iMax = iMax / 2;
				iRef = iMax;
				break;
			case KeyEvent.VK_MULTIPLY:
				iRef = iRef * 2;
				break;
			case KeyEvent.VK_DIVIDE:
				iRef = iRef / 2;
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
				", iRef=" + iRef +
				", smoothMode=" + smoothMode +
				", degrade1_i=" + gIteration +
				", degrade2_i=" + gModulus +
				", gArgument= " + gArgument +
				", gBubble=" + bubbleEffect +
				", periodicity=" + periodicity +
				'}';
	}

	@Override
	public void setJulia(Complex julia) {
		this.zJulia = julia;
	}
}
