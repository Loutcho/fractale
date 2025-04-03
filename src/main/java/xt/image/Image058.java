package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.AbsPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/*
 * 58) Version non discrétisée du 57
 */
public class Image058 {
	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.Identity(), new AbsPalette(Palette.PALETTE_056, 4.0, 0.0)),
				new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		);
	}
}
