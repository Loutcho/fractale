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
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Fegatello
 */
public class Image003 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
						OR(new IGreaterThan(5000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(5000), new ConstantColor(1.0, 1.0, 1.0),
								new Pow(1.5, new IterationPalette(Palette.PALETTE_003, 48.0, 0.0, true))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-1.749798494, 0.000032655), 0.000000150, 0.000000100, 0.0));
	}
}
