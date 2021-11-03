package xt.fractale;

import xt.coloralgo.EscapeTime;
import xt.function.*;

public class Main {

	public static void main(String[] args) {
		Function function = new ZPower(2);
		Drawer.fractal(
				-2.7222222222222, 1.7222222222222, -1.25, 1.25,
				function,
				// new HueArg(false, false, true)
				// new AbsBlackAndWhite(0.6666, true)
				new EscapeTime(function, false, 0.0, 0.0, 200, 200,true)
		);
	}
}
