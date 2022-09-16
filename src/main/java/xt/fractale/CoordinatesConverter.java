package xt.fractale;

import xt.math.Complex;

public class CoordinatesConverter {

	private MathZone mathZone;
	private PixelZone pixelZone;
	
	public CoordinatesConverter(MathZone mathZone, PixelZone pixelZone) {
		this.mathZone = mathZone;
		this.pixelZone = pixelZone;
	}

	/*
	public Complex fromMathToPixel(Complex z) {
		Complex z0 = mathZone.getzCenter();
		double theta = mathZone.getRotationAngle();
		double lambda = mathZone.getxSemiLength();
		double mu = mathZone.getySemiLength();
		double xMax = pixelZone.getxMax();
		double yMax = pixelZone.getyMax();
		
		Complex zz = Complex.mul(Complex.ei(-theta), Complex.sub(z, z0));
		double xx = zz.re();
		double yy = zz.im();
		double xxx = (xMax / 2.0) * (1 + xx / lambda);
		double yyy = (yMax / 2.0) * (1 - yy / mu);
		Complex zzz = new Complex(xxx, yyy); 
		return zzz;
	}
	*/

	public Complex fromPixelToMath(Complex zzz) {
		Complex z0 = mathZone.getzCenter();
		double theta = mathZone.getRotationAngle();
		double lambda = mathZone.getxSemiLength();
		double mu = mathZone.getySemiLength();
		double xMax = pixelZone.getxMax();
		double yMax = pixelZone.getyMax();

		double xxx = zzz.re();
		double yyy = zzz.im();
		double xx = lambda * (2.0 * xxx / xMax - 1.0);
		double yy = mu * (1.0 - 2.0 * yyy / yMax);
		Complex zz = new Complex(xx, yy);
		Complex z = Complex.add(z0, Complex.mul(Complex.ei(theta), zz));
		return z;
	}
}
