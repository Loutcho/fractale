package xt.image;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.booleanexpression.EuclidStopCriterion;
import xt.coloralgo.effect.EuclidColorFunction;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * Algorithme d'Euclide en polaires
 */
public class Image075 {
	public static Image get() {
		return new Image(
				new EscapeTimeAlgorithm(
						new xt.function.EuclidFunction(), new Complex(0.0, 0.0),
						new EuclidStopCriterion(),
						new EuclidColorFunction(),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-100.0, 40.0), 180.0, 120.0, 0.0)
		);
	}
}
