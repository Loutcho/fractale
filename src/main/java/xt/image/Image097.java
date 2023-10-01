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
 * Plumage
 */
public class Image097 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F35(Math.PI/2.0, 0.5), new Complex(0.03069, -0.2253),
						OR(
								new IGreaterThan(500),
								new AbsGreaterThan(4.5)
						),
						IF(
								new IGreaterThan(500),
								new ConstantColor(0.5, 0.1, 0.0),
								new IterationGradient(0.03, 20.0)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-0.1, 1.62), 1.5 * 2.6, 2.6, 0.0)
		);
	}
}
