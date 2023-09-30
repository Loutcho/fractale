package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Barbie
 */
public class Image094 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F33(), new Complex(0.29463, 0.0),
						OR(
								new IGreaterThan(1500),
								new AbsGreaterThan(18.65)
						),
						IF(
								new IGreaterThan(1500),
								new ConstantColor(0.0, 0.0, 0.0),
								new Inverse(
									new Mul(
											new IterationPalette(Palette.PALETTE_094, 4.0, 0.0, false),
											new IterationGradient(0.01, 0.0),
											new ArgGrid(1, 0.2, 0.5 * 2.0 * Math.PI)
									)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(1.0, 0.0), 1.5 * 2.6, 2.6, -Math.PI / 2.0)
		);
	}
}
