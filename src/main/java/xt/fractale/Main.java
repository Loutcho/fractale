package xt.fractale;

import java.awt.Color;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.ImaginaryPartGrid;
import xt.coloralgo.effect.AbsArgGradient;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ArgPeriodicity;
import xt.coloralgo.effect.IterationPeriodicity;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.coloralgo.effect.RealPartGrid;
import xt.math.Complex;

public class Main {
	
	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;
	
	private static final String PATH = "C:\\Users\\Luc\\Desktop\\";

	public static void main(String[] args) {
		int choice = 19;
		// for(int choice = 1; choice <= 19; choice ++)
		switch (choice) {
		case  1: image001(); break;
		case  2: image002(); break;
		case  3: image003(); break;
		case  4: image004(); break;
		case  5: image005(); break;
		case  6: image006(); break;
		case  7: image007(); break;
		case  8: image008(); break;
		case  9: image009(); break;
		case 10: image010(); break;
		case 11: image011(); break;
		case 12: image012(); break;
		case 13: image013(); break;
		case 14: image014(); break;
		case 15: image015(); break;
		case 16: image016(); break;
		case 17: image017(); break;
		case 18: image018(); break;
		case 19: image019(); break;
		}
	}

	/*
	 * 1) Intestins
	 */
	private static void image001() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 120, true, 2.0, Color.BLACK, Palette.PALETTE_001,
						new Mul(
								new IterationPeriodicity(55.0, 0.65),
								new AbsArgGradient()
						)
				),
				new MathZone(new Complex(-1.76208912, -0.01550358), 1.95E-7, 1.30E-7, 0.0),
				PATH + "expo_001.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 2) Courbevoie
	 */
	private static void image002() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, true, 2.0, Color.WHITE, Palette.PALETTE_002,
						new IterationPeriodicity(384.0, 0.333333333)
				),
				new MathZone(new Complex(0.364480, 0.315382), 6E-6, 4E-6, 0.0),
				PATH + "expo_002.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 3) Fegatello
	 */
	private static void image003() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, true, 2.0, Color.WHITE, Palette.PALETTE_003,
						new Pow(1.5,
								new IterationPeriodicity(48.0, 0.0)
						)
				),
				new MathZone(new Complex(-1.749798494, 0.000032655), 0.000000150, 0.000000100, 0.0),
				PATH + "expo_003.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 4) Chenille
	 */
	private static void image004() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 15000, true, 2.0, Color.WHITE, Palette.PALETTE_004,
						new IterationPeriodicity(226.0, 0.50)
				),
				new MathZone(new Complex(-1.250314, 0.01376), 0.000111, 0.000075, - Math.PI / 12.0),
				PATH + "expo_004.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 5) Bouclier cérébral
	 */
	private static void image005() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.BurningShip(), new Complex(-0.03689236111111108, 0.28564453125), 3500, true, 2.0, Color.WHITE, Palette.PALETTE_005,
						new IterationPeriodicity(28.73, 5.0 / 6.0)
				),
				new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0),
				PATH + "expo_005.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 6) Vaisseau alien
	 */
	private static void image006() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, true, 2.0, Color.WHITE, Palette.PALETTE_006,
						new IterationPeriodicity(100.0, 0.95)
				),
				new MathZone(new Complex(0.0, 1.237), 0.0192, 0.0128, 0.0),
				PATH + "expo_006.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 7) Vitrail de conques
	 */
	private static void image007() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 2000, true, 2.0, Color.WHITE, Palette.PALETTE_007,
						new Pow(0.7,
								new Mul(
										new IterationPeriodicity(14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
										new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
										new IterationGradient(0.004, 115.0)
								)
						)
				),
				new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0),
				PATH + "expo_007.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 8) Nimbocumulus
	 */
	private static void image008() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), new Complex(-1.749272, -2.16E-4), 3000, true, 2.0, Color.WHITE, Palette.PALETTE_008,
						new IterationPeriodicity(50.0, 0.5)
				), 
				new MathZone(new Complex(0.0, 0.0), 0.150, 0.100, Math.PI / 2.0),
				PATH + "expo_008.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 9) Obsession
	 */
	private static void image009() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.F4(), new Complex(0.7638888888888888, 0.3125), 3000, true, 2.0, Color.BLACK, Palette.PALETTE_009,
						new Pow(0.4,
								new Mul(
										new IterationPeriodicity(33.0, 0.0),
										new IterationGradient(0.015, 0),
										new AbsGradient1(0.85, 1.0, 1.0)
								)
						)
				),
				new MathZone(new Complex(0.595, -0.190), 0.45, 0.30, 0.0),
				PATH + "expo_009.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 10) Délire hallucinatoire
	 */
	private static void image010() {
		new ImageFile(
				new DomainColoring(
						new xt.function.F2(), Palette.PALETTE_010,
						new Pow(0.5,
								new Mul(
										new ArgPeriodicity(0.5),
										new Max(
												new RealPartGrid(0.05, 1.0, 1.0, 1.0),
												new ImaginaryPartGrid(0.05, 1.0, 1.0, 1.0)
										)
								)
						)
				),
				new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0),
				PATH + "expo_010.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 11) Parure d'améthystes
	 */
	private static void image011() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(), new Complex(-0.9567547344519107, -0.7992297832788293), 1000, true, 2.0, Color.BLACK, Palette.PALETTE_011,
						new Pow(0.7,
								new IterationPeriodicity(84.0, 0.7)
						)
				),
				new MathZone(new Complex(-0.44, 0.0), 1.2, 0.8, Math.PI / 2.0),
				PATH + "expo_011.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 12) Papillon
	 */
	private static void image012() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.Papillon(), new Complex(0.34722222222222215, 0.1171875), 200, true, 2.0, Color.BLACK, Palette.PALETTE_012,
						new Pow(0.7,
								new Mul(
										new IterationPeriodicity(8.0, 0.1),
										new Max(
												new ArgGrid(6, 1.0),
												new ArgPeriodicity(1.0)
										)
								)
						)
				),
				new MathZone(new Complex(0.160, -0.230), 0.585, 0.390, - 0.72),
				PATH + "expo_012.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 13) Syracuse
	 */
	private static void image013() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.Collatz(), new Complex(0, 0), 1000, true, 40.0, Color.BLACK, Palette.PALETTE_013,
						new Mul(
								new IterationPeriodicity(8.0, 0.0),
								new ArgPeriodicity(0.5, 0.333)
						)
				),
				new MathZone(new Complex(-0.39962, 0.27487), 0.0018, 0.0012, 0.21),
				PATH + "expo_013.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 14) Fortification à la Vauban
	 */
	private static void image014() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.BurningShip(), new Complex(-0.5429, 0.1839), 3500, false, 2.0, Color.WHITE, Palette.PALETTE_014,
						new Max(
								new IterationPeriodicity(40.0, 0.15),
								new ImaginaryPartGrid(0.2, 1.0, 1.0, 0.8),
								new RealPartGrid(0.2, 0.2, 0.2, 0.8)
						)
				),
				new MathZone(new Complex(0.0, 0.4655), 0.0039, 0.0026, Math.PI),
				PATH + "expo_014.png",
				DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 15) Rayonnement solaire
	 */
	private static void image015() {
		new ImageFile(
				new DomainColoring(
						new xt.function.F5(), Palette.PALETTE_015,
						new Max(
								new ArgPeriodicity(0.5),
								new Min(
										new RealPartGrid(0.2, 1.0, 1.0, 1.0),
										new ImaginaryPartGrid(0.2, 1.0, 1.0, 1.0)
								)
						)
				),
				new MathZone(new Complex(0.0, 0.0), 1.95, 1.30, 0.0),
				PATH + "expo_015.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 16) Hiroshima
	 */
	private static void image016() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.Hiroshima(), null, 16000, false, 200.0, Color.BLACK, Palette.PALETTE_016,
						new ConstantColor(1.0, 0.0, 0.0)
				),
				new MathZone(new Complex(-1.10175, -0.71818), 0.00270, 0.00180, 0.56),
				PATH + "expo_016.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 17) Quatorze Juillet
	 */
	private static void image017() {
		new ImageFile(
				new EscapeTimeAlgorithm(
					new xt.function.QuatorzeJuillet(), new Complex(0.0, 1.8), 100, false, 2.0, Color.BLACK, Palette.PALETTE_017,
					new Mul(
						new ArgPeriodicity(1.0, 1.0 / 12.0),
						new IterationGradient(0.05, 0.0)
					)
				),
				new MathZone(new Complex(0.0, 0.24), 0.48, 0.32, 0.0),
				PATH + "expo_017.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 18) Composition florale
	 */
	private static void image018() {
		new ImageFile(
				new EscapeTimeAlgorithm(
					new xt.function.Fleur(), new Complex(0.0, 0.0), 7, false, 2.0E11, Color.BLACK, Palette.PALETTE_018,
					new IterationPeriodicity(3.0)
				),
				new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0),
				PATH + "expo_018.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 19) 
	 */
	private static void image019() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 10000, true, 20.0, Color.BLACK, Palette.PALETTE_019,
						new Max(
							new Mul(
									new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666),
									new Bubble(12.0, 0.6666666, 12.0, 0.0000000, 12.0, 0.3333333)
							),
							new Max(
								new AbsGradient1(1.0, 1.0, 1.0),
								new ArgPeriodicity(0.125)
							)
						)
					),
					new MathZone(new Complex(0.3032, 0.0222), 0.0036, 0.0024, 0.0),
					PATH + "expo_019.png",
					DIMENSION_X, DIMENSION_Y).create();
		}
}
