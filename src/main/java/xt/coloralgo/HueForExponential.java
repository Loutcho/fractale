package xt.coloralgo;

import xt.math.Complex;
import xt.math.MyMath;

import java.awt.*;

public class HueForExponential implements ColorAlgo {

	private HueArg hueArg = new HueArg(false, false, false);
	public HueForExponential() {
	}
	
	public Color getColor(Complex pixel) {
		double x = pixel.re();
		double y = pixel.im();
		double t = (Math.atan(0.1 * x) + Math.PI / 2) / Math.PI;
		double red, green, blue;
		double red1, green1, blue1;
		double red2, green2, blue2;
		red1 = 0.0;
		green1 = 0.0;
		blue1 = MyMath.sqcosdemi(y);
		red2 = 1.0;
		green2 = MyMath.sqcosdemi(y);
		blue2 = 0.0;
		red = (1 - t) * red1 + t * red2;
		green = (1 - t) * green1 + t * green2;
		blue = (1 - t) * blue1 + t * blue2;
		return new Color((int)(255.0 * red), (int)(255.0 * green), (int)(255.0 * blue));
	}
	
	public void processKeyEvent(int key) {
		/*
		switch (key) {
			case KeyEvent.VK_A: rGradient = !rGradient; break;
			case KeyEvent.VK_Z: thetaGrid = !thetaGrid; break;
			case KeyEvent.VK_E: rGrid = !rGrid; break;
			case KeyEvent.VK_R: thetaPaletteOffset = (thetaPaletteOffset + THETA_PALETTE_OFFSET_INCREMENT) % (2.0 * Math.PI); break;
			case KeyEvent.VK_T: paletteOrientation *= -1.0; break;
			case KeyEvent.VK_Y: rGridThickness *= 1.1; break;
			case KeyEvent.VK_H: rGridThickness /= 1.1; break;
			case KeyEvent.VK_P: thetaGridThickness *= 1.1; break;
			case KeyEvent.VK_M: thetaGridThickness /= 1.1; break;
			case KeyEvent.VK_ADD: if (nbThetaSlices < 12) { nbThetaSlices++; } break;
			case KeyEvent.VK_SUBTRACT: if (nbThetaSlices > 0) { nbThetaSlices--; } break;
		}
	 */
	}
}
