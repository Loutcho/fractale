package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.effect.ColorFunction5;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Max;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Surnombre
 */
public class Image084 {

	public static Image get() {
		return new Image(
				new DomainColoring(
						new xt.function.Identity(),
						new Max(
								new ColorFunction5(),
								new GridRe(0.1, 1.0, 0.0, 0.0),
								new GridIm(0.1, 0.0, 1.0, 0.0)
						)
				),
				new MathZone(new Complex(0.0, 0.0), 3.6, 2.4, 0.0)
		);
	}
}
