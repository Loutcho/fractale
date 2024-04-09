package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Flocons de neige bleu-rose
 */
public class Image102 {

	private static final double K = 1.0 / 3.0;
	private static final double X = -0.366025;
	private static final double Y = -1.358000;
	
	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F39(K * Math.PI), new Complex(X, Y),
				OR(new IGreaterThan(200), new AbsGreaterThan(1.00)),
				IF(new IGreaterThan(200),
						new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
								new Max(
										new Inverse(new GridIm(0.40, 1.00, 0.50, 0.30)),
										new GridRe(0.40, 0.80, 0.60, 0.60)
								),
								new IterationGradient(0.4, 12.0)
						)
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(0.0, 0.0), 1.5 * 0.0058, 0.0058, 0.0));
	}
}
