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

public class Video001 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Méduse
	 * 100 images pour une video cyclique
	 */
	public static void main(String[] args) {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			// Le paramètre c de Julia décrit un cercle :
			double theta = i * 2.0 * Math.PI / n;
			double dx = 3E-2 * Math.cos(theta);
			double dy = 3E-2 * Math.sin(theta);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1, 0.0), new Complex(-0.87 + dx, -0.90 + dy),
						OR(
								new IGreaterThan(100),
								new AbsGreaterThan(2.0)
						),
						IF(
								new IGreaterThan(100),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_VIDEO_001, 100.0, 0.40, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(-0.38, 0.0), 1.35, 0.80, - Math.PI / 2.0)),
					PATH + String.format("frames\\frame_001_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
