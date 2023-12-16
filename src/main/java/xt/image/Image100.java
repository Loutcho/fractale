package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Entortillé
 */
public class Image100 {

	private static final double K = 0.01;
	
	public static Image get() {
		
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.F24(), new Complex(-0.3811, -0.5833),
						OR(
								new IGreaterThan(1500),
								(i, z) -> (Math.abs(z.re()) <= K) || (Math.abs(z.im()) <= K)
						),
						IF(
								new IGreaterThan(1500),
								new ConstantColor(0.0, 0.0, 0.0),
									new Mul(
										new ArgPalette(Palette.PALETTE_100, 0.5, 0.0),
										new IterationGradient(0.007, 50)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-116900000, 18000000), 1.5 * 13300000, 13300000, 0.0)
		);
	}
}
