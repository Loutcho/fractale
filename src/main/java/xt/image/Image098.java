package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Experience
 */
public class Image098 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F36(), new Complex(-1.02, -1.85),
						OR(
								new IGreaterThan(100),
								new AbsGreaterThan(1.0)
						),
						IF(
								new IGreaterThan(100),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationGradient(0.4, 8.00)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0, 0), 0.95, 0.78, Math.PI / 4.0)
		);
	}
}
