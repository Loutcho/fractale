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
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Spiderman
 */
public class Image092 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Spiderman(), new Complex(0.1890, 0.0019),
						OR(
								new IGreaterThan(2000),
								new AbsGreaterThan(1.54)
						),
						IF(
								new IGreaterThan(2000),
								new ConstantColor(0.0, 0.0, 0.0),
								
								new Max(
									new Mul(
										new Inverse(new IterationGradient(0.005, -0.11)),
										new ConstantColor(1.0, 0.25, 0.30)
									),
									new Mul(
										new IterationGradient(0.017, -0.11),
										new ArgPalette(Palette.PALETTE_092, 0.25, -0.10)
									)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 0.0), 1.5 * 0.76, 0.76, 0.0)
		);
	}
}
