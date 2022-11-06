package xt.video;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction1;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video007 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Sinus hyperbolique --> Sinus circulaire --> (...) 
	 * 150 images pour une video cyclique
	 */
	public static void main(String[] args) {
		int n = 150;
		for (int i = 0; i < n; i ++) {
			System.out.println("---- " + i + " ----");
			double theta = i * Math.PI / n;
			new ImageFile(
					new Image(
							new DomainColoring(new xt.function.Sinh(theta), new ColorFunction1()),
							new MathZone(new Complex(0.0, 0.0), 1.5 * Math.PI, Math.PI, 0.0)
					),
					PATH + String.format("frames\\frame_07_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
