package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Min;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Lentille gravitationnelle
 */
public class Image021 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F6(), new Complex(1.6, -0.1),
				OR(new IGreaterThan(1000), new AbsGreaterThan(2.71)),
				IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
						new Mul(new IterationPalette(Palette.PALETTE_021, 3.0, 0.0, true),
								new Pow(0.7, new Min(new GridRe(0.3, 0.7, 1.0, 1.0), new GridIm(0.3, 1.0, 1.0, 0.7))))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.0, 0.0), 2.70, 1.80, 1.5));
	}
}
