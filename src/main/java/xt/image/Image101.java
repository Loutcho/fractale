package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgGradient;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Harmonie des Sphères
 */
public class Image101 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F38(), new Complex(0.0, 0.0),
				OR(new IGreaterThan(2800), new AbsGreaterThan(5.0)),
				IF(new IGreaterThan(2800),
						new ConstantColor(0.0, 0.0, 0.0),
						new Mul(
								new IterationGradient(0.1, 0),
								new ArgGradient(1.0, 0.95, 0.90)
						)
						
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(0.0, 0.0), 1.5 * 1.6, 1.6, Math.PI / 4.0));
	}
}
