package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Orobanche
 */
public class Image088 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F29(), new Complex(-3.705387, 0.838875),
						OR(
								new IGreaterThan(100),
								new AbsGreaterThan(4.459596)
						),
						IF(
								new IGreaterThan(100),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
									new Pow(0.1, new FancyGradient002(4.459596)),
									new IterationGradient(0.04, 10)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(2.276, -0.307), 0.09, 0.06, -0.3927)
		);
	}
}
