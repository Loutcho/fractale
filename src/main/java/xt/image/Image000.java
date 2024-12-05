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
 * L'ensemble de Mandelbrot
 */
public class Image000 {

	public static Image RECIPE =
		new Image(new EscapeTimeAlgorithm(new xt.function.ZPower(2), null,
				OR(new IGreaterThan(256), new AbsGreaterThan(2.0)),
				IF(new IGreaterThan(256), new ConstantColor(0.0, 0.0, 0.0),
						new IterationPalette(Palette.PALETTE_000, 40.0, 0.0, true)),
				ApplyTestOrder.FIRST_TEST_THEN_APPLY), new MathZone(new Complex(-0.7, 0.0), 1.725, 1.150, 0.0));
}
