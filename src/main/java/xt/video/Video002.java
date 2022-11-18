package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video002 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Vitrail de conques, palette changeante
	 * 100 images pour une video cyclique
	 */
	public static void main(String[] args) {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			System.out.println("----- " + i);
			double t = (double) i / (double) n;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), null,
							OR(
									new IGreaterThan(2000),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(2000),
									new ConstantColor(1.0, 1.0, 1.0),
									new Pow(0.6,
											new Mul(
													// déphasages de palette
													new IterationPalette(Palette.PALETTE_007, 14.0, -t, 16.0, -2.0 * t, 20.0, -3.0 * t, true),
													new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0, true),
													new IterationGradient(0.004, 115.0)
											)
									)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0)),
					PATH + String.format("frames\\frame_002_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
