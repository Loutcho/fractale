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
import xt.coloralgo.effect.FancyGradient004;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 78) Clown de Noël
 */
public class Image078 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F24(), new Complex(0.0, 2.477),
						OR(
								new IGreaterThan(1000),
								new AbsGreaterThan(3.5875)
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0x000000),
								new Mul(
										new IterationPalette(Palette.PALETTE_078, 10.0, 0.0, false),
										new Max(
												new Inverse(new FancyGradient004(3.5875)),
												new FancyGradient002(3.5875)
										)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0.0, 2.4), 1.8, 1.2, 0.0)
		);
	}
}
