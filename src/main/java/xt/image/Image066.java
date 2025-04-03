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
 * 66)
 */
public class Image066 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F14(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(320.0)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.078, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_066, 32.0, 0.25, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 0.0), 6.6, 4.4, 0.0)
		);
	}
}
