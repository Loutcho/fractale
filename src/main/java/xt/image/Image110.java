package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import java.util.function.Function;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Effect;
import xt.coloralgo.effect.Inverse;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * Aurore boréale
 */
public class Image110 {

	private static final double U = 0.23;
	
	public static Image get() {

		Function<Complex, Complex> function = new xt.function.F44(new Complex(-0.7, +0.7), new Complex(-0.5, -1.3), new Complex(-0.2, 0.0));
		Complex zJulia = new Complex(-0.9007, 1.554);
		BooleanExpression stopCriterion = OR(new IGreaterThan(700), new AbsGreaterThan(7.0E118));
		Effect effect = IF(new IGreaterThan(700),
				new ConstantColor(0x000000),
				new Mul(
						new Inverse(new IterationGradient(.2, 22.0)),
						new IterationPalette(Palette.PALETTE_110, 64.0, 0.0, false)
				)
		);
		ApplyTestOrder order = ApplyTestOrder.FIRST_APPLY_THEN_TEST;

		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(-1.950, 0.600);
		double xSemiLength = 1.5 * U;
		double ySemiLength = U;
		double rotationAngle = 0.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle);
		
		return new Image(colorAlgo, mathZone);
	}
}
