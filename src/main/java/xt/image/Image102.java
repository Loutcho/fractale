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
 * Flocons de neige
 */
public class Image102 {

	private static final double U = 0.001005;
	private static final double K = 1.0 / 3.0;
	private static final double X = -0.366025;
	private static final double Y = -1.364680;
	
	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F39(K * Math.PI), new Complex(X, Y),
				OR(new IGreaterThan(200), new AbsGreaterThan(0.98)),
				IF(new IGreaterThan(200),
					new ConstantColor(0.0, 0.0, 0.0),
					new Mul(
						new Inverse(new GridIm(0.25, 1.00, 0.60, 0.40)),
						new IterationGradient(0.3, 15.5)
					)
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(0.0, 0.0), 1.5 * U, U, 0.0));
		}
}
