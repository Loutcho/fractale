package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient003;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Pavage
 */
public class Image039 {

	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(new xt.function.BurningShip(),
						new Complex(-0.3704811600009095, -0.6617112369285517),
						OR(new IGreaterThan(1024), new AbsLessThan(3.10147E-12)),
						IF(new IGreaterThan(1024), new ConstantColor(0.0, 0.0, 0.0),
								new Mul(new IterationPalette(Palette.PALETTE_039, 4.0, 0.0, false),
										new FancyGradient003(3.10147E-12))),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST),
				new MathZone(new Complex(0.0, 0.0), 1.5 * 1.136, 1.136, 0.0));
	}
}
