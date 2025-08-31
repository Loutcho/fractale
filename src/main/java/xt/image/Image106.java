package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import java.util.function.Function;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Effect;
import xt.coloralgo.effect.IterationGradient;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 
 */
public class Image106 {

	private static final double U = 0.060;

	public static Image get() {
		
		Function<Complex, Complex> function = new xt.function.F42();
		Complex zJulia = new Complex(2.105, 0.568);
		BooleanExpression stopCriterion = OR(new IGreaterThan(3000), new AbsGreaterThan(2.92)); 
		Effect effect = IF(new IGreaterThan(3000),
				new ConstantColor(0x000000),
				new IterationGradient(0.20, 15.0)
			);
		ApplyTestOrder order = ApplyTestOrder.FIRST_APPLY_THEN_TEST;
		
		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(-0.926, +0.926);
		double xSemiLength = 1.5 * U;
		double ySemiLength = U;
		double rotationAngle = Math.PI / 4.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle); 
		
		return new Image(colorAlgo, mathZone);	
	}
}
