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
 * Totem polype
 */
public class Image082 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.5, 0.0),
						new Complex(-1.075903, 0.62803),
						OR(
								new IGreaterThan(200),
								new AbsLessThan(6.8E-4)
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0x001000),
								new Mul(
										new IterationPalette(Palette.PALETTE_082, Palette.PALETTE_082.getNbColors(), 0.0, false),
										new FancyGradient002(6.8E-4)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.13992, 0.02442), 0.001542, 0.001028, -0.23)
		);
	}
}
