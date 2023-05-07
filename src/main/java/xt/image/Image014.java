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
import xt.coloralgo.effect.Max;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Fortifications
 */
public class Image014 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.BurningShip(), new Complex(-0.5429, 0.1839),
						OR(new IGreaterThan(3500), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(3500), new ConstantColor(1.0, 1.0, 1.0),
								new Max(new IterationPalette(Palette.PALETTE_014, 40.0, 0.15, false),
										new GridIm(0.2, 1.0, 1.0, 0.8), new GridRe(0.2, 0.2, 0.2, 0.8))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.0, 0.4655), 0.0039, 0.0026, Math.PI));
	}
}
