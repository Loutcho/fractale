package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction2;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Color Function 2 - fonction "Sylvestre" 
 */
public class Image049 {

	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.Sylvestre(1, 0.0), new ColorFunction2(true, true, true)),
				new MathZone(new Complex(0.0, 0.0), 7.5, 5.0, 0.0)
	);
	}
}
