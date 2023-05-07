package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Vitrail de conques
 */
public class Image007 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
						OR(new IGreaterThan(2000), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(2000), new ConstantColor(1.0, 1.0, 1.0),
								new Pow(0.7,
										new Mul(new IterationPalette(Palette.PALETTE_007, 14.0, 0.0, 16.0, 0.0, 20.0,
												0.0, true), new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0, true),
												new IterationGradient(0.004, 225.0)))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0));
	}
}
