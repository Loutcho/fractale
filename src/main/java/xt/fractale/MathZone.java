package xt.fractale;

import xt.math.Complex;

public class MathZone {

	private Complex initialZCenter;
	private double initialXSemiLength;
	private double initialYSemiLength;
	private double initialRotationAngle;
	
	private Complex zCenter;
	private double xSemiLength;
	private double ySemiLength;
	private double rotationAngle;
	
	public MathZone(Complex zCenter, double xSemiLength, double ySemiLength, double rotationAngle) {
		this.initialZCenter        = zCenter;
		this.initialXSemiLength    = xSemiLength;
		this.initialYSemiLength    = ySemiLength;
		this.initialRotationAngle  = rotationAngle;
		init();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MathZone(");
		builder.append(zCenter);
		builder.append(", ");
		builder.append(xSemiLength);
		builder.append(", ");
		builder.append(ySemiLength);
		builder.append(", ");
		builder.append(rotationAngle);
		builder.append(")");
		return builder.toString();
	}	
	
	private void init() {
		this.zCenter       = this.initialZCenter;
		this.xSemiLength   = this.initialXSemiLength;
		this.ySemiLength   = this.initialYSemiLength;
		this.rotationAngle = this.initialRotationAngle;
	}

	public void reinit() {
		init();
	}
	
	public void keep(int x, int y) {
		xSemiLength /= 3.0;
		ySemiLength /= 3.0;

		double xCenter = zCenter.re();
		double yCenter = zCenter.im();
		switch (x) {
		case -1: xCenter -= 2.0 * xSemiLength; break;
		case  0: break;
		case +1: xCenter += 2.0 * xSemiLength; break;
		}
		switch (y) {
		case -1: yCenter -= 2.0 * ySemiLength; break;
		case  0: break;
		case +1: yCenter += 2.0 * ySemiLength; break;
		}
		zCenter = new Complex(xCenter, yCenter);
	}

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
