package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 70) Disques 
 */
public class Image070 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F19(), new Complex(2.02777777777777777, 0.0),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(5.17)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
										new IterationPalette(Palette.PALETTE_070, 4.0, 0.0, false),
										new FancyGradient002(5.17)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-1.660, 1.649), 1.5 * 0.0247, 0.0247, 0.0)
		);
	}
}
