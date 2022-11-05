package xt.fractale;

import xt.coloralgo.ApplyTestOrder;
import xt.coloralgo.Color;
import xt.coloralgo.DomainColoring;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.Palette;
import xt.coloralgo.effect.*;
import xt.coloralgo.stopcriterion.AbsGreaterThan;
import xt.math.Complex;
import xt.math.MyMath;

public class BatchMain {
	
	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;
	
	private static String PATH = System.getenv("FRACTALE_HOME");

	public static void main(String[] args) {
		int choice = 0;
		switch (choice) {
		case 27: video027(); break;
		case 28: video028(); break;
		case 29: video029(); break;
		case 30: video030(); break;
		case 31: video031(); break;
		case 39: video039(); break;
		case 50: video050(); break;
		case 51: video051(); break;
		default:
			Image image = Image.get(choice);
			String filename = String.format("%simage_%03d.png", PATH, choice);
			new ImageFile(image, filename, DIMENSION_X, DIMENSION_Y).create();
			break;
		}
	}
	
	/*
	 * 27) Méduse
	 * 100 images pour une video cyclique
	 */
	private static void video027() {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			// Le paramètre c de Julia décrit un cercle :
			double theta = i * 2.0 * Math.PI / n;
			double dx = 3E-2 * Math.cos(theta);
			double dy = 3E-2 * Math.sin(theta);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
						new xt.function.Sylvestre(1), new Complex(-0.87 + dx, -0.90 + dy), 100, true, new AbsGreaterThan(2.0), Color.BLACK, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
						new IterationPalette(Palette.PALETTE_027, 100.0, 0.40)
					),
					new MathZone(new Complex(-0.38, 0.0), 1.35, 0.80, - Math.PI / 2.0)),
					PATH + String.format("tmp\\image_027_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 28) Vitrail de conques, palette changeante
	 * 100 images pour une video cyclique
	 */
	private static void video028() {
		int n = 100;
		for (int i = 0; i < n; i ++) {
			System.out.println("----- " + i);
			double t = (double) i / (double) n;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.ZPower(2), null, 2000, true, new AbsGreaterThan(2.0), Color.WHITE, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new Pow(0.6,
									new Mul(
											// déphasages de palette
											new IterationPalette(Palette.PALETTE_007, 14.0, -t, 16.0, -2.0 * t, 20.0, -3.0 * t),
											new Bubble(14.0, 0.0, 16.0, 0.0, 20.0, 0.0),
											new IterationGradient(0.004, 115.0)
									)
							)
					),
					new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0)),
					PATH + String.format("tmp\\image_028_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 29) Vaisseau alien, zoom jusqu'à plus petit vaisseau alien
	 * 100 images pour une video imparfaitement-cyclique
	 */
	private static void video029() {
		final double K = 5.628559053;
		int n = 100;
		for (int i = 0; i < n; i ++) {
			double t = (double) i / (double) n;
			System.out.println("----- " + i);
			double c = Math.exp(- K * t);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, true, new AbsGreaterThan(2.0), Color.WHITE, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new IterationPalette(Palette.PALETTE_006, 100.0, 0.95 - 0.06 * t)
					),
					new MathZone(new Complex(0.0 - 0.0001 * t, 1.237 + 0.000339 * t), 0.0192 * c, 0.0128 * c, -1.18 * t)),
					PATH + String.format("tmp\\image_029_%02d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 30) Transformation du "bouclier cérébral" en "fortifications" 
	 * 500 images pour une video
	 */
	private static void video030() {

		Complex c1 = new Complex(-0.03689236111111108, 0.28564453125);
		Complex c2 = new Complex(-0.5429, 0.1839);
		int i = 0;
		while (i < 50) {
			System.out.println("----- " + i);
			double t = (double) (i - 50) / 50.0;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), c1, 3500, true, new AbsGreaterThan(2.0), Color.WHITE, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new IterationPalette(new Palette(0x000000, 0xFFFFFF, 0x007700), 28.73, 5.0 / 6.0 + t)
					),
					new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0)),
					PATH + String.format("tmp\\image_030_%03d.png", i),
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
							new xt.function.BurningShip(), c, 3500, true, new AbsGreaterThan(2.0), Color.WHITE, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new Max(
									new IterationPalette(new Palette(0x000000, 0xFFFFFF, ((int) (t * 0xFF)) << 2), s * 28.73 + t * 40.0, s * 5.0 / 6.0 + t * 0.15),
									new Min(
											new ConstantColor(t, t, t),
											new GridIm(0.2, 1.0, 1.0, 0.8),
											new GridRe(0.2, 0.2, 0.2, 0.8)											
									)
							)
					),
					new MathZone(new Complex(0.0, s * 0.58 + t * 0.4655), s * 0.225 + t * 0.0039, s * 0.150 + t * 0.0026, s * 0.0 + t * Math.PI)),
					PATH + String.format("tmp\\image_030_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			i ++;
		}
		while (i < 500) {
			System.out.println("----- " + i);
			double t = (double) (i - 450) / 50.0;
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.BurningShip(), c2, 3500, true, new AbsGreaterThan(2.0), Color.WHITE, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new Max(
									new IterationPalette(new Palette(0x000000, 0xFFFFFF, 0xFF0000), 40.0, 0.15 + t),
									new Min(
											new GridIm(0.2, 1.0, 1.0, 0.8),
											new GridRe(0.2, 0.2, 0.2, 0.8)											
									)
							)
					),
					new MathZone(new Complex(0.0, 0.4655), 0.0039, 0.0026, Math.PI)),
					PATH + String.format("tmp\\image_030_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			i ++;
		}
	}
	
	/*
	 * 31) Composition florale en mouvement
	 * 600 images pour une video cyclique
	 */
	private static void video031() {
		int n = 600;
		for (int i = 0; i < n; i ++) {
			// Le paramètre c de Julia décrit une lemniscate de Bernoulli
			double theta = i * 2.0 * Math.PI / n;
			double k = Math.sqrt(2.0) * Math.sin(theta) / (1.0 + MyMath.sq(Math.cos(theta)));
			double dx = 1.0 * k;
			double dy = dx * Math.cos(theta);
			new ImageFile(
					new Image(
					new EscapeTimeAlgorithm(
							new xt.function.Fleur(), new Complex(0.0 + dx, 0.0 + dy), 7, false, new AbsGreaterThan(2E11), Color.BLACK, ApplyTestOrder.FIRST_APPLY_THEN_TEST,
							new IterationPalette(Palette.PALETTE_018, 3.0)
						),
						new MathZone(new Complex(0.0, 0.0), 1.35, 0.90, Math.PI / 2.0)),
					PATH + String.format("tmp\\image_031_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
			
		}
	}
	
	/*
	 * 39) Délire hallucinatoire : changement de fonction de coloriage par transition barycentrique
	 * 101 images pour une video non cyclique 
	 */
	private static void video039() {
		int n = 100;
		for (int i = 0; i <= n; i ++) {
			double t = (double) i / (double) n;
			double s = 1.0 - t;
			new ImageFile(
					new Image(
						new DomainColoring(new xt.function.F2(),
								new Barycenter(
										s, new Pow(0.5,
											new Mul(
													new ArgPalette(Palette.PALETTE_010, 0.5, 0.0),
													new Max(
															new GridRe(0.05, 1.0, 1.0, 1.0),
															new GridIm(0.05, 1.0, 1.0, 1.0)
													)
											)
										),
										t, new ColorFunction1()
								)
						),
						new MathZone(new Complex(0.0, 0.0), 4.5, 3.0, 0.0)
					),
					PATH + String.format("tmp\\image_039_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 50) Sinus hyperbolique --> Sinus circulaire --> (...) 
	 * 150 images pour une video cyclique
	 */
	private static void video050() {
		int n = 150;
		for (int i = 0; i < n; i ++) {
			System.out.println("---- " + i + " ----");
			double theta = i * Math.PI / n;
			new ImageFile(
					new Image(
							new DomainColoring(new xt.function.Sinh(theta), new ColorFunction1()),
							new MathZone(new Complex(0.0, 0.0), 1.5 * Math.PI, Math.PI, 0.0)
					),
					PATH + String.format("tmp\\image_050_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
	
	/*
	 * 51) Sinus hyperbolique tournant 
	 * 300 images pour une video cyclique
	 */
	private static void video051() {
		int n = 300;
		for (int i = 0; i < n; i ++) {
			System.out.println("---- " + i + " ----");
			double theta = i * 2.0 * Math.PI / n;
			new ImageFile(
					new Image(
							new DomainColoring(z -> Complex.div(MyMath.sinh(z), Complex.ei(theta)), new ColorFunction3()),
							new MathZone(new Complex(0.0, 0.0), 1.2 * Math.PI, 0.8 * Math.PI, Math.PI / 2.0)
					),
					PATH + String.format("tmp\\image_051_%03d.png", i),
					DIMENSION_X, DIMENSION_Y).create();
		}
	}
}
