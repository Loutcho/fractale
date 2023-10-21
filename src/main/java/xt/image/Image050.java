package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Couronne de Pâques 
 */
public class Image050 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F5(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(128),
								new AbsLessThan(0.666)
						),
						IF(
								new IGreaterThan(128),
								new ConstantColor(0.0, 0.0, 0.0),
								new Mul(
										new IterationPalette(Palette.PALETTE_050, 4.0, 0.0, false),
										new FancyGradient002(0.666)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(0.0, 0.0), 1.5 * 1.57, 1.57, 0.0)
		);
	}
}
