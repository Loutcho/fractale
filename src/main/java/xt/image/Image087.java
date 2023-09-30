package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.FancyStopCriterion002;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyAbsGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Joyeux anniversaire Nini !
 */
public class Image087 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F28(), new Complex(-1.014, -1.414),
						OR(
								new IGreaterThan(512),
								new FancyStopCriterion002()
						),
						IF(
								new IGreaterThan(512),
								new ConstantColor(0.0, 0.0, 0.1),
								new Mul(
										new IterationPalette(Palette.PALETTE_087, 4.0, 0.0, false),
										new FancyAbsGradient()
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0, 0.0), 4.23, 2.82, 0.0)
	);
	}
}
