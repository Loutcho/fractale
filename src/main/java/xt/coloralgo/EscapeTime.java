package xt.coloralgo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import xt.math.MyMath;
import xt.math.Complex;
import xt.function.Function;

public class EscapeTime implements FractalColorAlgo {

	private static final double DKPHI = 0.05;
	private static final int DEFAULT_I_MAX = 100;
	private static final double KGEOM_20R2 = 1.0352649238413775043477881942112;
	
	private Function function;
	private boolean juliaMode;
	private double juliaX = 0.0;
	private double juliaY = 0.0;
	private int iMax = DEFAULT_I_MAX;
	private double iRef = iMax;
	private boolean smoothMode;

	private double degrade1_i[]   = { 1.0, 1.0, 1.0 };
	private double degrade2_i[]   = { 0.0, 0.0, 0.0 };
	private double degrade2_j[]   = { 0.1, 0.1, 0.1 };
	private double bulle[]        = { 0.2, 0.3, 0.4 };
	private double inverse_i[]    = { 0.0, 0.0, 0.0 };
	private double periode[]      = { 33.0, 33.0, 33.0 };
	private double kphi[]         = { 0.0, 0.0, 0.0 };

	private static int[] RVB = {
		/*
		0x0D8C7E, // bleu canard
		0x000000,
		0x5F351D, // chocolat
		0xFFFFFF,
		0xC8AD7F, // beige
		0xFFFFFF,
		*/
		0x76AFF6, 0x76AFF6, 0x000000,
		0xC4DE11, 0xC4DE11, 0xFFFFFF,
		0xC0AA98, 0xC0AA98, 0xFFFFFF,
		0xF43A49, 0xF43A49, 0x000000,
	};

	public EscapeTime(Function function, boolean juliaMode, double juliaX, double juliaY, int iMax, double iRef, boolean smoothMode)
	{
		this.function = function;
		this.juliaMode = juliaMode;
		this.juliaX = juliaX;
		this.juliaY = juliaY;
		this.iMax = iMax;
		this.iRef = iRef;
		this.smoothMode = smoothMode;
	}
	
	
	
	public double getJuliaX() {
		return juliaX;
	}



	public void setJuliaX(double juliaX) {
		this.juliaX = juliaX;
	}



	public double getJuliaY() {
		return juliaY;
	}



	public void setJuliaY(double juliaY) {
		this.juliaY = juliaY;
	}



	public Color getColor(Complex pixel)
	{
		double L = 1.0;
		int i = 0;

		// Mandelbrot : z = 0, c = pixel (un seul ensemble de Mandelbrot existe)
		// Julia : z = pixel, c = parametre (toute une famille d'ensembles de
		// Julia existe)
		
		Complex z;
		Complex c;
		
		if (juliaMode == false)
		{
			// Mandelbrot :
			z = new Complex(0, 0);
			c = pixel;
		}
		else
		{
			// Julia :
			z = pixel;
			c = new Complex(juliaX, juliaY);
		}
		
		while (i < iMax)
		{
			z = function.apply(z);
			z = Complex.add(z, c);
			L = Complex.abs(z);
			
			if (L > 2.0)
			{
				return divergenceColorAlgo(i, iMax, z.re(), z.im(), L);
			}

			i ++;
		}
		return Color.WHITE;
	}
	
	public Color divergenceColorAlgo(int iteration, int iterationMax, double X,
			double Y, double divergence)
	{
		Color color = Color.BLACK;
		int[] colors = new int[3];
		int iColor;
		
		double iReel;
		if (smoothMode)
		{
			iReel = ((double)iteration) + MyMath.smooth(divergence);			
		}
		else
		{
			iReel = (double)iteration;
		}
		double iRate = iReel / iRef;

		if ((iRate > 1.0) || (iRate < 0.0))
			return color;

		double modifiedDivergence = MyMath.ff((divergence - 2.0) / 2.0);

		for (iColor = 0; iColor < 3; iColor++)
		{
			colors[iColor] = composanteCouleur(iColor, iReel, iRate, modifiedDivergence, X, Y);
		}
		
		try
		{
			color = new Color(colors[0], colors[1], colors[2]);
		}
		catch (java.lang.IllegalArgumentException e)
		{
			System.out.println("new Color() - ARGL");
		}
		
		return color;
	}
	
	private int composanteCouleur(
			int iColor, double iReel, double iRate,
			double modifiedDivergence, double X, double Y)
	{
		double x = 1.0;

		if (degrade1_i[iColor] != 0.0)
		{
			x *= 0.2 + 0.8 * Math.pow(1.0 - iRate, 15.0);
		}

		if (degrade2_i[iColor] != 0.0)
		{
			x *= (1.0 - degrade2_i[iColor]) + degrade2_i[iColor] * modifiedDivergence;
		}

		if (degrade2_j[iColor] != 0.0)
		{
			x *= (1.0 - degrade2_j[iColor]) + degrade2_j[iColor] * MyMath.sqcosdemi(Math.atan2(Y, X));
		}

		if (periode[iColor] != 0.0)
		{
			//x *= sqcosdemi(2.0 * Math.PI * iReel / periode[iColor] + kphi[iColor] * 2.0 * Math.PI);
			x *= fonction_1periodique_amplitude1(iColor, iReel / periode[iColor] + kphi[iColor]);
		}

		if (bulle[iColor] != 0.0)
		{
			x *=
				(1.0 - bulle[iColor]) * 1.0
				+
				(bulle[iColor]) * modifiedDivergence * MyMath.sqcosdemi(Math.atan2(Y, X));
		}
		
		if (inverse_i[iColor] == 1.0)
		{
			x = 1.0 - x;
		}

		return (int)(255.0 * x);
	}
	
	public static double fonction_1periodique_amplitude1(int iColor, double x)
	{
		int N = RVB.length;

		int e = (int)x;
		x -= e;
		int i = (int)(N * x);
		int j = (i + 1) % N;
		double coef = N * x - i;
		
		int mask;
		switch (iColor)
		{
		case 0: mask = 0xFF0000; break;
		case 1: mask = 0x00FF00; break;
		case 2: mask = 0x0000FF; break;
		default: mask = 0xFFFFFF;
		}
		int vali = (RVB[i] & mask) >> (8 * (2 - iColor));
		double alpha = ((double)vali) / 255.0;
		int valj = (RVB[j] & mask) >> (8 * (2 - iColor));
		double beta = ((double)valj) / 255.0;
		
		return (1.0 - coef) * alpha + coef * beta;
	}
	
	public void incKphi(int iColor)
	{
		kphi[iColor] += DKPHI;
		if (kphi[iColor] >= 1.0)
		{
			kphi[iColor] -= 1.0;
		}
	}
	
	public void decKphi(int iColor)
	{
		kphi[iColor] -= DKPHI;
		if (kphi[iColor] <= 0.0)
		{
			kphi[iColor] += 1.0;
		}
	}
	
	public void processKeyEvent(int key)
	{
		switch (key)
		{
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
			case KeyEvent.VK_INSERT:
				periode[0] *= 2.0;
				break;
			case KeyEvent.VK_DELETE:
				periode[0] /= 2.0;
				break;
			case KeyEvent.VK_HOME:
				periode[1] *= 2.0;
				break;
			case KeyEvent.VK_END:
				periode[1] /= 2.0;
				break;
			case KeyEvent.VK_PAGE_UP:
				periode[2] *= 2.0;
				break;
			case KeyEvent.VK_PAGE_DOWN:
				periode[2] /= 2.0;
				break;
			case KeyEvent.VK_A:
				periode[0] *= KGEOM_20R2;
				periode[1] *= KGEOM_20R2;
				periode[2] *= KGEOM_20R2;
				break;
			case KeyEvent.VK_Q:
				periode[0] /= KGEOM_20R2;
				periode[1] /= KGEOM_20R2;
				periode[2] /= KGEOM_20R2;
				break;
			case KeyEvent.VK_E:
				incKphi(0);
				incKphi(1);
				incKphi(2);
				break;
			case KeyEvent.VK_D:
				decKphi(0);
				decKphi(1);
				decKphi(2);
				break;
			case KeyEvent.VK_Z:
				smoothMode = (! smoothMode);
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
			case KeyEvent.VK_J:
				juliaMode = ! juliaMode;
				break;
		}

	}
}
