package xt.coloralgo;

import xt.math.Complex;
import xt.math.MyMath;

import java.awt.Color;

public class HueForHeart implements ColorAlgo {

	public HueForHeart() {
	}
	
	public Color getColor(Complex pixel) {
		double x = pixel.re();
		double y = pixel.im();
		if (y > Math.PI || y < -Math.PI) {
			return Color.BLACK;
		}
		double[] rvb = new double[3];
		double t0 = (Math.atan(0.1 * x) + Math.PI / 2) / Math.PI;
		double t1 = (x >= 0) ? 1.0 : 0.0;
		double t = (9.0 * t0 + t1) / 10.0;
		for (int i = 0; i < 3; i ++) {
			rvb[i] = t * MyMath.sqcosdemi(y + i * 2.0 * Math.PI / 3.0);
		}
		return new Color((int)(255.0 * rvb[0]), (int)(255.0 * rvb[1]), (int)(255.0 * rvb[2]));
	}

	private Color getColor1(Complex pixel) {
		double x = pixel.re();
		double y = pixel.im();
		double s = MyMath.sqcosdemi(y);
		double t = (Math.atan(0.1 * x) + Math.PI / 2) / Math.PI;
		double[] rvb_m = new double[3];
		double[] rvb_p = new double[3];
		double[] rvb = new double[3];
		rvb_m[0] = 0.0;
		rvb_m[1] = 0.0;
		rvb_m[2] = s;
		rvb_p[0] = 1.0;
		rvb_p[1] = s;
		rvb_p[2] = 0.0;
		for (int i = 0; i <= 2; i ++) {
			rvb[i] = (1 - t) * rvb_m[i] + t * rvb_p[i];
		}
		return new Color((int)(255.0 * rvb[0]), (int)(255.0 * rvb[1]), (int)(255.0 * rvb[2]));
	}
	
	public void processKeyEvent(int key) {
	}
}
