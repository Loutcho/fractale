package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction3;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 53) Domain Coloring, Color Function 3 - identité
 */
public class Image053 {

	public static Image get() {
		return new Image(
				new DomainColoring(
						new xt.function.Identity(),
						new ColorFunction3()
				),
				new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0));
	}
}
