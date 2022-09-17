package xt.fractale;

import java.awt.Color;

import xt.coloralgo.ColorAlgo;
import xt.coloralgo.DomainColoring;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.AbsArgGradient;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.ArgGradient;
import xt.coloralgo.effect.ArgGrid;
import xt.coloralgo.effect.ArgPeriodicity;
import xt.coloralgo.effect.Bubble;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.ImaginaryPartGrid;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPeriodicity;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Min;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.coloralgo.effect.RealPartGrid;
import xt.coloralgo.effect.ColorFunction1;
import xt.coloralgo.stopcriterion.AbsGreaterThan;
import xt.coloralgo.stopcriterion.AbsLessThan;
import xt.math.Complex;

public class Image {

	private ColorAlgo colorAlgo;
	private MathZone mathZone;
	
	public Image(ColorAlgo colorAlgo, MathZone mathZone) {
		this.colorAlgo = colorAlgo;
		this.mathZone = mathZone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new Image(");
		builder.append(colorAlgo);
		builder.append(", ");
		builder.append(mathZone);
		builder.append(")");
		return builder.toString();
	}
	
	public ColorAlgo getColorAlgo() {
		return colorAlgo;
	}

	public MathZone getMathZone() {
		return mathZone;
	}
	
	private static final int numLastImage = 42;
	public static final Image[] IMAGE = new Image[1 + numLastImage];
	
	static {
		/*
		 * 0) L'ensemble de Mandelbrot
		 */
		IMAGE[0] = new Image(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 256, true, new AbsGreaterThan(2.0), Color.BLACK,
						new IterationPeriodicity(Palette.PALETTE_000, 40.0, 0.95)
				),
				new MathZone(new Complex(-0.7, 0.0), 1.725, 1.150, 0.0)
		);

		/*
		 * 1) Propagation
		 */
		IMAGE[1] = new Image(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 120, true, new AbsGreaterThan(2.0), Color.BLACK,
						new Mul(
								new IterationPeriodicity(Palette.PALETTE_001, 55.0, 0.65),
								new AbsArgGradient()
						)
				),
				new MathZone(new Complex(-1.76208912, -0.01550358), 1.95E-7, 1.30E-7, 0.0)
		);
		
		/*
		 * 2) Courbevoie
		 */
		IMAGE[2] = new Image(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, true, new AbsGreaterThan(2.0), Color.WHITE,
						new IterationPeriodicity(Palette.PALETTE_002, 384.0, 0.333333333)
				),
				new MathZone(new Complex(0.364480, 0.315382), 6E-6, 4E-6, 0.0)
		);
		
		/*
		 * 3) Fegatello
		 */
		IMAGE[3] = new Image(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, true, new AbsGreaterThan(2.0), Color.WHITE,
						new Pow(1.5,
								new IterationPeriodicity(Palette.PALETTE_003, 48.0, 0.0)
						)
				),
				new MathZone(new Complex(-1.749798494, 0.000032655), 0.000000150, 0.000000100, 0.0)
		);
		
		/*
		 * 4) Chenille
		 */
		IMAGE[4] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), null, 15000, true, new AbsGreaterThan(2.0), Color.WHITE,
							new IterationPeriodicity(Palette.PALETTE_004, 226.0, 0.50)
					),
					new MathZone(new Complex(-1.250314, 0.01376), 0.000111, 0.000075, - Math.PI / 12.0)
		);

		/*
		 * 5) Bouclier cérébral
		 */
		IMAGE[5] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), new Complex(-0.0369, 0.2856), 3500, true, new AbsGreaterThan(2.0), Color.WHITE,
							new IterationPeriodicity(Palette.PALETTE_005, 28.73, 5.0 / 6.0)
					),
					new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0)
		);
		
		/*
		 * 6) Vaisseau alien
		 */
		IMAGE[6] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, true, new AbsGreaterThan(2.0), Color.WHITE,
							new IterationPeriodicity(Palette.PALETTE_006, 100.0, 0.95)
					),
					new MathZone(new Complex(0.0, 1.237), 0.0192, 0.0128, 0.0)
		);
		
		/*
		 * 7) Vitrail de conques
		 */
		IMAGE[7] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), null, 2000, true, new AbsGreaterThan(2.0), Color.WHITE,
							new Pow(0.7,
									new Mul(
											new IterationPeriodicity(Palette.PALETTE_007, 14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
											new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
											new IterationGradient(0.004, 115.0)
									)
							)
					),
					new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0)
		);
		
		/*
		 * 8) Nimbocumulus
		 */
		IMAGE[8] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), new Complex(-1.749272, -2.16E-4), 3000, true, new AbsGreaterThan(2.0), Color.WHITE,
							new IterationPeriodicity(Palette.PALETTE_008, 50.0, 0.5)
					), 
					new MathZone(new Complex(0.0, 0.0), 0.150, 0.100, Math.PI / 2.0)
		);
		
		/*
		 * 9) Obsession
		 */
		IMAGE[9] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F4(), new Complex(0.7639, 0.3125), 3000, true, new AbsGreaterThan(2.0), Color.BLACK,
							new Pow(0.4,
									new Mul(
											new IterationPeriodicity(Palette.PALETTE_009, 33.0, 0.0),
											new IterationGradient(0.015, 0),
											new AbsGradient1(0.85, 1.0, 1.0)
									)
							)
					),
					new MathZone(new Complex(0.595, -0.190), 0.45, 0.30, 0.0)
		);
		
		/*
		 * 10) Délire hallucinatoire
		 */
		IMAGE[10] = new Image(
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
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);

		/*
		 * 11) Parure d'améthystes
		 */
		IMAGE[11] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Sylvestre(), new Complex(-0.9568, -0.7992), 1000, true, new AbsGreaterThan(2.0), Color.BLACK,
							new Pow(0.7,
									new IterationPeriodicity(Palette.PALETTE_011, 84.0, 0.7)
							)
					),
					new MathZone(new Complex(-0.44, 0.0), 1.2, 0.8, Math.PI / 2.0)
		);
		
		/*
		 * 12) Papillon
		 */
		IMAGE[12] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Papillon(), new Complex(0.3472, 0.1172), 200, true, new AbsGreaterThan(2.0), Color.BLACK,
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
					new MathZone(new Complex(0.160, -0.230), 0.585, 0.390, - 0.72)
		);

		/*
		 * 13) Syracuse
		 */
		IMAGE[13] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Collatz(), new Complex(0, 0), 1000, true, new AbsGreaterThan(40.0), Color.BLACK, 
							new Mul(
									new IterationPeriodicity(Palette.PALETTE_013, 8.0, 0.0),
									new ArgPeriodicity(Palette.PALETTE_013, 0.5, 0.333)
							)
					),
					new MathZone(new Complex(-0.39962, 0.27487), 0.0018, 0.0012, 0.21)
		);

		/*
		 * 14) Fortifications
		 */
		IMAGE[14] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), new Complex(-0.5429, 0.1839), 3500, false, new AbsGreaterThan(2.0), Color.WHITE,
							new Max(
									new IterationPeriodicity(Palette.PALETTE_014, 40.0, 0.15),
									new ImaginaryPartGrid(0.2, 1.0, 1.0, 0.8),
									new RealPartGrid(0.2, 0.2, 0.2, 0.8)
							)
					),
					new MathZone(new Complex(0.0, 0.4655), 0.0039, 0.0026, Math.PI)
		);

		/*
		 * 15) Rayonnement solaire
		 */
		IMAGE[15] = new Image(
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
					new MathZone(new Complex(0.0, 0.0), 1.95, 1.30, 0.0)
		);
		
		/*
		 * 16) Hiroshima
		 */
		IMAGE[16] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Hiroshima(), null, 16000, false, new AbsGreaterThan(200.0), Color.BLACK,
							new ConstantColor(1.0, 0.0, 0.0)
					),
					new MathZone(new Complex(-1.10175, -0.71818), 0.00270, 0.00180, 0.56)
		);
		
		/*
		 * 17) Quatorze Juillet
		 */
		IMAGE[17] = new Image(
					new EscapeTimeAlgorithm(
						new xt.function.QuatorzeJuillet(), new Complex(0.0, 1.8), 100, false, new AbsGreaterThan(2.0), Color.BLACK,
						new Mul(
							new ArgPeriodicity(Palette.PALETTE_017, 1.0, 1.0 / 12.0),
							new IterationGradient(0.05, 0.0)
						)
					),
					new MathZone(new Complex(0.0, 0.24), 0.48, 0.32, 0.0)
		);
		
		/*
		 * 18) Composition florale
		 */
		IMAGE[18] = new Image(
					new EscapeTimeAlgorithm(
						new xt.function.Fleur(), new Complex(0.0, 0.0), 7, false, new AbsGreaterThan(2E11), Color.BLACK,
						new IterationPeriodicity(Palette.PALETTE_018, 3.0)
					),
					new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0)
		);
		
		/*
		 * 19) Mélodies nacrées
		 */
		IMAGE[19] = new Image(
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
						new MathZone(new Complex(0.3032, 0.0222), 0.0036, 0.0024, 0.0)
		);

		/*
		 * 20) Aïe j'ai mal
		 */
		IMAGE[20] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.AieJAiMal(), null, 1000, true, new AbsGreaterThan(200.0), new Color(0x091A48),
							new Max(
								new Bubble(12.0, 0.0000000, 12.0, 0.3333333, 12.0, 0.6666666),
								new AbsGradient1(1.0, 1.0, 1.0),
								new ArgPeriodicity(Palette.PALETTE_020, 0.125)
							)
						),
						new MathZone(new Complex(-0.9, 2.4), 3.6, 2.4, 0.0)
		);
		
		/*
		 * 21) Lentille gravitationnelle
		 */
		IMAGE[21] = new Image(
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
						new MathZone(new Complex(0.0, 0.0), 2.70, 1.80, 1.5)
		);
		
		/*
		 * 22) Silhouette vampirique
		 */
		IMAGE[22] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.NidDeMonstres(), new Complex(-0.0090, 0.0385), 1000, true, new AbsGreaterThan(3E5), Color.BLACK,
							new Pow(0.8,
								new Max(
										new IterationPeriodicity(Palette.PALETTE_022, 66.0, 0.33),
										new ArgGradient(1.0, 0.80, 0.75)
								)
							)
						),
						new MathZone(new Complex(0.0, -0.15), 1.05, /* 0.70 */ 0.37, 0.0)
		);

		/*
		 * 23) Eclatement de paradis
		 */
		IMAGE[23] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.F7(), new Complex(0.1, 0.1), 1000, true, new AbsGreaterThan(2.4), Color.BLACK,
							new Max(
									new IterationPeriodicity(Palette.PALETTE_023, 3.0, 0.800000),
									new IterationPeriodicity(Palette.PALETTE_023, 4.0, 0.133333),
									new IterationPeriodicity(Palette.PALETTE_023, 5.0, 0.466666)
							)
							
						),
						new MathZone(new Complex(0.14, 0.35), 0.3, 0.2, 0.0)
		);
		
		/*
		 * 24) Stomoxe
		 */
		IMAGE[24] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.Stomoxe(), new Complex(0.0, 0.0), 1000, true, new AbsGreaterThan(1E12), Color.BLACK,
							new IterationPeriodicity(Palette.PALETTE_024, 15.0, 0.05)
						),
						new MathZone(new Complex(-0.95, 0.0), 1.65, 1.10, 0.0)
		);
		
		/*
		 * 25) Démonologie
		 */
		IMAGE[25] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.Demonologie(), null, 10000, true, new AbsGreaterThan(3.8), Color.BLACK,
							new Mul(
									new IterationPeriodicity(Palette.PALETTE_025, 7.0, 0.8),
									new Bubble(2.0, 0.5, 2.0, 0.0, 2.0, 0.5)
							)
						),
						new MathZone(new Complex(-0.23, 0.0), 1.5, 1.0, Math.PI / 2.0)
		);
		
		/*
		 * 26) Trop d'écran
		 */
		IMAGE[26] = new Image(
						new EscapeTimeAlgorithm(
							new xt.function.TropDEcran(), new Complex(0.0, 0.0), 10000, false, new AbsLessThan(0.25), Color.BLUE,
							new IterationPeriodicity(Palette.PALETTE_026, 4.0, 0.0)
						),
						new MathZone(new Complex(13.5, 21.5), 0.5, 0.5, 0.0)
		);
		

		
		/*
		 * 32) Bêtises de Cambrai
		 */
		IMAGE[32] = new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Collatz2(), new Complex(0.0, -0.0025), 2000, true, new AbsGreaterThan(1.75), Color.BLACK,
							new Mul(
									new IterationPeriodicity(Palette.PALETTE_032, 33.0),
									new Bubble(50.0, 0.0, 50.0, 0.2, 50.0, 1.0)
							)
					),
					new MathZone(new Complex(-0.00820, 0.00786), 0.0054, 0.0036, 0.4)
		);
		
		/*
		 * 33)  Color Function 1 - identité (= légende)
		 */
		IMAGE[33] = new Image(
					new DomainColoring(
							new xt.function.Identity(),
							new ColorFunction1()
					),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 34)  Color Function 1 - cosinus
		 */
		IMAGE[34] = new Image(
					new DomainColoring(new xt.function.Cos(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 35)  Color Function 1 - sinus
		 */
		IMAGE[35] = new Image(
					new DomainColoring(new xt.function.Sin(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 36)  Color Function 1 - tangente
		 */
		IMAGE[36] = new Image(
					new DomainColoring(new xt.function.Tan(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 37)  Color Function 1 - exponentielle
		 */
		IMAGE[37] = new Image(
					new DomainColoring(new xt.function.Exponential(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 38)  Color Function 1 - carré
		 */
		IMAGE[38] = new Image(
					new DomainColoring(new xt.function.ZPower(2), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 40)  Color Function 1 - fonction "Sylvestre" 
		 */
		IMAGE[40] = new Image(
					new DomainColoring(new xt.function.Sylvestre(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 41)  Color Function 1 - fonction "Papillon" 
		 */
		IMAGE[41] = new Image(
					new DomainColoring(new xt.function.Papillon(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
		
		/*
		 * 42)  Color Function 1 - fonction "NidDeMonstres" 
		 */
		IMAGE[42] = new Image(
					new DomainColoring(new xt.function.NidDeMonstres(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
		);
	}
}
