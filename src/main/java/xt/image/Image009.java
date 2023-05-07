package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Image009 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.F4(), new Complex(0.7639, 0.3125),
						OR(new IGreaterThan(3000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(3000), new ConstantColor(0.0, 0.0, 0.0),
								new Pow(0.4,
										new Mul(new IterationPalette(Palette.PALETTE_009, 33.0, 0.0, true),
												new IterationGradient(0.015, 0.0), new AbsGradient1(0.85, 1.0, 1.0)))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.595, -0.190), 0.45, 0.30, 0.0));
	}
}
