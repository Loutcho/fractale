package xt.fractale;

import xt.coloralgo.EscapeTime;
import xt.coloralgo.FractalColorAlgo;
import xt.function.Function;
import xt.function.ZPower;

public class Main {

	private static final double ASPECT_RATIO = 1920.0 / 1080.0;

	public static void main(String[] args) {

		double xMin = Drawer.DEFAULT_X_MIN;
		double xMax = Drawer.DEFAULT_X_MAX;
		double yMin = Drawer.DEFAULT_Y_MIN;
		double yMax = Drawer.DEFAULT_Y_MAX;
		Function f = new ZPower(2);

		FractalColorAlgo c = new EscapeTime(f, false, 0.0, 0.0, 200, 200, true);
		Drawer.fractal(xMin, xMax, yMin, yMax, f, c);

		/*
		ColorAlgo c = new AbsBlackAndWhite(5.0, true);
		Drawer.function(xMin, xMax, yMin, yMax, f, c);
		*/

		/*
		Drawer.hexagonalTiling(-27.222222222222, 17.222222222222, -12.5, 12.5);
		*/
	}
}
