package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgGradient;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Silhouette vampirique
 */
public class Image022 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.NidDeMonstres(), new Complex(-0.0090, 0.0385),
				OR(new IGreaterThan(1000), new AbsGreaterThan(3E5)),
				IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
						new Pow(0.8,
								new Max(new IterationPalette(Palette.PALETTE_022, 66.0, 0.33, true),
										new ArgGradient(1.0, 0.80, 0.75)))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.0, -0.15), 1.05, 0.37, 0.0));
	}
}
