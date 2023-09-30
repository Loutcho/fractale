package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.FancyGradient003;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Magma basaltique
 */
public class Image086 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F27(),
						new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(512),
								new AbsGreaterThan(1.0)
						),
						IF(
								new IGreaterThan(512),
								new ConstantColor(0.0, 0.0, 0.0),
								new Inverse(
								new Max(
									new IterationPalette(Palette.PALETTE_086, 18.0, -0.25, true),
									new Mul(
										new IterationPalette(Palette.PALETTE_086, 12.0, -0.25, false),
										new FancyGradient002(1.0),
										new FancyGradient003(5.0)
									)
								)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 0.0), 1.44, 0.96, - Math.PI / 2.0)
		);
	}
}
