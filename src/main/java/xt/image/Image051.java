package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.FancyStopCriterion002;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyAbsGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Tentacules
 */
public class Image051 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F4(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(128),
								new FancyStopCriterion002()
						),
						IF(
								new IGreaterThan(128),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
										new IterationPalette(Palette.PALETTE_051, 4.0, 0.0, false),
										new FancyAbsGradient()
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0.0, 0.0), 1.5 * 1.57, 1.57, 0.53)
		);
	}
}
