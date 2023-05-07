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
 * Danseuses aux rubans
 */
public class Image029 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.MoebiusTenthRootOfUnity(), new Complex(-0.035, -0.794),
						OR(new IGreaterThan(64), new FancyStopCriterion003(0.02)),
						IF(new IGreaterThan(64), new ConstantColor(0.0, 0.0, 0.1),
								new Mul(new IterationPalette(Palette.PALETTE_029, 3.0, 0.0, false),
										new FancyGradient003(0.02))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.000, 0.015), 1.89, 1.26, 0.0));
	}
}
