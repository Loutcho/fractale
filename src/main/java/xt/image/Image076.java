package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsLog;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Max;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 76) Fleur d'artifice
 */
public class Image076 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F22(5.0), new Complex(-104.9, 0.0),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(1E8)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0x000022),
								new Max(
										new ArgPalette(Palette.PALETTE_075, 1.0, 0.85),
										new AbsLog(33.0)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(3.0, 0.5), 2.04, 1.36, -0.9)
		);
	}
}
