package xt.video;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction3;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;
import xt.math.MyMath;

public class Video008 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Sinus hyperbolique tournant 
	 * 300 images pour une video cyclique
	 */
	public static void main(String[] args) {
		int n = 300;
		for (int i = 0; i < n; i ++) {
			System.out.println("---- " + i + " ----");
			double theta = i * 2.0 * Math.PI / n;
			new ImageFile(
					new Image(
							new DomainColoring(z -> Complex.div(MyMath.sinh(z), Complex.ei(theta)), new ColorFunction3()),
							new MathZone(new Complex(0.0, 0.0), 1.2 * Math.PI, 0.8 * Math.PI, Math.PI / 2.0)
					),
					PATH + String.format("frames\\frame_008_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
