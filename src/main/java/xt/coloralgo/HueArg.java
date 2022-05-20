package xt.coloralgo;

import java.awt.Color;
import java.awt.event.KeyEvent;

import xt.math.MyMath;
import xt.math.Complex;

public class HueArg implements ColorAlgo {

	private boolean rGrid;
	private boolean thetaGrid;
	private boolean rGradient;
	private double rBase;
	private double thetaPaletteOffset = 0.0;
	private int nbThetaSlices = 6;
	private double paletteOrientation = 1.0;
	private double rGridThickness = 0.02;
	private double thetaGridThickness = 0.1;
	private static final double THETA_PALETTE_OFFSET_INCREMENT = Math.PI / 24.0;
	
	public HueArg(boolean absGrid, boolean argGrid, boolean absGradient, double absBase)
	{
		this.rGrid = absGrid;
		this.thetaGrid = argGrid;
		this.rGradient = absGradient;
		this.rBase = absBase;
	}
	
	public Color getColor(Complex pixel) {

		double r = Complex.abs(pixel);
		double theta = Complex.arg(pixel);
		double tt = Math.pow(MyMath.sqcosdemi(nbThetaSlices * theta), thetaGridThickness);
		double rr = Math.pow(MyMath.sqcosdemi(2.0 * Math.PI * Math.log(r) / Math.log(rBase)), rGridThickness);

		double[] rvb = new double[3];
		for (int i = 0; i < 3; i ++) {
			rvb[i] = MyMath.sqcosdemi(paletteOrientation * (theta - thetaPaletteOffset) + i * 2.0 * Math.PI / 3.0);
			// if (rGradient) { rvb[i] = Math.pow(rvb[i], 5.0 * Math.pow(4.0, - Math.atan(Math.log(r)) / (Math.PI / 2.0))); }
			if (rGradient) { rvb[i] *= Math.atan(Math.log(r) / Math.E) / Math.PI + 0.5; }
			if (thetaGrid) { rvb[i] = MyMath.baryseg(tt, 1.0, rvb[i]); }
			if (rGrid    ) { rvb[i] = MyMath.baryseg(rr, 0.0, rvb[i]); }
		}
		
		return new Color((int)(255.0 * rvb[0]), (int)(255.0 * rvb[1]), (int)(255.0 * rvb[2]));
	}
	
	public void processKeyEvent(int key) {
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
			case KeyEvent.VK_Q: rBase *= 1.1; break;
			case KeyEvent.VK_W: rBase /= 1.1; break;
			case KeyEvent.VK_ADD: nbThetaSlices++; break;
			case KeyEvent.VK_SUBTRACT: if (nbThetaSlices > 0) { nbThetaSlices--; } break;
		}
	}
}
