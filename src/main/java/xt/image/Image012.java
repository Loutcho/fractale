package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Papillon
 */
public class Image012 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.Papillon(), new Complex(0.3472, 0.1172),
				OR(new IGreaterThan(200), new AbsGreaterThan(2.0)),
				IF(new IGreaterThan(200), new ConstantColor(0.0, 0.0, 0.0),
						new Pow(0.7,
								new Mul(new IterationPalette(Palette.PALETTE_012, 8.0, 0.1, true),
										new Max(new ArgGrid(6, 1.0), new ArgPalette(Palette.PALETTE_012, 1.0, 0.0))))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.160, -0.230), 0.585, 0.390, -0.72));
	}
}
