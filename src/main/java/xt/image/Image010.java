package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Délire hallucinatoire
 */
public class Image010 {

	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.F2(),
						new Mul(new ArgPalette(Palette.PALETTE_010, 0.5, 0.0),
								new Max(new GridRe(0.4, 1.0, 1.0, 1.0), new GridIm(0.4, 1.0, 1.0, 1.0)))),
				new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0));
	}
}
