package xt.image;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.AbsPalette;
import xt.coloralgo.effect.ArgPalette;
import xt.coloralgo.effect.Donut;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Donut
 */
public class Image089 {

	public static Image get() {
		return new Image(
				new DomainColoring(new xt.function.Identity(),
						new Mul(
							new Donut(0.7, 2.2, 2.0, 2.0, 2.0),
							new Max(
								new ArgPalette(Palette.PALETTE_089, 1.0, 0.333),
								new AbsPalette(Palette.PALETTE_089, 1.6, 0.333)
							)
						)
					),
					new MathZone(new Complex(0.0, 0.0), 3.6, 2.4, 0.0)
				);
	}
}
