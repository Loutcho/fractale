package xt.math;

public class Complex {
	private double re;
	private double im;
	
	public static final Complex ZERO = new Complex(0.0, 0.0);
	public static final Complex I = new Complex(0.0, 1.0);

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public static Complex polar(double rho, double theta) {
		return Complex.mul(rho, Complex.ei(theta));
	}
	
	public double re() {
		return re;
	}
	
	public double im() {
		return im;
	}
	
	public static Complex add(Complex z1, Complex z2) {
		return new Complex(z1.re + z2.re, z1.im + z2.im);
	}
	
	public static Complex sub(Complex z1, Complex z2) {
		return new Complex(z1.re - z2.re, z1.im - z2.im);
	}

	public Complex neg() {
		return new Complex(-re, -im);
	}
	
	public Complex conj() {
		return new Complex(re, -im);
	}

	public double abs() {
		return Math.sqrt(re * re + im * im);
	}
	
	public Complex inv() {
		double r = 1.0 / abs();
		return mul(r * r, conj()); 
	}
	
	public static Complex mul(double k, Complex z) {
		return new Complex(k * z.re, k * z.im);
	}
	
	public static Complex mul(Complex z1, Complex z2) {
		return new Complex(z1.re * z2.re - z1.im * z2.im, z1.re * z2.im + z1.im * z2.re);
	}
	
	public static Complex div(Complex z1, Complex z2) {
		return mul(z1, z2.inv());
	}
	
	public double arg() {
		return Math.atan2(im, re);
	}
	
	public static Complex ei(double t) {
		return new Complex(Math.cos(t), Math.sin(t));
	}
	
	public static Complex power(Complex z, double n) {
		double rho;
		double theta;
		if (n == 2.0) {
			return Complex.mul(z, z);
		} else {
			rho = z.abs();
			theta = z.arg();
			rho = Math.pow(rho, n);
			theta = n * theta;
			return polar(rho, theta);
		}
	}

	@Override
	public String toString() {
		int xx = (int) re;
		double x = (double) xx;
		int yy = (int) im;
		double y = (double) yy;
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		if (x == re) {
			builder.append(xx);
		} else {
			builder.append(re);
		}
		builder.append(", ");
		if (y == im) {
			builder.append(yy);
		} else {
			builder.append(im);
		}
		builder.append(")");
		return builder.toString();
	}
}
