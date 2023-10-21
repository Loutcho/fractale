package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction2;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Color Function 2 - tangente
 */
public class Image048 {

	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.Tan(), new ColorFunction2(true, true, true)),
				new MathZone(new Complex(0.0, 0.0), Math.PI, Math.PI / 1.5, 0.0)
	);
	}
}
