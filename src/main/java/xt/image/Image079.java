package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient005;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Odysseus
 */
public class Image079 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F25(),
						new Complex(6.1, 7.8),
						OR(
								new IGreaterThan(50),
								new AbsGreaterThan(1100.0)
						),
						IF(
								new IGreaterThan(50),
								new ConstantColor(0xFFFFFF),
								new Mul(
									new IterationPalette(Palette.PALETTE_079, Palette.PALETTE_079.getNbColors(), 0.0, false),
									new FancyGradient005(1100.0)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-80.5, 0.0), 10.5, 7.0, Math.PI / 2.0)
		);
	}
}
