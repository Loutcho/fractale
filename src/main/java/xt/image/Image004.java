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

/**
 * Chenille
 */
public class Image004 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
						OR(new IGreaterThan(15000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(15000), new ConstantColor(1.0, 1.0, 1.0),
								new IterationPalette(Palette.PALETTE_004, 226.0, 0.50, true)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-1.250314, 0.01376), 0.000111, 0.000075, -Math.PI / 12.0));
	}
}
