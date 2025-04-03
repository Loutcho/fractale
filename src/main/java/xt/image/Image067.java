package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction1;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 67) Marelle
 */
public class Image067 {
	public static Image get() {
		return new Image(new DomainColoring(new xt.function.F15(), new ColorFunction1()),
				new MathZone(new Complex(0.0, 16.0), 27.0, 18.0, 0.0)
		);
	}
}
