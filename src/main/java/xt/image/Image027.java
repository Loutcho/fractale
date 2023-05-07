package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.Barycenter;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Eclipse de trou noir
 */
public class Image027 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.F17(), null,
						OR(new IGreaterThan(2000), new AbsGreaterThan(6.0)),
						IF(new IGreaterThan(2000), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_027, 47.0, 0.25, false),
										new Barycenter(0.75, new ConstantColor(1.0, 1.0, 1.0), 0.25,
												new Bubble(1.0, 0.0, 1.0, 0.333, 1.0, 0.666, false)))),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY),
				new MathZone(new Complex(-1.321, 0.288), 0.0555, 0.0370, 0.25));
	}
}
