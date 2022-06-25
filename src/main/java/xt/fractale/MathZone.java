package xt.fractale;

import xt.math.Complex;

public class MathZone {

	private Complex zCenter;
	private double xSemiLength;
	private double ySemiLength;
	private double rotationAngle;
	
	public MathZone(Complex zCenter, double xSemiLength, double ySemiLength, double rotationAngle)
	{
		this.zCenter = zCenter;
		this.xSemiLength = xSemiLength;
		this.ySemiLength = ySemiLength;
		this.rotationAngle = rotationAngle;
	}

	
	
	/*
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
	*/
	
	public void centeredZoomOut(double coef) {
		xSemiLength *= coef;
		ySemiLength *= coef;
	}
	
	public void shift(int x, int y) {
		double dx = x * xSemiLength / 4.0;
		double dy = y * ySemiLength / 4.0;
		zCenter = new Complex(zCenter.re() + dx, zCenter.im() + dy);
	}
	
	public void rotate(double rotationAngle) {
		this.rotationAngle += rotationAngle;
	}



	public Complex getzCenter() {
		return zCenter;
	}



	public void setzCenter(Complex zCenter) {
		this.zCenter = zCenter;
	}



	public double getxSemiLength() {
		return xSemiLength;
	}



	public void setxSemiLength(double xSemiLength) {
		this.xSemiLength = xSemiLength;
	}



	public double getySemiLength() {
		return ySemiLength;
	}



	public void setySemiLength(double ySemiLength) {
		this.ySemiLength = ySemiLength;
	}



	public double getRotationAngle() {
		return rotationAngle;
	}



	public void setRotationAngle(double rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
}
