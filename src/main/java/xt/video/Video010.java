package xt.video;

import static xt.coloralgo.booleanexpression.Or.OR;
import static xt.coloralgo.effect.If.IF;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.booleanexpression.AbsGreaterThan;
import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.coloralgo.booleanexpression.IGreaterThan;
import xt.coloralgo.effect.AbsGradient1;
import xt.coloralgo.effect.Barycenter;
import xt.coloralgo.effect.ConstantColor;
import xt.coloralgo.effect.Effect;
import xt.coloralgo.effect.GridIm;
import xt.coloralgo.effect.GridRe;
import xt.coloralgo.effect.IterationGradient;
import xt.coloralgo.effect.IterationPalette;
import xt.coloralgo.effect.Max;
import xt.coloralgo.effect.Mul;
import xt.coloralgo.effect.Pow;
import xt.fractale.Image;
import xt.fractale.ImageFile;
import xt.fractale.MathZone;
import xt.math.Complex;
import xt.math.MyMath;

public class Video010 {

	private static final int ITERATION_MAX = 3000; // or 100 when frame around 5000-5500;
	private static final int DIMENSION_X = 3240;
	private static final int DIMENSION_Y = 2160;

	private static String PATH = System.getenv("FRACTALE_HOME");

	private static final double T0 =  0.0;
	private static final double T1 = 11.5;
	private static final double T2 = 12.5;
	private static final double T3 = 20.0;
	private static final double T4 = 20.5;
	private static final double T5 = 37.0;
	private static final double T6 = 53.5;
	private static final double T7 = 70.0;
	private static final double T8 = 87.2;
	private static final double T9 = 89.8;
	private static final double T10 = 98.0;
	private static final double T11 = 113.5;
	private static final double T12 = 130.5;
	private static final double T13 = 147.7;
	private static final double T14 = 149.2;
	private static final double T15 = 165.0;
	private static final double T16 = 173.0;
	private static final double T17 = 207.0;
	private static final double T18 = 208.5;
	private static final double T19 = 213.0;
	
	public static Theme instantTheme(double t) {
		if ((T0 <= t) && (t <= T1)) { return Theme.FOLKLO; }
		if ((T1 <= t) && (t <= T2)) { return Theme.TAC_TAC; }
		if ((T2 <= t) && (t <= T3)) { return Theme.FOLKLO; }
		if ((T3 <= t) && (t <= T4)) { return Theme.TAC_TAC; }
		if ((T4 <= t) && (t <= T5)) { return Theme.GUITARE_ELECTRIQUE; }
		if ((T5 <= t) && (t <= T6)) { return Theme.BLABLA_PLAT; }
		if ((T6 <= t) && (t <= T7)) { return Theme.BLABLA_MELODIQUE_ASCENDANT; }
		if ((T7 <= t) && (t <= T8)) { return Theme.REFRAIN_SIE_MUSS_NICHT; }
		if ((T8 <= t) && (t <= T9)) { return Theme.DICKE_TITTEN; }
		if ((T9 <= t) && (t <= T10)) { return Theme.GUITARE_ELECTRIQUE; }
		if ((T10 <= t) && (t <= T11)) { return Theme.BLABLA_PLAT; }
		if ((T11 <= t) && (t <= T12)) { return Theme.BLABLA_MELODIQUE_ASCENDANT; }
		if ((T12 <= t) && (t <= T13)) { return Theme.REFRAIN_SIE_MUSS_NICHT; }
		if ((T13 <= t) && (t <= T14)) { return Theme.DICKE_TITTEN; }
		if ((T14 <= t) && (t <= T15)) { return Theme.FOLKLO; }
		if ((T15 <= t) && (t <= T16)) { return Theme.BLABLA_MELODIQUE_ASCENDANT; }
		if ((T16 <= t) && (t <= T17)) { return Theme.REFRAIN_SIE_MUSS_NICHT; }
		if ((T17 <= t) && (t <= T18)) { return Theme.DICKE_TITTEN; }
		if ((T18 <= t) && (t <= T19)) { return Theme.GUITARE_ELECTRIQUE; }
		return Theme.SILENCE;
	}
	
	/*
0:00
     folklo
0:11 bam bam bam
     folklo
0:19 bam bam bam
     guitare électrique
0:36 Ich leb alleine schon viele Jahre
0:41 Das Leben stumpf, der Alltag grau
0:45 Verlier Geduld, Verstand und Haare
0:49 Ich hätte gerne eine Frau
0:53 Und die Hoffnung will mir schwinden
0:57 Eine Partnerin zu finden
1:01 Die mir ebenbürtig ist
1:05 Nein, da ist kein Glück in Sicht
1:10 Sie muss nicht schön sein
1:14 Sie muss nicht klug sein
Nein
Sie muss nicht reich sein
1:21.5 Kein Model mit langen Schritten
1:26 Doch dicken Titten
1:30
     guitare électrique
1:37 Wie eine stetig offene Wunde
1:41 Aus der Seele tropft das Blut
1:45 Einzig Trost sind kleine Hunde
1:49 Ein feines Fräulein wäre gut
1:53 Ein feines Fräulein wäre toll
1:57 Ich bin auch gar nicht anspruchsvoll
2:02 Ich bin auch gar nicht wählerisch
2:06 Am Ende der Geschicht
2:10 Muss sie nicht schön sein
2:14 Sie muss nicht klug sein
 Nein
2:18 Sie muss nicht reich sein
2:22 Doch um eines möchte ich bitten
2:28 Dicke Titten

	folklo + guitare électrique 

2:44 Ich bin auch gar nicht anspruchsvoll
2:48 Doch große Brüste wären toll
2:53 Sie muss nicht schön sein
2:58 Sie muss nicht klug sein
3:01 Sie muss nur reich sein
An Fettgewebe bitte, bitte
3:09 Sie wird nichts bei mir vermissen
3:13 Sie braucht mich auch gar nicht küssen
3:17 Braucht mich nicht mit Trauben laben
3:21 Sie muss nur Riesentitten haben
3:27 Dicke Titten

folklo + guitare électrique
	 */
	
	
	// private static final int N = 6540; // nombre de frames : 6540 // duree = 3 min 38 s = 218 s
	private static final double DUREE = 218.0;
	private static final double τ = 0.51; // 1 temps ~= 0.51 s
	private static final double R_JULIA = 0.30;
	private static final double R_CENTER = 0.01;

	private static double pulsation(double t) {
		return MyMath.sq(Math.cos(Math.PI * t / τ)); 
	}

	private enum Theme {
		FOLKLO,
		TAC_TAC,
		GUITARE_ELECTRIQUE,
		BLABLA_PLAT,
		BLABLA_MELODIQUE_ASCENDANT,
		REFRAIN_SIE_MUSS_NICHT,
		DICKE_TITTEN,
		SILENCE
	}
	
	private static double tmin = 0.0;
	private static double tmax = DUREE;
	private static int I_MIN = (int) Math.floor(tmin * 30.0);
	private static int I_MAX = (int) Math.ceil(tmax * 30.0);
	
	public static void main(String[] args) {
		for (int i = I_MIN; i <= I_MAX; i ++) {
			double t = ((double) i) / 30.0; // temps en secondes
			double θJulia = 2.0 * Math.PI * t / DUREE;
			double θCenter = 2.0 * Math.PI * t / DUREE;
			double ω = pulsation(t);
			
			System.out.println("---- " + i + " ----");
			Theme theme = instantTheme(t);
			
			xt.function.F4 function = new xt.function.F4();
			
			double r = R_JULIA * Math.cos(3.0 / 5.0 * θJulia);
			double c = r * Math.cos(θJulia);
			double s = r * Math.sin(θJulia);
			Complex zJulia = new Complex(0.7639 + c, 0.3125 + s);

			Complex zCenter = new Complex(0.595 + R_CENTER * Math.cos(θCenter), -0.190 + R_CENTER * Math.sin(θCenter));
			
			BooleanExpression stopCriterion = OR(new IGreaterThan(ITERATION_MAX), new AbsGreaterThan(2.0));
			Effect effect;

			switch (theme) {
			case FOLKLO:
				 effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new IterationPalette(Palette.PALETTE_VIDEO_010, 33.0, 0.2 * ω, true)
				);
				break;
			case TAC_TAC:
				 effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(1.0, 1.0, 1.0),
							new IterationPalette(Palette.PALETTE_VIDEO_010, 33.0, 1.0 * ω, true)
				);
				break;
			case GUITARE_ELECTRIQUE:
				 effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new IterationPalette(Palette.PALETTE_VIDEO_010a, 33.0 * (1 + ω), 0.0, true)
				);
				break;
			case BLABLA_PLAT:
				 effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new Mul(
									new IterationPalette(Palette.PALETTE_VIDEO_010a, 33.0 * (1 + ω), 0.0, true),
									new GridIm(0.1, 0.8, 0.7, 0.6)
							)
				);
				break;
			case BLABLA_MELODIQUE_ASCENDANT:
				 effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new Mul(
									new IterationPalette(Palette.PALETTE_VIDEO_010a, 33.0 * (1 + ω), - 0.3 * ω, true),
									new GridRe(0.2, 0.8, 0.7, 0.6)
							)
				);
				break;
			case REFRAIN_SIE_MUSS_NICHT:
				effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(ω, 0.5, 1.0 - ω),
							new Mul(
									new IterationPalette(Palette.PALETTE_VIDEO_010, 33.0 * (1 + ω), 0.5 * ω, true),
									new Max(
											new GridRe(0.3, 1.0, 1.0, ω),
											new GridIm(0.3, 1.0, 1.0, ω)
									)
							)
				);
				break;
			case DICKE_TITTEN:
				effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new Pow(0.4,
									new Mul(
											new IterationPalette(Palette.PALETTE_009, 33.0, 0.0, true),
											new IterationGradient(0.015, 0.0),
											new AbsGradient1(0.85 * (1 + ω) / 2.0, 1.0 * (1 + ω) / 2.0, 1.0 * (1 + ω) / 2.0)
									)
							)
				);
				break;
			case SILENCE:
			default:
				double tt = (t - T19) / (DUREE - T19);
				effect = IF(
							new IGreaterThan(ITERATION_MAX),
							new ConstantColor(0.0, 0.0, 0.0),
							new Barycenter(
									1.0 - tt, new IterationPalette(Palette.PALETTE_009, 33.0, t / 2.0, true),
									tt, new ConstantColor(0.0, 0.0, 0.0)
							)
				);
				break;
			}

			Image image = new Image(
					new EscapeTimeAlgorithm(
							function, zJulia,
							stopCriterion,
							effect,
							ApplyTestOrder.FIRST_APPLY_THEN_TEST
					),
					new MathZone(zCenter, 0.45, 0.30, 0.0)
			);
			
			
			new ImageFile(
					image,
					PATH + String.format("frames\\frame_010_%04d.png", i),
					DIMENSION_X, DIMENSION_Y
			).create();
		}
	}
}
