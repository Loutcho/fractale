package xt.fractale;

import java.awt.Color;
import java.util.function.Predicate;

import xt.coloralgo.DomainColoring;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.ImaginaryPartGrid;
import xt.coloralgo.effect.AbsArgGradient;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.ArgGradient;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ArgPeriodicity;
import xt.coloralgo.effect.IterationPeriodicity;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.coloralgo.effect.RealPartGrid;
import xt.coloralgo.stopcriterion.AbsGreaterThan;
import xt.coloralgo.stopcriterion.AbsLessThan;
import xt.math.Complex;

public class Main {
	
	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;
	
	private static String PATH = System.getenv("FRACTALE_HOME");

	private static final Predicate<Complex> ABS_GREATER_THAN_2 = new AbsGreaterThan(2.0);
	
	public static void main(String[] args) {
		int choice = 29;
		// for(int choice = 1; choice <= 29; choice ++)
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
		case 20: image020(); break;
		case 21: image021(); break;
		case 22: image022(); break;
		case 23: image023(); break;
		case 24: image024(); break;
		case 25: image025(); break;
		case 26: image026(); break;
		case 27: image027(); break;
		case 28: image028(); break;
		case 29: image029(); break;
		}
	}

	/*
	 * 1) Intestins
	 */
	private static void image001() {
		new ImageFile(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 120, true, ABS_GREATER_THAN_2, Color.BLACK,
						new Mul(
								new IterationPeriodicity(Palette.PALETTE_001, 55.0, 0.65),
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
						new xt.function.ZPower(2), null, 5000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_002, 384.0, 0.333333333)
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
						new xt.function.ZPower(2), null, 5000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new Pow(1.5,
								new IterationPeriodicity(Palette.PALETTE_003, 48.0, 0.0)
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
						new xt.function.ZPower(2), null, 15000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_004, 226.0, 0.50)
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
						new xt.function.BurningShip(), new Complex(-0.03689236111111108, 0.28564453125), 3500, true, ABS_GREATER_THAN_2, Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_005, 28.73, 5.0 / 6.0)
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
						new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_006, 100.0, 0.95)
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
						new xt.function.ZPower(2), null, 2000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new Pow(0.7,
								new Mul(
										new IterationPeriodicity(Palette.PALETTE_007, 14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
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
						new xt.function.ZPower(2), new Complex(-1.749272, -2.16E-4), 3000, true, ABS_GREATER_THAN_2, Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_008, 50.0, 0.5)
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
						new xt.function.F4(), new Complex(0.7638888888888888, 0.3125), 3000, true, ABS_GREATER_THAN_2, Color.BLACK,
						new Pow(0.4,
								new Mul(
										new IterationPeriodicity(Palette.PALETTE_009, 33.0, 0.0),
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
						new xt.function.F2(),
						new Pow(0.5,
								new Mul(
										new ArgPeriodicity(Palette.PALETTE_010, 0.5),
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
						new xt.function.Sylvestre(), new Complex(-0.9567547344519107, -0.7992297832788293), 1000, true, ABS_GREATER_THAN_2, Color.BLACK,
						new Pow(0.7,
								new IterationPeriodicity(Palette.PALETTE_011, 84.0, 0.7)
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
						new xt.function.Papillon(), new Complex(0.34722222222222215, 0.1171875), 200, true, ABS_GREATER_THAN_2, Color.BLACK,
						new Pow(0.7,
								new Mul(
										new IterationPeriodicity(Palette.PALETTE_012, 8.0, 0.1),
										new Max(
												new ArgGrid(6, 1.0),
												new ArgPeriodicity(Palette.PALETTE_012, 1.0)
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
						new xt.function.Collatz(), new Complex(0, 0), 1000, true, new AbsGreaterThan(40.0), Color.BLACK, 
						new Mul(
								new IterationPeriodicity(Palette.PALETTE_013, 8.0, 0.0),
								new ArgPeriodicity(Palette.PALETTE_013, 0.5, 0.333)
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
						new xt.function.BurningShip(), new Complex(-0.5429, 0.1839), 3500, false, ABS_GREATER_THAN_2, Color.WHITE,
						new Max(
								new IterationPeriodicity(Palette.PALETTE_014, 40.0, 0.15),
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
						new xt.function.F5(),
						new Max(
								new ArgPeriodicity(Palette.PALETTE_015, 0.5),
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
						new xt.function.Hiroshima(), null, 16000, false, new AbsGreaterThan(200.0), Color.BLACK,
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
					new xt.function.QuatorzeJuillet(), new Complex(0.0, 1.8), 100, false, ABS_GREATER_THAN_2, Color.BLACK,
					new Mul(
						new ArgPeriodicity(Palette.PALETTE_017, 1.0, 1.0 / 12.0),
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
					new xt.function.Fleur(), new Complex(0.0, 0.0), 7, false, new AbsGreaterThan(2E11), Color.BLACK,
					new IterationPeriodicity(Palette.PALETTE_018, 3.0)
				),
				new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0),
				PATH + "expo_018.png",
				DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 19) Mélodies nacrées
	 */
	private static void image019() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 10000, true, new AbsGreaterThan(20.0), Color.BLACK,
						new Max(
							new Mul(
									new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666),
									new Bubble(12.0, 0.6666666, 12.0, 0.0000000, 12.0, 0.3333333)
							),
							new Max(
								new AbsGradient1(1.0, 1.0, 1.0),
								new ArgPeriodicity(Palette.PALETTE_019, 0.125)
							)
						)
					),
					new MathZone(new Complex(0.3032, 0.0222), 0.0036, 0.0024, 0.0),
					PATH + "expo_019.png",
					DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 20) Aïe j'ai mal
	 */
	private static void image020() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.AieJAiMal(), null, 1000, true, new AbsGreaterThan(200.0), new Color(0x091A48),
						new Max(
							new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666),
							new AbsGradient1(1.0, 1.0, 1.0),
							new ArgPeriodicity(Palette.PALETTE_020, 0.125)
						)
					),
					new MathZone(new Complex(-0.9, 2.4), 3.6, 2.4, 0.0),
					PATH + "expo_020.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 21) Lentille gravitationnelle
	 */
	private static void image021() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.F6(), new Complex(1.6, -0.1), 1000, true, new AbsGreaterThan(2.71), Color.BLACK,
						new Pow(0.5,
							new Mul(
								new IterationPeriodicity(Palette.PALETTE_021, 3.0),
								new Min(
										new RealPartGrid(0.3, 0.5, 1.0, 1.0),
										new ImaginaryPartGrid(0.3, 1.0, 1.0, 0.5)
								)
							)
						)
					),
					new MathZone(new Complex(0.0, 0.0), 2.70, 1.80, 1.5),
					PATH + "expo_021.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 22) Silhouette vampirique
	 */
	private static void image022() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.NidDeMonstres(), new Complex(-0.0090, 0.0385), 1000, true, new AbsGreaterThan(3E5), Color.BLACK,
						new Pow(0.8,
							new Max(
									new IterationPeriodicity(Palette.PALETTE_022, 66.0, 0.33),
									new ArgGradient(1.0, 0.80, 0.75)
							)
						)
					),
					new MathZone(new Complex(0.0, -0.15), 1.05, /* 0.70 */ 0.37, 0.0),
					PATH + "expo_022.png",
					DIMENSION_X, DIMENSION_Y).create();
	}

	/*
	 * 23) Eclatement de paradis
	 */
	private static void image023() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.F7(), new Complex(0.1, 0.1), 1000, true, new AbsGreaterThan(2.4), Color.BLACK,
						new Max(
								new IterationPeriodicity(Palette.PALETTE_023, 3.0, 0.800000),
								new IterationPeriodicity(Palette.PALETTE_023, 4.0, 0.133333),
								new IterationPeriodicity(Palette.PALETTE_023, 5.0, 0.466666)
						)
						
					),
					new MathZone(new Complex(0.14, 0.35), 0.3, 0.2, 0.0),
					PATH + "expo_023.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 24) Stomoxe
	 */
	private static void image024() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.Stomoxe(), new Complex(0.0, 0.0), 1000, true, new AbsGreaterThan(1E12), Color.BLACK,
						new IterationPeriodicity(Palette.PALETTE_024, 15.0, 0.05)
					),
					new MathZone(new Complex(-0.95, 0.0), 1.65, 1.10, 0.0),
					PATH + "expo_024.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 25) Démonologie
	 */
	private static void image025() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.Demonologie(), null, 10000, true, new AbsGreaterThan(3.8), Color.BLACK,
						new Mul(
								new IterationPeriodicity(Palette.PALETTE_025, 7.0, 0.8),
								new Bubble(2.0, 0.5, 2.0, 0.0, 2.0, 0.5)
						)
					),
					new MathZone(new Complex(-0.23, 0.0), 1.5, 1.0, Math.PI / 2.0),
					PATH + "expo_025.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 26) Trop d'écran
	 */
	private static void image026() {
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.TropDEcran(), new Complex(0.0, 0.0), 10000, false, new AbsLessThan(0.25), Color.BLUE,
						new IterationPeriodicity(Palette.PALETTE_026, 4.0, 0.0)
					),
					new MathZone(new Complex(13.5, 21.5), 0.5, 0.5, 0.0),
					PATH + "expo_026.png",
					DIMENSION_X, DIMENSION_Y).create();
	}
	
	/*
	 * 27) 100 images pour une video
	 */
	private static void image027() {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			double theta = i * 2.0 * Math.PI / n;
			double dx = 3E-2 * Math.cos(theta);
			double dy = 3E-2 * Math.sin(theta);
			new ImageFile(
					new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(), new Complex(-0.87 + dx, -0.90 + dy), 100, true, ABS_GREATER_THAN_2, Color.BLACK,
						new IterationPeriodicity(Palette.PALETTE_027, 100.0, 0.40)
					),
					new MathZone(new Complex(-0.38, 0.0), 1.35, 0.80, - Math.PI / 2.0),
					PATH + String.format("tmp\\expo_027_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 28) 100 images pour une video
	 */
	private static void image028() {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			System.out.println("----- " + i);
			double t = (double) i / (double) n;
			new ImageFile(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), null, 2000, true, ABS_GREATER_THAN_2, Color.WHITE,
							new Pow(0.6,
									new Mul(
											new IterationPeriodicity(Palette.PALETTE_007, 14.0, -t, 16.0, -2.0 * t, 20.0, -3.0 * t),
											new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
											new IterationGradient(0.004, 115.0)
									)
							)
					),
					new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0),
					PATH + String.format("tmp\\expo_028_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 29) 100 images pour une video
	 */
	private static void image029() {
		final double K = 5.628559053;
		int n = 100;
		for (int i = 0; i < n; i ++) {
			double t = (double) i / (double) n;
			System.out.println("----- " + i);
			double c = Math.exp(- K * t);
			new ImageFile(
					new EscapeTimeAlgorithm(
							new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, true, ABS_GREATER_THAN_2, Color.WHITE,
							new IterationPeriodicity(Palette.PALETTE_006, 100.0, 0.95 - 0.06 * t)
					),
					new MathZone(new Complex(0.0 - 0.0001 * t, 1.237 + 0.000339 * t), 0.0192 * c, 0.0128 * c, -1.18 * t),
					// new MathZone(new Complex(0.0, 1.237), 0.0192, 0.0128, 0.0) --> new MathZone(new Complex(-0.0001, 1.237339), 0.000069, 0.000046, -1.18),
					PATH + String.format("tmp\\expo_029_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
