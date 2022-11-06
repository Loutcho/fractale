package xt.video;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.Barycenter;
import xt.coloralgo.effect.ColorFunction1;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video006 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Délire hallucinatoire : changement de fonction de coloriage par transition barycentrique
	 * 101 images pour une video non cyclique 
	 */
	public static void main(String[] args) {
		int n = 100;
		for (int i = 0; i <= n; i ++) {
			double t = (double) i / (double) n;
			double s = 1.0 - t;
			new ImageFile(
					new Image(
						new DomainColoring(new xt.function.F2(),
								new Barycenter(
										s, new Pow(0.5,
											new Mul(
													new ArgPalette(Palette.PALETTE_010, 0.5, 0.0),
													new Max(
															new GridRe(0.05, 1.0, 1.0, 1.0),
															new GridIm(0.05, 1.0, 1.0, 1.0)
													)
											)
										),
										t, new ColorFunction1()
								)
						),
						new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
					),
					PATH + String.format("frames\\frame_006_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
