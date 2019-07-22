package xt.math;

public class Complex
{
	private double re;
	private double im;

	public Complex(double re, double im)
	{
		this.re = re;
		this.im = im;
	}
	
	public String toString()
	{
		return "(" + re + ", " + im + ")";
	}

	public double re()
	{
		return re;
	}
	
	public double im()
	{
		return im;
	}
	
	public static Complex add(Complex z1, Complex z2)
	{
		return new Complex(z1.re + z2.re, z1.im + z2.im);
	}
	
	public static Complex sub(Complex z1, Complex z2)
	{
		return new Complex(z1.re - z2.re, z1.im - z2.im);
	}

	public static Complex neg(Complex z)
	{
		return new Complex(-z.re, -z.im);
	}
	
	public static Complex conj(Complex z)
	{
		return new Complex(z.re, -z.im);
	}
	
	public static double abs(Complex z)
	{
		return Math.sqrt(z.re * z.re + z.im * z.im);
	}
	
	public static Complex inv(Complex z)
	{
		double r = 1.0 / abs(z);
		return mul(r * r, conj(z)); 
	}
	
	public static Complex mul(double k, Complex z)
	{
		return new Complex(k * z.re, k * z.im);
	}
	
	public static Complex mul(Complex z1, Complex z2)
	{
		return new Complex(z1.re * z2.re - z1.im * z2.im, z1.re * z2.im + z1.im * z2.re);
	}
	
	public static Complex div(Complex z1, Complex z2)
	{
		return mul(z1, inv(z2));
	}
	
	public static double arg(Complex z)
	{
		/*
		if (z.im == 0.0)
		{
			if (z.re >= 0.0)
			{
				return 0.0;
			}
			else
			{
				return Math.PI;
			}
		}
			
		return Math.atan(z.im / z.re);
		*/
		return Math.atan2(z.im, z.re);
	}
	
	public static Complex ei(double t)
	{
		return new Complex(Math.cos(t), Math.sin(t));
	}
	
	public static Complex power(Complex z, double n)
	{
		double rho;
		double theta;
		
		if (n == 2.0)
		{
			return Complex.mul(z, z);
		}
		else
		{
			rho = Complex.abs(z);
			theta = Complex.arg(z);
			rho = Math.pow(rho, n);
			theta = n * theta;
			return Complex.mul(rho, Complex.ei(theta));
		}
	}
}
