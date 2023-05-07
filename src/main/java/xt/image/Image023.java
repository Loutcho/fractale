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
import xt.coloralgo.effect.Max;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Eclatement de paradis
 */
public class Image023 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F7(), new Complex(0.1, 0.1),
				OR(new IGreaterThan(1000), new AbsGreaterThan(2.4)),
				IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
						new Max(new IterationPalette(Palette.PALETTE_023, 3.0, 0.800000, true),
								new IterationPalette(Palette.PALETTE_023, 4.0, 0.133333, true),
								new IterationPalette(Palette.PALETTE_023, 5.0, 0.466666, true))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.14, 0.35), 0.3, 0.2, 0.0));
	}
}
