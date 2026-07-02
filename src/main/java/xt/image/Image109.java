package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import java.util.function.Function;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.booleanexpression.FancyStopCriterion001;
import xt.coloralgo.booleanexpression.FancyStopCriterion002;
import xt.coloralgo.booleanexpression.FancyStopCriterion003;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Effect;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Image109 {

	private static final double U = 1.0;
	
	public static Image get() {

		Function<Complex, Complex> function = new xt.function.Mandelbox(new Complex(-1.7, 0.0), 0.7, new Complex(0.7, 0.0));
		Complex zJulia = new Complex(0.0, -1.0);
		BooleanExpression stopCriterion = OR(new IGreaterThan(700), new FancyStopCriterion003(0.1));
		Effect effect = IF(new IGreaterThan(700),
				new ConstantColor(0xFFFFFF),
				new IterationPalette(Palette.PALETTE_109, 7.0, 0.0, true)
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
