package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.FancyStopCriterion003;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient003;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Calice de minuit treize
 */
public class Image031 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.MoebiusTenthRootOfUnity(), new Complex(-0.75, 0.0),
						OR(new IGreaterThan(12), new FancyStopCriterion003(0.013)),
						IF(new IGreaterThan(12), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_031, 8.0, 1.0 / 8.0, false),
										new FancyGradient003(0.013))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-1.0, 0.0), 1.4, 1.4 / 1.5, Math.PI / 2.0));
	}
}
