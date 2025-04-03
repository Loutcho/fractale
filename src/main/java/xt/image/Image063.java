package xt.image;

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
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 63) Convergence des âmes
 */
public class Image063 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(3, 0.0), new Complex(1.114, -0.128),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(1E5)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_063, 126.0, 0.7, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(1.17977, 0.24834), 0.01155, 0.00770, 0.0)
		);
	}
}
