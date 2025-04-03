package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction3;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 54) Domain Coloring, pas très joli mais pédagogique : doublement d'angle
 */
public class Image054 {

	public static Image get() {
		return new Image(
				new DomainColoring(
						new xt.function.F9(),
						new ColorFunction3()
				),
				new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0));
	}
}
