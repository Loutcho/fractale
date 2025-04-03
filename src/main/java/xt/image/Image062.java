package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction0;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 62) Lettre B
 */
public class Image062 {
	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.B(), new ColorFunction0(0.0)),
				new MathZone(new Complex(1.0, 2.0), 6.0, 4.0, 0.0)
		);
	}
}
