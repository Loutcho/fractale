package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Trop d'écran
 */
public class Image026 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.TropDEcran(), new Complex(0.0, 0.0),
				OR(new IGreaterThan(10000), new AbsLessThan(0.25)),
				IF(new IGreaterThan(10000), new ConstantColor(0.0, 0.0, 0.0),
						new IterationPalette(Palette.PALETTE_026, 4.0, 0.0, false)),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(13.5, 21.5), 0.5, 0.5, 0.0));
	}
}
