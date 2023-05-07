package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsArgGradient;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Propagation
 */
public class Image001 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
						OR(new IGreaterThan(120), new AbsGreaterThan(2.0)),
						IF(new IGreaterThan(120), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_001, 55.0, 0.65, true),
										new AbsArgGradient())),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-1.76208912, -0.01550358), 1.95E-7, 1.30E-7, 0.0));
	}
}
