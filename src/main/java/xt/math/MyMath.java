package xt.math;

public class MyMath {
	
	public static double sq(double x)
	{
		return x * x;
	}
	
	public static double sqcosdemi(double x)
	{
		return sq(Math.cos(x / 2.0));
	}
	
	public static double baryseg(double a, double f, double g)
	{
		return (1.0 - a) * f + a * g;
	}

	public static double smooth(double x)
	{
		double y = 1.0 - Math.log(Math.log(x)) / Math.log(2.0);
		return y;
	}
	
	public static double ff(double x)
	{
		return 1.0 / (1.0 + (x - 1.0) * (x - 1.0)) - 1.0 / (1.0 + (x + 1.0) * (x + 1.0));
	}
	
	public static Complex sin(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = Math.sin(x) * Math.cosh(y);
		double yy = Math.cos(x) * Math.sinh(y);
		Complex zz = new Complex(xx, yy);
		return zz;
	}

	public static Complex cos(Complex z) {
		double x = z.re();
		double y = z.im();
		double xx = Math.cos(x) * Math.cosh(y);
		double yy = - Math.sin(x) * Math.sinh(y);
		Complex zz = new Complex(xx, yy);
		return zz;
	}
	
	public static Complex tan(Complex z) {
		return Complex.div(MyMath.sin(z), MyMath.cos(z));
	}
}
