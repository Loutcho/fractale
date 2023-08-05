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
 * Parure d'améthystes
 */
public class Image011 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Sylvestre(1, 0.0), new Complex(-0.9568, -0.7992),
						OR(new IGreaterThan(1000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
								new Pow(0.7, new IterationPalette(Palette.PALETTE_011, 84.0, 0.7, true))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-0.44, 0.0), 1.2, 0.8, Math.PI / 2.0));
	}
}
