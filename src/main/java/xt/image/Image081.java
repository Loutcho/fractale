package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Méduse fantôme
 */
public class Image081 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.5, 0.0),
						new Complex(-0.812, 0.7575),
						OR(
								new IGreaterThan(200),
								new AbsGreaterThan(2.37)
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0x000000),
								new Max(
									new IterationPalette(Palette.PALETTE_081, 72.0, 0.62, true),
									new GridRe(0.075, 0.3, 0.0, 1.0),
									new GridIm(0.075, 0.9, 0.8, 0.5)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-1.042, 0.35), 0.165, 0.110, -1.18)
		);
	}
}
