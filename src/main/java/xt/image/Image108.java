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
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

// Cercles imbriqués tournants

public class Image108 {

	private static final double U = 1.0;

	public static Image get() {

		Function<Complex, Complex> function = new xt.function.F43();
		Complex zJulia = new Complex(0.0, 0.0);
		BooleanExpression stopCriterion = OR(new IGreaterThan(200), new AbsGreaterThan(1.0));
		Effect effect = IF(new IGreaterThan(200),
				new ConstantColor(0x000000),
				new Mul(
						new GridRe(0.3, 1.0, 1.0, 1.0),
						new IterationPalette(Palette.PALETTE_108, 4.0, 0.0, false)
				)
		);
		ApplyTestOrder order = ApplyTestOrder.FIRST_TEST_THEN_APPLY;

		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(0.0, 0.0);
		double xSemiLength = 1.5 * U;
		double ySemiLength = U;
		double rotationAngle = 0.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle);

		return new Image(colorAlgo, mathZone);
	}
}
