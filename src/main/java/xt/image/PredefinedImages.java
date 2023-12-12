package xt.image;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import java.util.Map;
import java.util.TreeMap;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.DomainColoring;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.AbsLessThan;
import xt.coloralgo.booleanexpression.EuclidStopCriterion;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.booleanexpression.ReLessThan;
import xt.coloralgo.effect.*;
import xt.coloralgo.realexpression.Constant;
import xt.coloralgo.realexpression.Im;
import xt.coloralgo.realexpression.Re;
import xt.fractale.Image;
import xt.fractale.MathZone;
import xt.math.Complex;

public class PredefinedImages {

	private static final Map<Integer, Image> IMAGE = new TreeMap<>();

	static {
		IMAGE.put( 0, Image000.get()); // L'ensemble de Mandelbrot
		IMAGE.put( 1, Image001.get()); // Propagation
		IMAGE.put( 2, Image002.get()); // Courbevoie
		IMAGE.put( 3, Image003.get()); // Fegatello
		IMAGE.put( 4, Image004.get()); // Chenille
		IMAGE.put( 5, Image005.get()); // Bouclier cérébral
		IMAGE.put( 6, Image006.get()); // Vaisseau alien
		IMAGE.put( 7, Image007.get()); // Vitrail de conques
		IMAGE.put( 8, Image008.get()); // Nimbocumulus
		IMAGE.put( 9, Image009.get()); // Obsession
		IMAGE.put(10, Image010.get()); // Délire hallucinatoire
		IMAGE.put(11, Image011.get()); // Parure d'améthystes
		IMAGE.put(12, Image012.get()); // Papillon
		IMAGE.put(13, Image013.get()); // Syracuse
		IMAGE.put(14, Image014.get()); // Fortifications
		IMAGE.put(15, Image015.get()); // Rayonnement solaire
		IMAGE.put(16, Image016.get()); // Hiroshima
		IMAGE.put(17, Image017.get()); // Quatorze juillet
		IMAGE.put(18, Image018.get()); // Composition florale
		IMAGE.put(19, Image019.get()); // Mélodies nacrées
		IMAGE.put(20, Image020.get()); // Aïe j'ai mal
		IMAGE.put(21, Image021.get()); // Lentille gravitationnelle
		IMAGE.put(22, Image022.get()); // Silhouette vampirique
		IMAGE.put(23, Image023.get()); // Eclatement de paradis
		IMAGE.put(24, Image024.get()); // Stomoxe
		IMAGE.put(25, Image025.get()); // Démonologie
		IMAGE.put(26, Image026.get()); // Trop d'écran
		IMAGE.put(27, Image027.get()); // Eclipse de trou noir
		IMAGE.put(28, Image028.get()); // Comique et cosmique 
		IMAGE.put(29, Image029.get()); // Danseuses aux rubans 
		IMAGE.put(30, Image030.get()); // Chambre à bulles
		IMAGE.put(31, Image031.get()); // Calice de minuit treize
		IMAGE.put(32, Image032.get()); // Bêtises de Cambrai
		IMAGE.put(33, Image033.get()); // Color Function 1 - identité (= légende)
		IMAGE.put(34, Image034.get()); // Color Function 1 - cosinus
		IMAGE.put(35, Image035.get()); // Color Function 1 - sinus
		IMAGE.put(36, Image036.get()); // Color Function 1 - tangente
		IMAGE.put(37, Image037.get()); // Color Function 1 - exponentielle
		IMAGE.put(38, Image038.get()); // Color Function 1 - carré
		IMAGE.put(39, Image039.get()); // Pavage
		IMAGE.put(40, Image040.get()); // Color Function 1 - fonction "Sylvestre"
		IMAGE.put(41, Image041.get()); // Color Function 1 - fonction "Papillon"
		IMAGE.put(42, Image042.get()); // Color Function 1 - fonction "NidDeMonstres"
		IMAGE.put(43, Image043.get()); // Color Function 2 - identité 
		IMAGE.put(44, Image044.get()); // Color Function 2 - fonction z^3
		IMAGE.put(45, Image045.get()); // Color Function 2 - fonction exponentielle 
		IMAGE.put(46, Image046.get()); // Color Function 2 - cosinus
		IMAGE.put(47, Image047.get()); // Color Function 2 - sinus
		IMAGE.put(48, Image048.get()); // Color Function 2 - tangente
		IMAGE.put(49, Image049.get()); // Color Function 2 - fonction "Sylvestre" 
		IMAGE.put(50, Image050.get()); // Couronne de Pâques
		IMAGE.put(51, Image051.get()); // Tentacules
		IMAGE.put(52, Image052.get()); // Rubans et fourches

		/*
		 * 53) Domain Coloring, Color Function 3 - identité
		 */
		IMAGE.put(53, new Image(
					new DomainColoring(new xt.function.Identity(), new ColorFunction3()),
					new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		));
		
		/*
		 * 54) Domain Coloring, pas très joli mais pédagogique : doublement d'angle
		 */
		IMAGE.put(54, new Image(
					new DomainColoring(new xt.function.F9(), new ColorFunction3()),
					new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		));
		
		/*
		 * 55) Fractale, pas très jolie mais pédagogique : doublement d'angle
		 */
		IMAGE.put(55, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F9(), new Complex(0.0, 0.0),
							OR(
									new IGreaterThan(2000),
									new ReLessThan(0.0)
							),
							IF(
									new IGreaterThan(2000),
									new ConstantColor(0.0, 0.0, 0.0),
									new ColorFunction3()
							),
							ApplyTestOrder.FIRST_TEST_THEN_APPLY
					),
					new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		));
		
		/*
		 * 56) Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
		 */
		IMAGE.put(56, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F10(), new Complex(0.0, 0.0),
							OR(
									new IGreaterThan(2000),
									new AbsLessThan(1.0)
							),
							IF(
									new IGreaterThan(2000),
									new ConstantColor(0.0, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_056, 4.0, 0.0, false)
							),
							ApplyTestOrder.FIRST_TEST_THEN_APPLY
					),
					new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		));
		
		/*
		 * 57) Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
		 */
		IMAGE.put(57, new Image(
					new DomainColoring(new xt.function.F11(), new AbsPalette(Palette.PALETTE_056, 4.0, 0.0)),
					new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		));
		
		/*
		 * 58) Version non discrétisée du 57
		 */
		IMAGE.put(58, new Image(
					new DomainColoring(new xt.function.Identity(), new AbsPalette(Palette.PALETTE_056, 4.0, 0.0)),
					new MathZone(new Complex(0.0, 0.0), 30.0, 20.0, 0.0)
		));
		
		/*
		 * 59)
		 */
		IMAGE.put(59, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Sylvestre(1, 0.0), new Complex(-0.96873, -0.64454),
							OR(
									new IGreaterThan(1000),
									new AbsGreaterThan(1E4)
							),
							IF(
									new IGreaterThan(1000),
									new ConstantColor(0.0, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_059, 84.0, 0.7, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(-0.435, 0.000), 1.10, 0.72, - Math.PI / 2.0)
		));
		
		/*
		 * 60)
		 */
		IMAGE.put(60, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Sylvestre(2, 0.0), new Complex(-0.2241, -0.2049),
							OR(
									new IGreaterThan(1000),
									new AbsGreaterThan(1E5)
							),
							IF(
									new IGreaterThan(1000),
									new ConstantColor(0.0, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_060, 126.0, 0.7, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.04, 0.), 1.17, 0.56, Math.PI / 2.0)
		));
		
		/*
		 * 61) Lettre J
		 */
		IMAGE.put(61, new Image(
					new DomainColoring(new xt.function.J(), new ColorFunction0(0.0)),
					new MathZone(new Complex(0.0, 1.0), 6.0, 4.0, 0.0)
		));
		
		/*
		 * 62) Lettre B
		 */
		IMAGE.put(62, new Image(
					new DomainColoring(new xt.function.B(), new ColorFunction0(0.0)),
					new MathZone(new Complex(1.0, 2.0), 6.0, 4.0, 0.0)
		));
		
		/*
		 * 63)
		 */
		IMAGE.put(63, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Sylvestre(3, 0.0), new Complex(1.114, -0.128),
							OR(
									new IGreaterThan(1000),
									new AbsGreaterThan(1E5)
							),
							IF(
									new IGreaterThan(1000),
									new ConstantColor(0.0, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_063, 126.0, 0.7, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(1.17977, 0.24834), 0.01155, 0.00770, 0.0)
		));
		
		/*
		 * 64)
		 */
		IMAGE.put(64, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F12(), new Complex(-0.735, -0.046),
							OR(
									new IGreaterThan(2000),
									new AbsGreaterThan(2.0)
							),
							IF(
									new IGreaterThan(2000),
									new ConstantColor(0.0, 0.0, 0.0),
									new ColorFunction0(0.0)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.125, -0.100), 0.225, 0.150, 0.0)
		));
		
		/*
		 * 65) Des empreintes dans la neige
		 */
		IMAGE.put(65, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F13(), null,
							OR(
									new IGreaterThan(32000),
									new AbsGreaterThan(2.7)
							),
							IF(
									new IGreaterThan(32000),
									new ConstantColor(0.0, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_065, 30.91, 0.0, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(-0.674387, 0.002552), 6E-5, 4E-5, 0.0)
		));
		
		/*
		 * 66)
		 */
		IMAGE.put(66, new Image(
					new EscapeTimeAlgorithm(
							new xt.function.F14(), new Complex(0.0, 0.0),
							OR(
									new IGreaterThan(1000),
									new AbsGreaterThan(320.0)
							),
							IF(
									new IGreaterThan(1000),
									new ConstantColor(0.078, 0.0, 0.0),
									new IterationPalette(Palette.PALETTE_066, 32.0, 0.25, true)
							),
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(new Complex(0.0, 0.0), 6.6, 4.4, 0.0)
		));

		/*
		 * 67) Marelle
		 */
		IMAGE.put(67, new Image(new DomainColoring(new xt.function.F15(), new ColorFunction1()),
					new MathZone(new Complex(0.0, 16.0), 27.0, 18.0, 0.0)
		));
		
		/*
		 * 68) Mouche Toutankhamon
		 */
		IMAGE.put(68, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F16(), new Complex(0.0, 0.0),
								OR(
										new IGreaterThan(4000),
										new AbsLessThan(2.0)
								),
								IF(
										new IGreaterThan(4000),
										new ConstantColor(0.078, 0.0, 0.0),
										new Max(
												new ArgPalette(Palette.PALETTE_068, 1.0, 0.0),
												new Min(
														new GridRe(0.4, 1.0, 1.0, 0.95),
														new GridIm(0.4, 1.0, 1.0, 0.95)
												)
										)
								),
								ApplyTestOrder.FIRST_APPLY_THEN_TEST
						),
						new MathZone(new Complex(-3.2, 0.0), 4.2, 2.4, Math.PI / 2.0)
		));
		
		/*
		 * 69) Marelle
		 */
		IMAGE.put(69, new Image(new DomainColoring(new xt.function.F15(), new ColorFunction4()),
					new MathZone(new Complex(0.0, 13.0), 27.0, 18.0, 0.0)
		));
		
		/*
		 * 70) Disques 
		 */

		IMAGE.put(70, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F19(), new Complex(2.02777777777777777, 0.0),
								OR(
										new IGreaterThan(1000),
										new AbsGreaterThan(5.17)
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(0.0, 0.0, 0.0),
										new Mul(
												new IterationPalette(Palette.PALETTE_070, 4.0, 0.0, false),
												new FancyGradient002(5.17)
										)
								),
								ApplyTestOrder.FIRST_APPLY_THEN_TEST
						),
						new MathZone(new Complex(-1.660, 1.649), 1.5 * 0.0247, 0.0247, 0.0)
		));

		/*
		 * 71) Une nuit sur le Mont Chauve
		 */

		IMAGE.put(71, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F20(), new Complex(-0.815, -0.237),
								OR(
										new IGreaterThan(2000),
										new AbsGreaterThan(3.5)
								),
								IF(
										new IGreaterThan(2000),
										new ConstantColor(0.0, 0.0, 0.0),
										new IterationPalette(Palette.PALETTE_071, 20.0, -0.05, true)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(0.0, -0.54), 0.45, 0.30, 0.0)
		));

		/*
		 * 72) Mer agitée
		 */

		IMAGE.put(72, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F21(), new Complex(2.62, 0.43),
								OR(
										new IGreaterThan(1000),
										new GreaterThan(new Re(), new Constant(1000.0)),
										new GreaterThan(new Im(), new Constant(1000.0))
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(0.0, 0.0, 0.0),
										new Max(
											new IterationPalette(Palette.PALETTE_072, 16.0, 0.30, false),
											new IterationPalette(Palette.PALETTE_072, 16.0, 0.53, true)
										)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(-0.935, 1.729), 0.42, 0.28, 0.25)
		));

		/*
		 * 73)
		 */

		IMAGE.put(73, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.ZPower(1.5), new Complex(-0.19, 0.00),
								OR(
										new IGreaterThan(1000),
										new GreaterThan(new Re(), new Constant(24)),
										new GreaterThan(new Im(), new Constant(24))
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(0.0, 0.0, 0.0),
										new IterationPalette(Palette.PALETTE_073, 71.0, 0.75, false)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(0.29, 0.0), 1.05, 0.70, 0.0)
		));

		/*
		 * 74) Color function adaptée à l'algorithme d'Euclide en polaires, cf. ci-après 75) 
		 */
		IMAGE.put(74, new Image(new DomainColoring(new xt.function.EuclidFunction(), new EuclidColorFunction()),
					new MathZone(new Complex(0.0, 0.0), 60.0, 40.0, 0.0)
		));

		/*
		 * 75) Algorithme d'Euclide en polaires :
		 * a <==> rayon
		 * b <==> angle
		 * couleur fonction du PGCD de a et de b
		 */
		IMAGE.put(75, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.EuclidFunction(), new Complex(0.0, 0.0),
								new EuclidStopCriterion(),
								new EuclidColorFunction(),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(-100.0, 40.0), 180.0, 120.0, 0.0)
		));

		/*
		 * 76)
		 */
		IMAGE.put(76, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F22(5.0), new Complex(-104.9, 0.0),
								OR(
										new IGreaterThan(1000),
										new AbsGreaterThan(1E8)
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(0x000022),
										new Max(
												new ArgPalette(Palette.PALETTE_075, 1.0, 0.85),
												new AbsLog(33.0)
										)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(3.0, 0.5), 2.04, 1.36, -0.9)
		));

		/*
		 * 77) Distance de 0 à z en évitant le mur circulaire x^2 + y^2 = 1 percé en 1 ; niveaux de gris.
		 */
		IMAGE.put(77, new Image(new DomainColoring(new xt.function.F23(), new RealGrayColorFunction(Math.PI / 2.0)),
				new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0)
		));
		
		/*
		 * 78) Clown de Noël
		 */
		IMAGE.put(78, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F24(), new Complex(0.0, 2.477),
								OR(
										new IGreaterThan(1000),
										new AbsGreaterThan(3.5875)
								),
								IF(
										new IGreaterThan(1000),
										new ConstantColor(0x000000),
										new Mul(
												new IterationPalette(Palette.PALETTE_078, 10.0, 0.0, false),
												new Max(
														new Inverse(new FancyGradient004(3.5875)),
														new FancyGradient002(3.5875)
												)
										)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(0.0, 2.4), 1.8, 1.2, 0.0)
		));

		/*
		 * 79) Odysseus
		 */
		IMAGE.put(79, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F25(),
								new Complex(6.1, 7.8),
								OR(
										new IGreaterThan(50),
										new AbsGreaterThan(1100.0)
								),
								IF(
										new IGreaterThan(50),
										new ConstantColor(0xFFFFFF),
										new Mul(
											new IterationPalette(Palette.PALETTE_079, Palette.PALETTE_079.getNbColors(), 0.0, false),
											new FancyGradient005(1100.0)
										)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(-80.5, 0.0), 10.5, 7.0, Math.PI / 2.0)
		));
		
		/*
		 * 80) Embrasement
		 */
		IMAGE.put(80, new Image(
						new EscapeTimeAlgorithm(
								new xt.function.F26(),
								null,
								OR(
										new IGreaterThan(25000),
										new AbsGreaterThan(3.0)
								),
								IF(
										new IGreaterThan(25000),
										new ConstantColor(0x100040),
										new Mul(
											new IterationPalette(Palette.PALETTE_080, 2000.0, 0.2333333, false),
											new FancyGradient005(1144.66)
										)
								),
								ApplyTestOrder.FIRST_TEST_THEN_APPLY
						),
						new MathZone(new Complex(-0.5175, -0.4493), 14.7E-4, 9.8E-4, 0.04)
		));

		/*
		 * 81) Méduse fantôme
		 */
		IMAGE.put(81, new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.5, 0.0),
						new Complex(-0.812, 0.7575),
						OR(
								new IGreaterThan(200),
								new AbsGreaterThan(2.37)
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0x000000),
								new Max(
									new IterationPalette(Palette.PALETTE_081, 72.0, 0.62, true),
									new GridRe(0.075, 0.3, 0.0, 1.0),
									new GridIm(0.075, 0.9, 0.8, 0.5)
								)
						),
						ApplyTestOrder.FIRST_TEST_THEN_APPLY
				),
				new MathZone(new Complex(-1.042, 0.35), 0.165, 0.110, -1.18)
		));
		
		/*
		 * 82) Totem polype
		 */
		IMAGE.put(82, new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.5, 0.0),
						new Complex(-1.075903, 0.62803),
						OR(
								new IGreaterThan(200),
								new AbsLessThan(6.8E-4)
						),
						IF(
								new IGreaterThan(200),
								new ConstantColor(0x001000),
								new Mul(
										new IterationPalette(Palette.PALETTE_082, Palette.PALETTE_082.getNbColors(), 0.0, false),
										new FancyGradient002(6.8E-4)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.13992, 0.02442), 0.001542, 0.001028, -0.23)
		));
		
		/*
		 * 83) Brebis turquoise
		 */
		IMAGE.put(83, new Image(
				new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1.3333333, 0.0),
						new Complex(-0.73743019, -0.12891747),
						OR(
								new IGreaterThan(80),
								new AbsLessThan(0.15353)
						),
						IF(
								new IGreaterThan(80),
								new ConstantColor(0x222222),
								new Mul(
									new FancyGradient002(0.15353),
									new ArgPalette(Palette.PALETTE_083, 1.0, 0.42)
								)
						),
						ApplyTestOrder.FIRST_APPLY_THEN_TEST
				),
				new MathZone(new Complex(-0.35, 0.0), 1.15, 0.70, Math.PI / 2.0)
		));
		
		IMAGE.put(84, Image084.get()); // Color Function 5 (identité)
		IMAGE.put(85, Image085.get()); // Surnombre
		IMAGE.put(86, Image086.get()); // Magma basaltique
		IMAGE.put(87, Image087.get()); // Joyeux anniversaire Nini !
		IMAGE.put(88, Image088.get()); // Orobanche
		IMAGE.put(89, Image089.get()); // Donut
		IMAGE.put(90, Image090.get()); // Bisou
		IMAGE.put(91, Image091.get()); // Epineux
		IMAGE.put(92, Image092.get()); // Spiderman
		IMAGE.put(93, Image093.get()); // Lemniscate
		IMAGE.put(94, Image094.get()); // Barbie
		IMAGE.put(95, Image095.get()); // Stomoxe II
		IMAGE.put(96, Image096.get()); // Frise
		IMAGE.put(97, Image097.get()); // Plumage
		IMAGE.put(98, Image098.get()); // Zeus drapé
		IMAGE.put(99, Image099.get()); // Escargots
	}

	public static Image get(Integer n) {
		return IMAGE.get(n);
	}
}
