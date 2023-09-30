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
 * Epineux
 */
public class Image091 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F31(), new Complex(-0.488, -0.537),
						OR(
								new IGreaterThan(100),
								new FancyStopCriterion002()
						),
						IF(
								new IGreaterThan(100),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
										new FancyAbsGradient(),
										new IterationPalette(Palette.PALETTE_091, 4, 0.0, false)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.167, -0.405), 1.5 * 0.07, 0.07, 0.82)
		);
	}
}
