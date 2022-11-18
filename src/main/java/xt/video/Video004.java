package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;

public class Video004 {

	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;

	private static String PATH = System.getenv("FRACTALE_HOME");

	/*
	 * Transformation du "bouclier cérébral" en "fortifications" 
	 * 500 images pour une video
	 */
	public static void main(String[] args) {

		Complex c1 = new Complex(-0.03689236111111108, 0.28564453125);
		Complex c2 = new Complex(-0.5429, 0.1839);
		int i = 0;
		while (i < 50) {
			System.out.println("----- " + i);
			double t = (double) (i - 50) / 50.0;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), c1,
							OR(
									new IGreaterThan(3500),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(3500),
									new ConstantColor(1.0, 1.0, 1.0),
									new IterationPalette(new Palette(0x000000, 0xFFFFFF, 0x007700), 28.73, 5.0 / 6.0 + t, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0)),
					PATH + String.format("frames\\frame_004_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			i ++;
		}
		while (i < 450) {
			System.out.println("----- " + i);
			double t = (double) (i - 50) / (double) 400.0;
			double s = 1.0 - t;
			Complex c = Complex.add(Complex.mul(s, c1), Complex.mul(t, c2));
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), c,
							OR(
									new IGreaterThan(3500),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(3500),
									new ConstantColor(1.0, 1.0, 1.0),
									new Max(
											new IterationPalette(new Palette(0x000000, 0xFFFFFF, ((int) (t * 0xFF)) << 2), s * 28.73 + t * 40.0, s * 5.0 / 6.0 + t * 0.15, true),
											new Min(
													new ConstantColor(t, t, t),
													new GridIm(0.2, 1.0, 1.0, 0.8),
													new GridRe(0.2, 0.2, 0.2, 0.8)											
											)
									)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0, s * 0.58 + t * 0.4655), s * 0.225 + t * 0.0039, s * 0.150 + t * 0.0026, s * 0.0 + t * Math.PI)),
					PATH + String.format("frames\\frame_004_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			i ++;
		}
		while (i < 500) {
			System.out.println("----- " + i);
			double t = (double) (i - 450) / 50.0;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), c2,
							OR(
									new IGreaterThan(3500),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(3500),
									new ConstantColor(1.0, 1.0, 1.0),
									new Max(
											new IterationPalette(new Palette(0x000000, 0xFFFFFF, 0xFF0000), 40.0, 0.15 + t, true),
											new Min(
													new GridIm(0.2, 1.0, 1.0, 0.8),
													new GridRe(0.2, 0.2, 0.2, 0.8)											
											)
									)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0, 0.4655), 0.0039, 0.0026, Math.PI)),
					PATH + String.format("frames\\frame_004_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			i ++;
		}
	}
}
