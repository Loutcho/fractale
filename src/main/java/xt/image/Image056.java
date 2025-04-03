package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 56) Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
 */
public class Image056 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F10(), new Complex(0.0, 0.0),
						OR(
								new IGreaterThan(2000),
								new AbsLessThan(1.0)
						),
						IF(
								new IGreaterThan(2000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_056, 4.0, 0.0, false)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		);
	}
}
