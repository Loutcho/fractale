package xt.fractale;

import xt.coloralgo.BubbleEffect;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.coloralgo.GradientWithArgument;
import xt.coloralgo.GradientWithIteration;
import xt.coloralgo.GradientWithModulus;
import xt.coloralgo.Palette;
import xt.coloralgo.Periodicity;
import xt.coloralgo.PowerEffect;
import xt.math.Complex;

public class Main {

	public static void main(String[] args) {
		int choice = 7;
		switch (choice) {
		case 1: fractale001(); break;
		case 2: fractale002(); break;
		case 3: fractale003(); break;
		case 4: fractale004(); break;
		case 5: fractale005(); break;
		case 6: fractale006(); break;
		case 7: fractale007(); break;
		}
	}

	/*
	 * 1) Intestins
	 */
	private static void fractale001() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, 5000, true,
						Palette.PALETTE_001, new Periodicity(50.0, 0.6),
						new GradientWithIteration(false),
						new GradientWithModulus(true, 0.30, 0.30, 0.00),
						new GradientWithArgument(true, 0.00, 0.15, 0.00),
						BubbleEffect.ON, new PowerEffect(0.75)),
				new MathZone(new Complex(-1.76208912, -0.01550358), 1.95E-7, 1.30E-7, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_001.png",
				7200, 4800).draw();
	}

	/*
	 * 2) Courbevoie
	 */
	private static void fractale002() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, 5000, true,
						Palette.PALETTE_002, new Periodicity(384.0, 0.333333333),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.OFF, PowerEffect.OFF),
				new MathZone(new Complex(0.364480, 0.315382), 6E-6, 4E-6, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_002.png",
				7200, 4800).draw();
	}
	
	/*
	 * 3) Foie
	 */
	private static void fractale003() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 5000, 5000, true,
						Palette.PALETTE_003, new Periodicity(48.0, 0.9),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.OFF, PowerEffect.OFF),
				new MathZone(new Complex(-1.749798494, 0.000032655), 0.000000150, 0.000000100, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_003.png",
				7200, 4800).draw();
	}
	
	/*
	 * 4) Chenille
	 */
	private static void fractale004() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 15000, 15000, true,
						Palette.PALETTE_004, new Periodicity(226.0, 0.50),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.OFF, PowerEffect.OFF),
				new MathZone(new Complex(-1.250314, 0.01376), 0.000111, 0.000075, - Math.PI / 12.0),
				"C:\\Users\\Luc\\Desktop\\expo_004.png",
				7200, 4800).draw();
	}

	/*
	 * 5) Cerveau
	 */
	private static void fractale005() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.BurningShip(), new Complex(-0.03689236111111108, 0.28564453125), 3500, 3500, true,
						Palette.PALETTE_005, new Periodicity(28.73, 5.0 / 6.0),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.OFF, PowerEffect.OFF),
				new MathZone(new Complex(0.0, 0.58), 0.225, 0.150, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_005.png",
				7200, 4800).draw();
	}
	
	/*
	 * 6) Vaisseau alien
	 */
	private static void fractale006() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.AntiBurningShip(), new Complex(0.4849, 0.7498), 5000, 5000, true,
						Palette.PALETTE_006, new Periodicity(100.0, 0.95),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.OFF, PowerEffect.OFF),
				new MathZone(new Complex(0.0, 1.237), 0.0192, 0.0128, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_006.png",
				7200, 4800).draw();
	}
	
	/*
	 * 7) Conques
	 */
	private static void fractale007() {
		new FractalDrawer(
				new EscapeTimeAlgorithm(
						new xt.function.ZPower(2), null, 2000, 2000, false,
						//Palette.PALETTE_007, new Periodicity(66.5, 0.000, 66.5, 0.333, 66.5, 0.666),
						Palette.PALETTE_007, new Periodicity(33.5, 0.000, 37.0, 0.333, 33.0, 0.666),
						new GradientWithIteration(false),
						new GradientWithModulus(false, 0.0, 0.0, 0.0),
						new GradientWithArgument(false, 0.0, 0.0, 0.0),
						BubbleEffect.ON, new PowerEffect(0.7)),
				new MathZone(new Complex(0.277250, -0.006947), 0.000033, 0.000022, 0.0),
				"C:\\Users\\Luc\\Desktop\\expo_007.png",
				7200, 4800).draw();
	}
}
