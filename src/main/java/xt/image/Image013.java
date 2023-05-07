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
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Syracuse
 */
public class Image013 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Collatz(), new Complex(0, 0),
						OR(new IGreaterThan(1000), new AbsGreaterThan(40.0)),
						IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_013, 8.0, 0.0, true),
										new ArgPalette(Palette.PALETTE_013, 0.5, 0.333))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-0.39962, 0.27487), 0.0018, 0.0012, 0.21));
	}
}
