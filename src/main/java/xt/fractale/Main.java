package xt.fractale;

import xt.coloralgo.HueForExponential;
import xt.function.*;

public class Main {

	public static void main(String[] args) {
		Function function = new Experiment();
		// Drawer.hexagonalTiling(-27.222222222222, 17.222222222222, -12.5, 12.5);
		// Drawer.fractal(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new EscapeTime(function, false, 0.0, 0.0, 200, 200,true));
		// Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new HueArg(true, true, true));
		double k = 20.0;
		Drawer.function(
				k * Drawer.DEFAULT_X_MIN, k * Drawer.DEFAULT_X_MAX, k * Drawer.DEFAULT_Y_MIN, k * Drawer.DEFAULT_Y_MAX,
				function, new HueForExponential());
		// Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new AbsBlackAndWhite(5.0, true));
	}
}
