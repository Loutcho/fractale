package xt.fractale;

import xt.coloralgo.EscapeTime;
import xt.coloralgo.FractalColorAlgo;
import xt.function.Function;
import xt.function.ZPower;
import xt.math.Complex;

public class Main {

	public static void main(String[] args) {

		Function f = new ZPower(2);
		FractalColorAlgo escapeTimeAlgorithm = new EscapeTime(f, false, 0.0, 0.0, 5000, 5000, true);
		MathZone mathZone = new MathZone(new Complex(-1.749798494, 0.000032663), 0.000000180, 0.000000120, 0.0);
		FractalDrawer drawer = new FractalDrawer(escapeTimeAlgorithm, mathZone, "C:\\Users\\Luc\\Desktop\\test.png", 600, 400);
		drawer.draw();
		
		/*
		Drawer.fractal(xMin, xMax, yMin, yMax, f, c);
		*/

		/*
		ColorAlgo c = new HueArg(true, true, true, 0.5, true, true);
		Drawer.function(xMin, xMax, yMin, yMax, f, c);
		*/

		/*
		Drawer.hexagonalTiling(-27.222222222222, 17.222222222222, -12.5, 12.5);
		*/
	}
}
