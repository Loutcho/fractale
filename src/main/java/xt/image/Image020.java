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
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Aïe j'ai mal
 */
public class Image020 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.AieJAiMal(), null,
				OR(new IGreaterThan(1000), new AbsGreaterThan(200.0)),
				IF(new IGreaterThan(1000), new ConstantColor(0x091A48),
						new Max(new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666, true),
								new AbsGradient1(1.0, 1.0, 1.0), new ArgPalette(Palette.PALETTE_020, 0.125, 0.0))),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(-0.9, 2.4), 3.6, 2.4, 0.0));
	}
}
