package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction0;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 61) Lettre J
 */
public class Image061 {
	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.J(), new ColorFunction0(0.0)),
				new MathZone(new Complex(0.0, 1.0), 6.0, 4.0, 0.0)
		);
	}
}
