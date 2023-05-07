package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Mélodies nacrées
 */
public class Image019 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
				OR(new IGreaterThan(10000), new AbsGreaterThan(20.0)),
				IF(new IGreaterThan(10000), new ConstantColor(0.0, 0.0, 0.0), new Max(
						new Mul(new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666, true),
								new Bubble(12.0, 0.6666666, 12.0, 0.0000000, 12.0, 0.3333333, true)),
						new Max(new AbsGradient1(1.0, 1.0, 1.0), new ArgPalette(Palette.PALETTE_019, 0.125, 0.0)))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.3032, 0.0222), 0.0036, 0.0024, 0.0));
	}
}
