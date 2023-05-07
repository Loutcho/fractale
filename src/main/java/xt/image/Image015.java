package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Rayonnement solaire
 */
public class Image015 {

	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.F5(),
						new Max(new ArgPalette(Palette.PALETTE_015, 0.5, 0.0),
								new Min(new GridRe(0.2, 1.0, 1.0, 1.0), new GridIm(0.2, 1.0, 1.0, 1.0)))),
				new MathZone(new Complex(0.0, 0.0), 1.95, 1.30, 0.0));
	}
}
