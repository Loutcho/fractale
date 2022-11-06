package xt.video;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.Color;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.stopcriterion.AbsGreaterThan;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;
import xt.math.MyMath;

public class Video005 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Composition florale en mouvement
	 * 600 images pour une video cyclique
	 */
	public static void main(String[] args) {
		int n = 600;
		for (int i = 0; i < n; i ++) {
			// Le paramètre c de Julia décrit une lemniscate de Bernoulli
			double theta = i * 2.0 * Math.PI / n;
			double k = Math.sqrt(2.0) * Math.sin(theta) / (1.0 + MyMath.sq(Math.cos(theta)));
			double dx = 1.0 * k;
			double dy = dx * Math.cos(theta);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Fleur(), new Complex(0.0 + dx, 0.0 + dy), 7, false, new AbsGreaterThan(2E11), Color.BLACK, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new IterationPalette(Palette.PALETTE_018, 3.0)
						),
						new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0)),
					PATH + String.format("frames\\frame_005_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			
		}
	}
}
