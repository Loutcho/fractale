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
 * Stomoxe
 */
public class Image024 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.Stomoxe(), new Complex(0.0, 0.0),
				OR(new IGreaterThan(1000), new AbsGreaterThan(1E12)),
				IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
						new IterationPalette(Palette.PALETTE_024, 15.0, 0.05, true)),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(-0.95, 0.0), 1.65, 1.10, 0.0));
	}
}
