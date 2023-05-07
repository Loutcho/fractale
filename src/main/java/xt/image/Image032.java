package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Bêtises de Cambrai
 */
public class Image032 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Collatz2(), new Complex(0.0, -0.0025),
						OR(new IGreaterThan(2000), new AbsGreaterThan(1.75)),
						IF(new IGreaterThan(2000), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_032, 33.0, 0.0, true),
										new Bubble(50.0, 0.0, 50.0, 0.2, 50.0, 1.0, true))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-0.00820, 0.00786), 0.0054, 0.0036, 0.4));
	}
}
