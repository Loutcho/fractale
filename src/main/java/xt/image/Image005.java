package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

/**
 * Bouclier cérébral
 */
public class Image005 {

	public static Image get() {
		return new Image(new EscapeTimeAlgorithm(new xt.function.BurningShip(), new Complex(-0.0369, 0.2856),
				OR(new IGreaterThan(3500), new AbsGreaterThan(2.0)),
				IF(new IGreaterThan(3500), new ConstantColor(1.0, 1.0, 1.0),
						new IterationPalette(Palette.PALETTE_005, 28.73, 5.0 / 6.0, true)),
				ApplyTestOrder.FIRST_APPLY_THEN_TEST), new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0));
	}
}
