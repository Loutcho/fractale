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
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Démonologie
 */
public class Image025 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.Demonologie(), null,
						OR(new IGreaterThan(1000), new AbsGreaterThan(3.8)),
						IF(new IGreaterThan(1000), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_025, 7.0, 0.8, true),
										new Bubble(2.0, 0.5, 2.0, 0.0, 2.0, 0.5, true))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(-0.23, 0.0), 1.5, 1.0, Math.PI / 2.0));
	}
}
