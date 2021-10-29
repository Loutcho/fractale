package xt.fractale;

import xt.coloralgo.AbsBlackAndWhite;
import xt.coloralgo.EscapeTime;
import xt.coloralgo.HueArg;
import xt.function.*;

public class Main {

	public static void main(String[] args) {
		Function function = new Experiment();
		Drawer.fractal(
				Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX,
				function,
				// new HueArg(true, true, true)
				//new AbsBlackAndWhite(0.6666, true)
				new EscapeTime(function, false, 0.0, 0.0, 200, 200,true)
		);
	}
}
