package xt.fractale;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import xt.coloralgo.*;
import xt.function.*;
import xt.math.Complex;
import xt.graph.Graph;
import xt.sound.Sound;

public class Drawer extends Graph {

	static final long		serialVersionUID	= 1234;
	
	static final double     DEFAULT_X_CENTER    =  0.0;
	static final double     DEFAULT_Y_CENTER    =  0.0;
	static final int        RESOLUTION_X = /* 1280 */ /* 1366 */ 1920; /* A adapter */
	static final int        RESOLUTION_Y = /* 1024 */ /* 768 */ 1080; /* A adapter */
	static final int        PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 256 */ /* 2 */ 8; /* A adapter */
	static final int        EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 8 */ /* 1 */ 3; /* A adapter */
	static final int        MINIMAL_INTEGER_X = RESOLUTION_X / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final int        MINIMAL_INTEGER_Y = RESOLUTION_Y / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final double     DEFAULT_X_LENGTH    =  2.5 * ((double) MINIMAL_INTEGER_X) / ((double) MINIMAL_INTEGER_Y);
	static final double     DEFAULT_Y_LENGTH    =  2.5;

	static final double		DEFAULT_X_MIN		= DEFAULT_X_CENTER - DEFAULT_X_LENGTH / 2.0;
	static final double		DEFAULT_X_MAX		= DEFAULT_X_CENTER + DEFAULT_X_LENGTH / 2.0;
	static final double		DEFAULT_Y_MIN		= DEFAULT_Y_CENTER - DEFAULT_Y_LENGTH / 2.0;
	static final double		DEFAULT_Y_MAX		= DEFAULT_Y_CENTER + DEFAULT_Y_LENGTH / 2.0;

	static double			save_X_MIN			= DEFAULT_X_MIN;
	static double			save_X_MAX			= DEFAULT_X_MAX;
	static double			save_Y_MIN			= DEFAULT_Y_MIN;
	static double			save_Y_MAX			= DEFAULT_Y_MAX;
	
	static final int		STATUS_WAIT			= 0;
	static final int		STATUS_DRAW			= 1;
	static final int		STATUS_REDRAW		= 2;
	static final int		STATUS_QUIT			= 9;
	static int				status				= STATUS_DRAW;
	
	static final int GRANULARITE_LA_PLUS_GROSSIERE = 0;
	static final int GRANULARITE_LA_PLUS_FINE = EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static int granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
	
	static MathZone zone = null;
	static MathZone saveZone = null;

	enum DrawingMode {
		FUNCTION,
		FRACTAL,
		FRACTAL_JULIA,
	};
	
	static DrawingMode drawingMode;
	
	/*
	public static void hexagonalTiling(double xMin, double yMin, double xMax, double yMax) {
		zone = new MathZone(xMin, yMin, xMax, yMax);
		Drawer f = new Drawer();
		f.init();
		f.addKeyListener(new MyKeyListener2());
		Graphics graphics = f.getGraphics();
		while (status != STATUS_QUIT) {
			switch (status) {
				case STATUS_DRAW:
					draw1(graphics, f.getRectangle());
					if (status == STATUS_DRAW) {
						status = STATUS_WAIT;
					}
					break;
				case STATUS_REDRAW:
					status = STATUS_DRAW;
					break;
				case STATUS_WAIT:
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
			}
		}

		f.done();
		System.exit(0);
	}
	*/
	
	/*
	public static void draw1(Graphics graphics, Rectangle rectangle) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, rectangle.width, rectangle.height);
		graphics.setColor(Color.WHITE);
		double[] hexX = new double[7];
		double[] hexY = new double[7];
		double[] newhexX = new double[7];
		double[] newhexY = new double[7];
		double[] genT = new double[2];
		double[] genS = new double[2];
		double[] trans = new double[2];
		int k, l, kmax, lmax;
		
		double s3 = Math.sqrt(3.0);
		hexX[0] = +1.5;
		hexX[1] =  0.0;
		hexX[2] = -1.5;
		hexX[3] = -1.5;
		hexX[4] =  0.0;
		hexX[5] = +1.5;
		hexX[6] = +1.5;
		hexY[0] = s3 * +0.5;
		hexY[1] = s3 * +1.0;
		hexY[2] = s3 * +0.5;
		hexY[3] = s3 * -0.5;
		hexY[4] = s3 * -1.0;
		hexY[5] = s3 * -0.5;
		hexY[6] = s3 * +0.5;
		genT[0] = 3.0;
		genT[1] = 0.0;
		genS[0] = 1.5;
		genS[1] = s3 * 1.5;
		kmax = 5;
		lmax = 5;
		k = -kmax;
		
		while ((k < kmax) && (status != STATUS_QUIT)) {
			l = -lmax;
			while ((l < lmax) && (status != STATUS_QUIT)) {
				trans[0] = k * genT[0] + l * genS[0];
				trans[1] = k * genT[1] + l * genS[1];
				for (int i = 0; i <= 6; i ++) {
					newhexX[i] = hexX[i] + trans[0];
					newhexY[i] = hexY[i] + trans[1];
				}
				int[] x = new int[7];
				int[] y = new int[7];
				for (int i = 0; i <= 6; i ++) {
					x[i] = zone.fromX(newhexX[i], rectangle);
					y[i] = zone.fromY(newhexY[i], rectangle);
				}
				graphics.setColor(Color.GREEN);
				graphics.drawPolyline(x, y, 7);
				l ++;
			}
			k ++;
		}
	}
	*/

	public static void function(double xMin, double yMin, double xMax, double yMax, Function function, ColorAlgo colorAlgo) {
		zone = new MathZone(new Complex(xMin + xMax, yMin + yMax), 1.0, 1.0, 0.0); //FIXME
		drawingMode = DrawingMode.FUNCTION;
		Drawer f = new Drawer();
		f.init();
		f.addKeyListener(new MyKeyListener(function, colorAlgo));
		Graphics graphics = f.getGraphics();

		while (status != STATUS_QUIT) {
			switch (status) {
				case STATUS_DRAW:
					draw(graphics, f.getRectangle(), function, colorAlgo);
					if (status == STATUS_DRAW) {
						status = STATUS_WAIT;
					}
					break;
				case STATUS_REDRAW:
					status = STATUS_DRAW;
					break;
				case STATUS_WAIT:
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
			}
		}

		f.done();
		System.exit(0);
	}

	public static void fractal(double xMin, double yMin, double xMax, double yMax, Function function, FractalColorAlgo colorAlgo) {
		zone = new MathZone(new Complex(xMin + xMax, yMin + yMax), 1.0, 1.0, 0.0); //FIXME
		drawingMode = DrawingMode.FRACTAL;
		Drawer f = new Drawer();
		f.init();
		f.addKeyListener(new MyKeyListener(function, colorAlgo));
		Graphics graphics = f.getGraphics();
		
		while (status != STATUS_QUIT) {
			switch (status) {
			case STATUS_DRAW:
				draw(graphics, f.getRectangle(), function, colorAlgo);
				if (status == STATUS_DRAW) {
					status = STATUS_WAIT;
				}
				break;
			case STATUS_REDRAW:
				status = STATUS_DRAW;
				break;
			case STATUS_WAIT:
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}

		f.done();
		System.exit(0);
	}

	public static void draw(Graphics graphics, Rectangle rectangle, Function function, ColorAlgo colorAlgo) {
		int ix, iy;
		int granu;
		int cote, nx, ny;
		int x, y;
		
		granu = granularite_de_depart;
		while ((granu <= GRANULARITE_LA_PLUS_FINE) && (status == STATUS_DRAW)) {
			cote = 1 << (EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR - granu); // cote du carre
			
			nx = MINIMAL_INTEGER_X * (1 << granu); // nombre de carres de cette taille
			ny = MINIMAL_INTEGER_Y * (1 << granu);

			ix = 0;
			while ((ix < nx) && (status == STATUS_DRAW)) {
				x = ix * cote;
				graphics.setColor(Color.BLACK);
				graphics.fillRect(x, 0, cote, rectangle.height);
				for (iy = 0; iy < ny; iy++) {
					y = iy * cote;
					Complex z = new Complex(0.0, 0.0); // new Complex(zone.toX(x, rectangle), zone.toY(y, rectangle)); //FIXME
					Color color = null;
					switch (drawingMode) {
					case FRACTAL:
					case FRACTAL_JULIA:
						color = colorAlgo.getColor(z);
						break;
					case FUNCTION:
						z = function.apply(z);
						color = colorAlgo.getColor(z);
						break;
					}
					graphics.setColor(color);
					graphics.fillRect(x, y, cote, cote);
				}

				ix++;
			}

			granu++;
		}

		if (status == STATUS_DRAW) {
			new Sound().sound("toto.wav");
		}
	}

	public static void saveParameters(String outFileName, Function function, ColorAlgo colorAlgo) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("G:\\Fractales\\" + "Coords.txt", true));
			bw.write("filename = " + outFileName + ";\n");
			bw.write(function.getHumanReadableFormula());
			bw.write(colorAlgo != null ? colorAlgo.toString() : "");
			//bw.write(functionColorAlgo.toString());
			/*
			bw.write("X_MIN = " + X_MIN + ";\n");
			bw.write("X_MAX = " + X_MAX + ";\n");
			bw.write("Y_MIN = " + Y_MIN + ";\n");
			bw.write("Y_MAX = " + Y_MAX + ";\n");
			bw.write("I_REF = I_MAX = " + I_MAX + ";\n");
			bw.write("juliaMode = " + juliaMode + ";\n");
			if (juliaMode)
			{
				bw.write("JULIA_X = " + JULIA_X + ";\n");
				bw.write("JULIA_Y = " + JULIA_Y + ";\n");
				bw.write("save_X_MIN = " + save_X_MIN + ";\n");
				bw.write("save_X_MAX = " + save_X_MAX + ";\n");
				bw.write("save_Y_MIN = " + save_Y_MIN + ";\n");
				bw.write("save_Y_MAX = " + save_Y_MAX + ";\n");
			}
			int i;
			for (i = 0; i < 3; i ++)
			{
				bw.write("periode[" + i + "] = " + periode[i] + "; ");
				bw.write("kphi[" + i + "] = " + kphi[i] + ";\n");
			}
			bw.write("// ------------------\n");
			*/
			bw.newLine();
			bw.flush();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally { // always close the file
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe2) {
					// just ignore it
				}
			}
		} // end try/catch/finally
	}
}
