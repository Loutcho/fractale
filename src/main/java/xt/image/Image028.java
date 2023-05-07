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
 * Comique et cosmique
 */
public class Image028 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.F18(), new Complex(0.0, 0.0),
						OR(new IGreaterThan(64), new FancyStopCriterion002()),
						IF(new IGreaterThan(64), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_028, 2.0, 0.0, false),
										new FancyAbsGradient())),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY),
				new MathZone(new Complex(2.930, -2.930), 1.5 * 0.041, 0.041, 2.360));
	}
}
