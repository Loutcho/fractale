package xt.fractale;

import xt.coloralgo.AbsBlackAndWhite;
import xt.coloralgo.EscapeTime;
import xt.coloralgo.HueArg;
import xt.function.*;

public class Main {

	public static void main(String[] args) {
		Function function = new MoebiusTenthRootOfUnity();
		//Drawer.hexagonalTiling(-27.222222222222, 17.222222222222, -12.5, 12.5);
		// Drawer.fractal(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new EscapeTime(function, false, 0.0, 0.0, 200, 200,true));
		Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new HueArg(false, false, true));
		// Drawer.function(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX, function, new AbsBlackAndWhite(5.0, true));
	}
}
