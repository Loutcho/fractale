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

/**
 * Composition florale
 */
public class Image018 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Fleur(), new Complex(0.0, 0.0),
						OR(new IGreaterThan(7), new AbsGreaterThan(2E11)),
						IF(new IGreaterThan(7), new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_018, 3.0, 0.0, false)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0));
	}
}
