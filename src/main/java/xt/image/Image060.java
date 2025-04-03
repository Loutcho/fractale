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
 * 60) Projection astrale
 */
public class Image060 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(2, 0.0), new Complex(-0.2241, -0.2049),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(1E5)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_060, 126.0, 0.7, true)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.04, 0.), 1.17, 0.56, Math.PI / 2.0)
		); 
	}
}
