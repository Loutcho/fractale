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
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Experiment
 */
public class Image103 {

	private static final double U = 0.43;
	private static final double K = 5.0 / 7.0;
	
	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F39(K * Math.PI), null,
				OR(new IGreaterThan(2000), new AbsGreaterThan(1.4)),
				IF(new IGreaterThan(2000),
					new ConstantColor(0.0, 0.0, 0.0),
					new Max(
						new Inverse(new GridIm(0.35, 1.00, 0.60, 0.40)),
						new IterationGradient(0.18, 1.0)
					)
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(-0.97, -0.06), 1.5 * U, U, 0.0));
		}
}
