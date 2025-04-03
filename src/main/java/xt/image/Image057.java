package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.AbsPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 57) Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
 */
public class Image057 {
	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.F11(), new AbsPalette(Palette.PALETTE_056, 4.0, 0.0)),
				new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		);
	}
}
