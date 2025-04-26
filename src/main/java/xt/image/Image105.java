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

/*
 * Galaxie
 */
public class Image105 {

	private static final double U = 0.33;

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F41(),
						new Complex(-0.525758, -0.660712),
						OR(new IGreaterThan(2000), new AbsGreaterThan(9.0)),
						IF(new IGreaterThan(2000),
							new ConstantColor(0.0, 0.0, 0.0),
							new IterationGradient(0.11, 20.0)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY),
						new MathZone(new Complex(1.800, -0.336), 1.5 * U, U, 0.0)
				);
		}
}
