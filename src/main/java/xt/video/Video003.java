package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video003 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Vaisseau alien, zoom jusqu'à plus petit vaisseau alien
	 * 100 images pour une video imparfaitement-cyclique
	 */
	public static void main(String[] args) {
		final double K = 5.628559053;
		int n = 100;
		for (int i = 0; i < n; i ++) {
			double t = (double) i / (double) n;
			System.out.println("----- " + i);
			double c = Math.exp(- K * t);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498),
							OR(
									new IGreaterThan(5000),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(5000),
									new ConstantColor(1.0, 1.0, 1.0),
									new IterationPalette(Palette.PALETTE_006, 100.0, 0.95 - 0.06 * t, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0 - 0.0001 * t, 1.237 + 0.000339 * t), 0.0192 * c, 0.0128 * c, -1.18 * t)),
					PATH + String.format("frames\\frame_003_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
