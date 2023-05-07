package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Quatorze juillet
 */
public class Image017 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.QuatorzeJuillet(), new Complex(0.0, 1.8),
						OR(new IGreaterThan(100), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(100), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new ArgPalette(Palette.PALETTE_017, 1.0, 1.0 / 12.0),
										new IterationGradient(0.05, 10.0))),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY),
				new MathZone(new Complex(0.0, 0.24), 0.48, 0.32, 0.0));
	}
}
