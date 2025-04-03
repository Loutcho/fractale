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
import xt.coloralgo.realexpression.Constant;
import xt.coloralgo.realexpression.Im;
import xt.coloralgo.realexpression.Re;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 73) Biface de diamant
 */
public class Image073 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(1.5), new Complex(-0.19, 0.00),
						OR(
								new IGreaterThan(1000),
								new GreaterThan(new Re(), new Constant(24)),
								new GreaterThan(new Im(), new Constant(24))
						),
						IF(
								new IGreaterThan(1000),
								new ConstantColor(0.0, 0.0, 0.0),
								new IterationPalette(Palette.PALETTE_073, 71.0, 0.75, false)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(0.29, 0.0), 1.05, 0.70, 0.0)
		);
	}
}
