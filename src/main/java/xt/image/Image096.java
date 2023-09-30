package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Frise
 */
public class Image096 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F34(1.06), new Complex(-0.21, -0.69),
						OR(
								new IGreaterThan(200),
								new AbsGreaterThan(24.0)
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationGradient(0.03, 20.0)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-2.63, 0.0), 1.5 * 0.5, 0.5, 0.0)
		);
	}
}
