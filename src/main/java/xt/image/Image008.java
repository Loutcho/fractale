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
 * Nimbocumulus
 */
public class Image008 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), new Complex(-1.749272, -2.16E-4),
						OR(new IGreaterThan(3000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(3000), new ConstantColor(1.0, 1.0, 1.0),
								new IterationPalette(Palette.PALETTE_008, 50.0, 0.5, true)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.0, 0.0), 0.150, 0.100, Math.PI / 2.0));
	}
}
