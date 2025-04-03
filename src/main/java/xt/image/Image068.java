package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 68) Mouche Toutankhamon
 */
public class Image068 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F16(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(4000),
								new AbsLessThan(2.0)
						),
						IF(
								new IGreaterThan(4000),
								new ConstantColor(0.078, 0.0, 0.0),
								new Max(
										new ArgPalette(Palette.PALETTE_068, 1.0, 0.0),
										new Min(
												new GridRe(0.4, 1.0, 1.0, 0.95),
												new GridIm(0.4, 1.0, 1.0, 0.95)
										)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-3.2, 0.0), 4.2, 2.4, Math.PI / 2.0)
		);
	}
}
