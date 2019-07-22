package xt.coloralgo;

import java.awt.Color;

import xt.math.Complex;

public interface FractalColorAlgo {
	public Color getColor(Complex z);
	public void processKeyEvent(int key);
	public void setJuliaX(double x);
	public void setJuliaY(double y);
}
