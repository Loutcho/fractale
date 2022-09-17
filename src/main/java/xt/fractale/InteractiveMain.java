package xt.fractale;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import xt.coloralgo.ColorAlgo;
import xt.math.Complex;
import xt.graph.Graph;
import xt.sound.Sound;

public class InteractiveMain extends Graph {

	static final long serialVersionUID	= 1234;
	
	static final int RESOLUTION_X = 1536;
	static final int RESOLUTION_Y = 1024;
	static final int PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = 512;
	static final int EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = 9;
	static final int MINIMAL_INTEGER_X = RESOLUTION_X / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final int MINIMAL_INTEGER_Y = RESOLUTION_Y / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;

	static final int GRANULARITE_LA_PLUS_GROSSIERE = 0;
	static final int GRANULARITE_LA_PLUS_FINE = EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static int granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
	
	public static void main(String[] args) {
		draw(Image.IMAGE[0]);
	}
	
	public static void draw(Image image) {
		PixelZone pixelZone = new PixelZone(RESOLUTION_X, RESOLUTION_Y);
		InteractiveMain f = new InteractiveMain();
		f.init();
		MyKeyListener ka = new MyKeyListener(image);
		f.addKeyListener(ka);
		Graphics graphics = f.getGraphics();
		CoordinatesConverter cc = new CoordinatesConverter(image.getMathZone(), pixelZone);
		
		while (ka.getDrawStatus() != DrawStatus.QUIT) {
			switch (ka.getDrawStatus()) {
			case DRAW:
				draw(ka, graphics, cc, image.getColorAlgo());
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

			ix = 1;
			while ((ix < nx) && (ka.getDrawStatus() == DrawStatus.DRAW)) {
				x = ix * cote;
				for (iy = 1; iy < ny; iy++) {
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

	public static void saveParameters(String outFileName, Image image) {
		try (
				FileWriter fileWriter = new FileWriter("G:\\Fractales\\" + "Coords.txt", true);
				BufferedWriter bw = new BufferedWriter(fileWriter)
		) {
			bw.write("filename = " + outFileName + ";\n");
			bw.write(image.toString());
			bw.newLine();
			bw.flush();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
