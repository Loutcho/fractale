package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ColorFunction0;
import xt.coloralgo.effect.ConstantColor;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 64)
 */
public class Image064 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F12(), new Complex(-0.735, -0.046),
						OR(
								new IGreaterThan(2000),
								new AbsGreaterThan(2.0)
						),
						IF(
								new IGreaterThan(2000),
								new ConstantColor(0.0, 0.0, 0.0),
								new ColorFunction0(0.0)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.125, -0.100), 0.225, 0.150, 0.0)
		);
	}
}
