package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 59)
 */
public class Image059 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1, 0.0), new Complex(-0.96873, -0.64454),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(1E4)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_059, 84.0, 0.7, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.435, 0.000), 1.10, 0.72, - Math.PI / 2.0)
		);
	}
}
