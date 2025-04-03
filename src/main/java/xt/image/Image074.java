package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.EuclidColorFunction;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 74) Color function adaptée à l'algorithme d'Euclide en polaires, cf. Image075) 
 */
public class Image074 {
	public static Image get() {
		return new Image(new DomainColoring(new xt.function.EuclidFunction(), new EuclidColorFunction()),
				new MathZone(new Complex(0.0, 0.0), 60.0, 40.0, 0.0)
		);
	}
}
