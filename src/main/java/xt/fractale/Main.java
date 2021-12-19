package xt.fractale;

import xt.coloralgo.HueForHeart;
import xt.function.Function;
import xt.function.Heart;

public class Main {

	private static final double ASPECT_RATIO = 1920.0 / 1080.0;

	public static void main(String[] args) {
		Function function = new Heart();
		// Drawer.hexagonalTiling(-27.222222222222, 17.222222222222, -12.5, 12.5);
		// Drawer.fractal(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new EscapeTime(function, false, 0.0, 0.0, 200, 200,true));
		// Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new HueArg(true, true, true));
		double yMax = 4.0 * Math.PI;
		Drawer.function(-yMax * ASPECT_RATIO, +yMax * ASPECT_RATIO, -yMax, +yMax, function, new HueForHeart());
		// Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new AbsBlackAndWhite(5.0, true));
	}
}
