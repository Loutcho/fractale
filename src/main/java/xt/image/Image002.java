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
 * Courbevoie
 */
public class Image002 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
						OR(new IGreaterThan(5000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(5000), new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_002, 384.0, 0.333333333, true)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.364480, 0.315382), 6E-6, 4E-6, 0.0));
	}
}
