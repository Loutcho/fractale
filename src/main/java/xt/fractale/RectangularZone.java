package xt.fractale;

import java.awt.Rectangle;

public class RectangularZone {
	private double xMin;
	private double xMax;
	private double yMin;
	private double yMax;
	
	static int				IX					= 0;
	static int				NX					= 1;
	static int				IY					= 0;
	static int				NY					= 1;
	
	public RectangularZone(double xMin, double xMax, double yMin, double yMax)
	{
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}

	public double getxMin() {
		return xMin;
	}

	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getxMax() {
		return xMax;
	}

	public void setxMax(double xMax) {
		this.xMax = xMax;
	}

	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public double getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
	
	public void keep(int x, int y)
	{
		switch (x)
		{
		case -1: xMax = (xMin + xMax) / 2.0; break;
		case  0: double D = (xMax - xMin) / 4.0; xMin += D; xMax -= D; break;
		case +1: xMin = (xMin + xMax) / 2.0; break;
		}
		
		switch (y)
		{
		case -1: yMax = (yMin + yMax) / 2.0; break;
		case  0: double D = (yMax - yMin) / 4.0; yMin += D; yMax -= D; break;
		case +1: yMin = (yMin + yMax) / 2.0; break;
		}
	}
	
	public void vZoom() {
		double yMoy = (yMax + yMin) / 2.0;
		double yAmp = (yMax - yMin);
		yAmp /= 2.0;
		yMax = yMoy + yAmp / 2.0;
		yMin = yMoy - yAmp / 2.0; 
	}
	
	public double toX(int x, Rectangle r)
	{
		double xx = (double) x;
		double rr = (double) (r.width);
		double iix = (double) IX;
		double nnx = (double) NX;
		double result = xMin + (iix + xx / rr) * (xMax - xMin) / nnx;
		
		//System.out.println("x = " + x + ", r = " + r + " ==> toX = " + result);
		
		return result;
	}

	public double toY(int y, Rectangle r)
	{
		double yy = (double) y;
		double rr = (double) r.height;
		double iiy = (double) IY;
		double nny = (double) NY;
		double result = yMax + (iiy + yy / rr) * (yMin - yMax) / nny;
		
		//System.out.println("y = " + y + ", r = " + r + " ==> toY = " + result);
		
		return result;
	}
	
	public void centeredZoomOut(double coef)
	{
		double X_CENTER = (xMin + xMax) / 2.0;
		double Y_CENTER = (yMin + yMax) / 2.0;
		double DX = (xMax - xMin) / 2.0;
		double DY = (yMax - yMin) / 2.0;

		xMax = X_CENTER + coef * DX;
		xMin = X_CENTER - coef * DX;
		yMax = Y_CENTER + coef * DY;
		yMin = Y_CENTER - coef * DY;
	}
	
	public void shift(int x, int y)
	{
		double dx = x * (xMax - xMin) / 8.0;
		double dy = y * (yMax - yMin) / 8.0;

		xMax += dx;
		xMin += dx;
		yMax += dy;
		yMin += dy;
	}
}
