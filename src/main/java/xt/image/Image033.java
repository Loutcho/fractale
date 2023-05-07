package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction1;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Color Function 1 - identité (= légende)
 */
public class Image033 {

	public static Image get() {
		return new Image(new DomainColoring(new xt.function.Identity(), new ColorFunction1()),
				new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0));
	}
}
