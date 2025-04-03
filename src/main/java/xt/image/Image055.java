package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.booleanexpression.ReLessThan;
import xt.coloralgo.effect.ColorFunction3;
import xt.coloralgo.effect.ConstantColor;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 55) Fractale, pas très jolie mais pédagogique : doublement d'angle
 */
public class Image055 {
	public static Image get() {
		return new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F9(),
							new Complex(0.0, 0.0),
							OR(new IGreaterThan(2000), new ReLessThan(0.0)),
							IF(new IGreaterThan(2000),
									new ConstantColor(0.0, 0.0, 0.0),
									new ColorFunction3()
							),
							ApplyTestOrder.FIRST_TEST_THEN_APPLY
					),
					new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		);
	}
}
