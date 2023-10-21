package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.FancyStopCriterion001;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ColorFunction0;
import xt.coloralgo.effect.ConstantColor;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Rubans et fourches
 */
public class Image052 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F8(), null,
						OR(
								new IGreaterThan(200),
								new FancyStopCriterion001()
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0.0, 0.0, 0.0),
								new ColorFunction0(0.0)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-1.210, -0.381), 0.216, 0.144, 0.0)
	);
	}
}
