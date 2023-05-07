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
 * Vaisseau alien
 */
public class Image006 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498),
						OR(new IGreaterThan(5000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(5000), new ConstantColor(1.0, 1.0, 1.0),
								new IterationPalette(Palette.PALETTE_006, 100.0, 0.95, true)),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.0, 1.237), 0.0192, 0.0128, 0.0));
	}
}
