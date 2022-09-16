package xt.fractale;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPeriodicity;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.coloralgo.stopcriterion.AbsGreaterThan;
import xt.math.Complex;
import xt.graph.Graph;
import xt.sound.Sound;

public class Drawer extends Graph {

	static final long		serialVersionUID	= 1234;
	
	static final int        RESOLUTION_X = 1920;
	static final int        RESOLUTION_Y = 1080;
	static final int        PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 256 */ /* 2 */ 8; /* A adapter */
	static final int        EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 8 */ /* 1 */ 3; /* A adapter */
	static final int        MINIMAL_INTEGER_X = RESOLUTION_X / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final int        MINIMAL_INTEGER_Y = RESOLUTION_Y / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;

	static final int GRANULARITE_LA_PLUS_GROSSIERE = 0;
	static final int GRANULARITE_LA_PLUS_FINE = EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static int granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
	
	public static void main(String[] args) {
		draw(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 3000, true, new AbsGreaterThan(2.0), Color.BLACK,
						new ConstantColor(1.0, 1.0, 1.0)
					),
					new MathZone(new Complex(-0.5, 0.0), 1.1 * 1.920, 1.1 * 1.080, 0)
		);
	}
	
	public static void draw(ColorAlgo colorAlgo, MathZone mathZone) {
		PixelZone pixelZone = new PixelZone(1920, 1080);
		Drawer f = new Drawer();
		f.init();
		MyKeyListener ka = new MyKeyListener(mathZone, colorAlgo);
		f.addKeyListener(ka);
		Graphics graphics = f.getGraphics();
		CoordinatesConverter cc = new CoordinatesConverter(mathZone, pixelZone);
		
		while (ka.getDrawStatus() != DrawStatus.QUIT) {
			switch (ka.getDrawStatus()) {
			case DRAW:
				draw(ka, graphics, cc, colorAlgo);
				if (ka.getDrawStatus() == DrawStatus.DRAW) {
					ka.setDrawStatus(DrawStatus.WAIT);
				}
				break;
			case REDRAW:
				ka.setDrawStatus(DrawStatus.DRAW);
				break;
			case WAIT:
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case QUIT:
				break;
			}
		}

		f.done();
		System.exit(0);
	}

	public static void draw(MyKeyListener ka, Graphics graphics, CoordinatesConverter cc, ColorAlgo colorAlgo) {
		int ix, iy;
		int granu;
		int cote, nx, ny;
		int x, y;
		
		granu = granularite_de_depart;
		while ((granu <= GRANULARITE_LA_PLUS_FINE) && (ka.getDrawStatus() == DrawStatus.DRAW)) {
			cote = 1 << (EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR - granu); // cote du carre
			
			nx = MINIMAL_INTEGER_X * (1 << granu); // nombre de carres de cette taille
			ny = MINIMAL_INTEGER_Y * (1 << granu);

			ix = 0;
			while ((ix < nx) && (ka.getDrawStatus() == DrawStatus.DRAW)) {
				x = ix * cote;
				for (iy = 0; iy < ny; iy++) {
					y = iy * cote;
					Complex z = cc.fromPixelToMath(new Complex(x, y));
					Color color = null;
					color = colorAlgo.getColor(z);
					graphics.setColor(color);
					graphics.fillRect(x, y, cote, cote);
				}

				ix++;
			}

			granu++;
		}

		if (ka.getDrawStatus() == DrawStatus.DRAW) {
			new Sound().sound("toto.wav");
		}
	}

	public static void saveParameters(String outFileName, ColorAlgo colorAlgo, MathZone mathZone) {
		try (
				FileWriter fileWriter = new FileWriter("G:\\Fractales\\" + "Coords.txt", true);
				BufferedWriter bw = new BufferedWriter(fileWriter)
		) {
			bw.write("filename = " + outFileName + ";\n");
			bw.write(colorAlgo.toString());
			bw.write(mathZone.toString());
			bw.newLine();
			bw.flush();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
