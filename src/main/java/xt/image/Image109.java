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
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Image109 {

	private static final double U = 4.439E16;
	
	public static Image get() {

		Function<Complex, Complex> function = new xt.function.Mandelbox(new Complex(-1.7, 0.0), 0.7, new Complex(0.7, 0.0));
		Complex zJulia = new Complex(0.0, -0.5);
		BooleanExpression stopCriterion = OR(new IGreaterThan(700), new AbsGreaterThan(2.616417));
		Effect effect = IF(new IGreaterThan(700),
				new ConstantColor(0x003300),
				new IterationPalette(Palette.PALETTE_109, Palette.PALETTE_109.getNbColors(), 0.0, false)
		);
		ApplyTestOrder order = ApplyTestOrder.FIRST_APPLY_THEN_TEST;

		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(0.0, 6.935E-10);
		double xSemiLength = 1.5 * U;
		double ySemiLength = U;
		double rotationAngle = 0.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle);

		return new Image(colorAlgo, mathZone);
	}
}
