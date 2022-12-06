package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video009 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 *  
	 * 
	 */
	public static void main(String[] args) {
		int n = 300;
		for (int i = 0; i < n; i ++) {
			System.out.println("---- " + i + " ----");
			double t = ((double) i) / ((double) n);
			new ImageFile(
					new Image(
							new EscapeTimeAlgorithm(
								new xt.function.QuatorzeJuillet(), new Complex(0.0, 1.8),
								OR(
										new IGreaterThan(1000),
										new AbsGreaterThan(2.0)
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(1.0, 1.0, 1.0),
										new Mul(
												new ArgPalette(Palette.PALETTE_017bis, 1.0, t),
												new FancyGradient002(2.0)
										)
								),
								ApplyTestOrder.FIRST_APPLY_THEN_TEST
							),
							new MathZone(new Complex(0.0, 0.4), 1.024, 0.600, 0.0)
					),
					PATH + String.format("frames\\frame_009_%03d.png", i),
					DIMENSION_X, DIMENSION_Y
			).create();
		}
	}
}
