package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GreaterThan;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.realexpression.Constant;
import xt.coloralgo.realexpression.Im;
import xt.coloralgo.realexpression.Re;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 72) Mer agitée
 */
public class Image072 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F21(), new Complex(2.62, 0.43),
						OR(
								new IGreaterThan(1000),
								new GreaterThan(new Re(), new Constant(1000.0)),
								new GreaterThan(new Im(), new Constant(1000.0))
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new Max(
									new IterationPalette(Palette.PALETTE_072, 16.0, 0.30, false),
									new IterationPalette(Palette.PALETTE_072, 16.0, 0.53, true)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-0.935, 1.729), 0.42, 0.28, 0.25)
		);
	}
}
