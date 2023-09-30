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
 * Stomoxe II
 */
public class Image095 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Stomoxe(-1.0 / 3.0, 1.0), null,
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(1E12)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationGradient(0.06, 8.0)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-0.85, 0.0), 1.5 * 1.0, 1.0, 0.0)
		);
	}
}
