package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.booleanexpression.UniformNormLessThan1;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.FancyGradient006;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * Arbre binaire double
 */
public class Image104 {

	private static final Complex JULIA_POINT = new Complex(0.0, 0.0);
	private static final Complex CENTER = new Complex(0.0, 0.0);
	private static final double U = 3.0;

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.F40(), JULIA_POINT,
				OR(new IGreaterThan(200), new UniformNormLessThan1()),
				IF(new IGreaterThan(200),
					new ConstantColor(0.04, 0.0, 0.0),
					new Mul(
							new FancyGradient006(1.0),
							new ArgPalette(Palette.PALETTE_104, 1.0, 0.0)
					)
				),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(CENTER, 1.5 * U, U, 0.0));
		}
}
