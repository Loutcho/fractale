package xt.fractale;

import xt.coloralgo.EscapeTime;
import xt.coloralgo.FractalColorAlgo;
import xt.coloralgo.GradientWithArgument;
import xt.coloralgo.GradientWithIteration;
import xt.coloralgo.GradientWithModulus;
import xt.coloralgo.Palette;
import xt.function.Function;
import xt.function.ZPower;
import xt.math.Complex;

public class Main {

	private static void fractaleIntestinale() {
		Function f = new ZPower(2);
		FractalColorAlgo escapeTimeAlgorithm = new EscapeTime(f, null, 5000, 5000, true, Palette.PALETTE_1, 50.0, 0.4,
				new GradientWithIteration(false), new GradientWithModulus(true, 0.5, 0.5, 0.0), new GradientWithArgument(true, 0.0, 0.3, 0.0));
		MathZone mathZone = new MathZone(new Complex(-1.76208912, -0.01550358), 1.95E-7, 1.30E-7, 0.0);
		FractalDrawer drawer = new FractalDrawer(escapeTimeAlgorithm, mathZone, "C:\\Users\\Luc\\Desktop\\fractaleIntestinale.png", 7200, 4800);
		drawer.draw();
	}
	
	private static void fractaleHepatique() {
		Function f = new ZPower(2);
		FractalColorAlgo escapeTimeAlgorithm = new EscapeTime(f, null, 5000, 5000, true, Palette.PALETTE_3, 48.0, 0.9,
				new GradientWithIteration(false), new GradientWithModulus(false, 0.0, 0.0, 0.0), new GradientWithArgument(false, 0.0, 0.0, 0.0));
		MathZone mathZone = new MathZone(new Complex(-1.749798494, 0.000032655), 0.000000150, 0.000000100, 0.0);
		FractalDrawer drawer = new FractalDrawer(escapeTimeAlgorithm, mathZone, "C:\\Users\\Luc\\Desktop\\fractaleHepatique.png", 7200, 4800);
		drawer.draw();
	}
	
	private static void fractaleCourbevoie() {
		Function f = new ZPower(2);
		FractalColorAlgo escapeTimeAlgorithm = new EscapeTime(f, null, 5000, 5000, true, Palette.PALETTE_4, 384.0, 0.333333333,
				new GradientWithIteration(false), new GradientWithModulus(false, 0.0, 0.0, 0.0), new GradientWithArgument(false, 0.0, 0.0, 0.0));
		MathZone mathZone = new MathZone(new Complex(0.364480, 0.315382), 6E-6, 4E-6, 0.0);
		FractalDrawer drawer = new FractalDrawer(escapeTimeAlgorithm, mathZone, "C:\\Users\\Luc\\Desktop\\fractaleCourbevoie.png", 7200, 4800);
		drawer.draw();
	}
	
	private static void fractaleChenille() {
		Function f = new ZPower(2);
		FractalColorAlgo escapeTimeAlgorithm = new EscapeTime(f, null, 15000, 15000, true, Palette.PALETTE_5, 226.0, 0.50,
				new GradientWithIteration(false), new GradientWithModulus(false, 0.0, 0.0, 0.0), new GradientWithArgument(false, 0.0, 0.0, 0.0));
		MathZone mathZone = new MathZone(new Complex(-1.250314, 0.01376), 0.000111, 0.000075, - Math.PI / 12.0);
		FractalDrawer drawer = new FractalDrawer(escapeTimeAlgorithm, mathZone, "C:\\Users\\Luc\\Desktop\\fractaleChenille.png", 7200, 4800);
		drawer.draw();
	}
	
	public static void main(String[] args) {
		fractaleIntestinale();
	}
}
