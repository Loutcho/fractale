package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.And;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsPalette;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.Barycenter;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Donut;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Bisou
 */
public class Image090 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F30(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(200),
								new And(new AbsGreaterThan(0.57), new AbsLessThan(0.93))
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
										new Donut(0.57, 0.93, 2.0, 2.0, 2.0),
										new IterationGradient(0.20, 2.0),
										new ArgPalette(Palette.PALETTE_090a, 1.0 / 3.0, 0.4),
										new AbsPalette(Palette.PALETTE_090b, 0.3, 0.4),
										new Barycenter(0.45,
												new ConstantColor(1.0, 1.0, 1.0),
												0.55,
												new ArgGrid(4, 2.0, 0.0)
										)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(+0.0, -0.0), 1.41, 0.94, -Math.PI/4.0)
		);
	}
}
