package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.RealGrayColorFunction;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 77) Distance de 0 à z en évitant le mur circulaire x^2 + y^2 = 1 percé en 1 ; niveaux de gris.
 */
public class Image077 {
	public static Image get() {
		return new Image(new DomainColoring(new xt.function.F23(), new RealGrayColorFunction(Math.PI / 2.0)),
				new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		);
	}
}
