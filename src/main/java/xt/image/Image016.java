package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Hiroshima
 */
public class Image016 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Hiroshima(), null,
						OR(new IGreaterThan(16000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(16000), new ConstantColor(0.0, 0.0, 0.0), new ConstantColor(1.0, 0.0, 0.0)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-1.10175, -0.71818), 0.00270, 0.00180, 0.56));
	}
}
