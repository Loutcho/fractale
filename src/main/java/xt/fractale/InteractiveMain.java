package xt.fractale;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import xt.math.Complex;
import xt.graph.Graph;
import xt.sound.Sound;

public class InteractiveMain extends Graph {

	private static final int NUMERO_IMAGE = 65;
	
	public static void main(String[] args) {
		draw(PredefinedImages.get(NUMERO_IMAGE));
	}
	
	static final long serialVersionUID	= 1234;

	static final int SCREEN_X = 1920;
	static final int SCREEN_Y = 1080;
	static final int DEFINITION_X = 1536;
	static final int DEFINITION_Y = 1024;

	static final int PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = 512;
	static final int EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = 9;
	static final int MINIMAL_INTEGER_X = DEFINITION_X / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final int MINIMAL_INTEGER_Y = DEFINITION_Y / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;

	static final int GRANULARITE_LA_PLUS_GROSSIERE = 0;
	static final int GRANULARITE_LA_PLUS_FINE = EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static int granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
	
	private static String PATH = System.getenv("FRACTALE_HOME");
	
	public static void draw(Image image) {
		PixelZone pixelZone = new PixelZone(DEFINITION_X, DEFINITION_Y);
		InteractiveMain f = new InteractiveMain();
		f.init();
		MyKeyListener ka = new MyKeyListener(image, PATH);
		f.addKeyListener(ka);
		Graphics graphics = f.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, SCREEN_X, SCREEN_Y);
		
		while (ka.getDrawStatus() != DrawStatus.QUIT) {
			switch (ka.getDrawStatus()) {
			case DRAW:
				draw(ka, graphics, image, pixelZone);
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

	private static final int FIRST_LINE = 1036;
	private static final int LINE_INCREMENT = 10;
	private static final int NB_CHARS_PER_LINE = 220;
	private static void writeCaption(Graphics graphics, Image image) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 1024, 1920, 56);
		graphics.setColor(Color.WHITE);
		Font font = new Font("Courier New", Font.PLAIN, 11);
		graphics.setFont(font);
		String string = image.toString();
		int line = FIRST_LINE;
		while (! string.isEmpty()) {
			String toPrint;
			if (string.length() > NB_CHARS_PER_LINE) {
				toPrint = string.substring(0, NB_CHARS_PER_LINE);
				string = string.substring(NB_CHARS_PER_LINE);
			} else {
				toPrint = string;
				string = "";
			}
			graphics.drawString(toPrint, 0, line);
			line += LINE_INCREMENT;
		}
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");
		graphics.drawString(df.format(now), 0, line);
	}
	
	public static void draw(MyKeyListener ka, Graphics graphics, Image image, PixelZone pixelZone) {
		int ix, iy;
		int granu;
		int cote, nx, ny;
		int x, y;

		writeCaption(graphics, image);
		
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
					Complex z = new CoordinatesConverter(image.getMathZone(), pixelZone).fromPixelToMath(new Complex(x, y));
					Color color = null;
					color = image.getColorAlgo().getColor(z);
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
				FileWriter fileWriter = new FileWriter(PATH + "Coords.txt", true);
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
