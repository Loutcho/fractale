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
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Chambre à bulles
 */
public class Image030 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.MoebiusTenthRootOfUnity(), new Complex(-0.75, 0.0),
				OR(new IGreaterThan(18), new FancyStopCriterion003(0.0002)),
				IF(new IGreaterThan(18), new ConstantColor(0.0, 0.0, 0.0), new Mul(new IterationGradient(0.8, 8.0),
						new IterationPalette(Palette.PALETTE_030, 8.0, 0.0, false), new FancyGradient003(0.0002))),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(-1.425, 0.0), 1.3, 1.3 / 1.5, 0.0));
	}
}
