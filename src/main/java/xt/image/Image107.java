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

/*
 * Couleurs d'automne
 */
public class Image107 {

	private static final double U = 0.33;

	public static Image get() {
		
		Function<Complex, Complex> function = new xt.function.F26();
		Complex zJulia = new Complex(-0.5936419, -0.46279835);
		BooleanExpression stopCriterion = OR(new IGreaterThan(3000), new AbsGreaterThan(1.008)); 
		Effect effect = IF(new IGreaterThan(3000),
				new ConstantColor(0x000000),
				new IterationPalette(Palette.PALETTE_107, 9.0, 0.25, true)
			);
		ApplyTestOrder order = ApplyTestOrder.FIRST_APPLY_THEN_TEST;
		
		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(0.5, 0.0);
		double xSemiLength = 1.5 * U;
		double ySemiLength = U;
		double rotationAngle = 0.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle); 
		
		return new Image(colorAlgo, mathZone);	
	}
}
