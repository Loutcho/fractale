package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import java.util.function.Function;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Effect;
import xt.coloralgo.effect.IterationPalette;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video011 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Video pour Sophie
	 * Zoom sur une mandelbox (image 109)
	 */

	private static double U_MAX = 1.667E+13;
	private static double U_MIN = 6.272E-10;
	private static int N = 999;
	private static double U_0 = U_MAX;
	private static double U_N = U_MIN;
	private static double LAMBDA = U_MAX;
	private static double K = Math.log(U_0 / U_N) / N;
	
	public static void main(String[] args) {
		for (int i = 0; i <= N; i ++) {
			System.out.println("----- " + i);
			double t = (double) i;
			double u = LAMBDA * Math.exp(- K * t);
			new ImageFile(
					getImage(u),
					PATH + String.format("frames\\frame_011_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}

	private static Image getImage(double u) {
		Function<Complex, Complex> function = new xt.function.Mandelbox(new Complex(-1.7, 0.0), 0.7, new Complex(0.7, 0.0));
		Complex zJulia = new Complex(0.0, -0.5);
		BooleanExpression stopCriterion = OR(new IGreaterThan(200), new AbsGreaterThan(2.616417));
		Effect effect = IF(new IGreaterThan(200),
				new ConstantColor(0x003300),
				new IterationPalette(Palette.PALETTE_109, Palette.PALETTE_109.getNbColors(), 0.0, false)
		);
		ApplyTestOrder order = ApplyTestOrder.FIRST_APPLY_THEN_TEST;

		ColorAlgo colorAlgo = new EscapeTimeAlgorithm(function, zJulia, stopCriterion, effect, order);

		Complex center = new Complex(0.0, 6.935E-10);
		double xSemiLength = 1.5 * u;
		double ySemiLength = u;
		double rotationAngle = 0.0;
		MathZone mathZone = new MathZone(center, xSemiLength, ySemiLength, rotationAngle);

		return new Image(colorAlgo, mathZone);
	}
}
