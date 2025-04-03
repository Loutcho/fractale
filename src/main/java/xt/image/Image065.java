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

/*
 * 65) Des empreintes dans la neige
 */
public class Image065 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F13(), null,
						OR(
								new IGreaterThan(32000),
								new AbsGreaterThan(2.7)
						),
						IF(
								new IGreaterThan(32000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_065, 30.91, 0.0, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.674387, 0.002552), 6E-5, 4E-5, 0.0)
		);
	}
}
