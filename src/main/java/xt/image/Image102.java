package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Hiver
 */
public class Image102 {

	private static final double K = 1.0 / 3.0;
	
	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F39(K * Math.PI), new Complex(-0.366, -1.355),
				OR(new IGreaterThan(1000), new AbsGreaterThan(0.699)),
				IF(new IGreaterThan(1000),
						new ConstantColor(1.0, 1.0, 1.0),
						new Mul(
								new Inverse(new GridIm(0.25, 1.00, 0.55, 0.40)),
								new IterationGradient(0.4, 12.0)
						)
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(0.0, 0.0), 1.5 * 0.0078, 0.0078, 0.0));
	}
}
