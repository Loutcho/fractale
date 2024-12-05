package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient002;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Brebis turquoise
 */
public class Image083 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.3333333, 0.0),
						new Complex(-0.73743019, -0.12891747),
						OR(
								new IGreaterThan(80),
								new AbsLessThan(0.15353)
						),
						IF(
								new IGreaterThan(80),
								new ConstantColor(0x222222),
								new Mul(
									new FancyGradient002(0.15353),
									new ArgPalette(Palette.PALETTE_083, 1.0, 0.42)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.35, 0.0), 1.15, 0.70, Math.PI / 2.0)
		);
	}
}
