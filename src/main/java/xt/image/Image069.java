package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction4;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 69) Marelle II
 */
public class Image069 {
	public static Image get() {
		return new Image(new DomainColoring(new xt.function.F15(), new ColorFunction4()),
				new MathZone(new Complex(0.0, 13.0), 27.0, 18.0, 0.0)
		);
	}
}
