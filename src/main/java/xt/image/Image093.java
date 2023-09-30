package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Lemniscate
 */
public class Image093 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F32(2.0, 2.0), new Complex(1.540922, -0.091003),
						OR(
								new IGreaterThan(500),
								new AbsGreaterThan(32.0)
						),
						IF(
								new IGreaterThan(500),
								new ConstantColor(0.0, 0.0, 0.0),
								new Max(
									new Mul(
											new ConstantColor(1.0, 0.0, 0.0),
											new Inverse(new IterationGradient(0.3, 12.0))
									),
									new Mul(
										new ConstantColor(0.0, 1.0, 0.0),
										new Inverse(new IterationGradient(0.4, 17.0))
									),
									new Mul(
											new ConstantColor(0.0, 0.0, 1.0),
											new Inverse(new IterationGradient(0.2, 22.0))
									)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 0.0), 1.0 * 1.5 * 1.18, 0.75 * 1.18, 0.0)
		);
	}
}
