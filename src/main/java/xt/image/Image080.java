package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient005;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Embrasement
 */
public class Image080 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F26(),
						null,
						OR(
								new IGreaterThan(25000),
								new AbsGreaterThan(3.0)
						),
						IF(
								new IGreaterThan(25000),
								new ConstantColor(0x100040),
								new Mul(
									new IterationPalette(Palette.PALETTE_080, 2000.0, 0.2333333, false),
									new FancyGradient005(1144.66)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-0.5175, -0.4493), 14.7E-4, 9.8E-4, 0.04)
		);
	}
}
