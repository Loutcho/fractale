package xt.fractale;

import xt.coloralgo.EscapeTime;
import xt.function.Function;
import xt.function.ZPower;

public class MandelbrotSet {

	public static void main(String args[]) {
		Function function = new ZPower(2);
		Drawer.fractal(
				Drawer.DEFAULT_X_MIN,
				Drawer.DEFAULT_Y_MIN,
				Drawer.DEFAULT_X_MAX,
				Drawer.DEFAULT_Y_MAX,
				function,
				new EscapeTime(function, false, 1.0, 0.5, 100, 100.0, true)
		);
	}
}
