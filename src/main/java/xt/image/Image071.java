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
 * 71) Une nuit sur le Mont Chauve
 */
public class Image071 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F20(), new Complex(-0.815, -0.237),
						OR(
								new IGreaterThan(2000),
								new AbsGreaterThan(3.5)
						),
						IF(
								new IGreaterThan(2000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_071, 20.0, -0.05, true)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0.0, -0.54), 0.45, 0.30, 0.0)
		);
	}
}
