package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsGrid;
import xt.coloralgo.effect.AbsLog;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Escargots
 */
public class Image099 {

	public static Image get() {
		
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F37(), new Complex(-0.528, +0.001),
						OR(
								new IGreaterThan(5000),
								new AbsGreaterThan(1.0)
						),
						IF(
								new IGreaterThan(5000),
								new ConstantColor(0.0, 0.0, 0.0),
									new Mul(
									new AbsLog(0.15),
									new AbsGrid(0.5, 0.25),
									new ArgPalette(Palette.PALETTE_099, 1.0, 0.433333)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 17.0), 30.0, 20.0, 0.0)
		);
	}
}
