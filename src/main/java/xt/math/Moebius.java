package xt.math;

public class Moebius {

	private Complex a, b, c, d;
	
	public Moebius(Complex a, Complex b, Complex c, Complex d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public static Moebius mul(Moebius u, Moebius v) {
		Complex wa = Complex.add(Complex.mul(u.a, v.a), Complex.mul(u.b, v.c));
		Complex wb = Complex.add(Complex.mul(u.a, v.b), Complex.mul(u.b, v.d));
		Complex wc = Complex.add(Complex.mul(u.c, v.a), Complex.mul(u.d, v.c));
		Complex wd = Complex.add(Complex.mul(u.c, v.b), Complex.mul(u.d, v.d));
		Moebius w = new Moebius(wa, wb, wc, wd);
		return w;
	}
	
	public Complex onPoint(Complex z) {
		// TODO: manage division by 0, manage z = infinity
		return Complex.div(Complex.add(Complex.mul(a, z), b), Complex.add(Complex.mul(c, z), d));
	}
	
	public Circle onCircle(Circle circle) {
		Complex center = circle.getCenter();
		double radius = circle.getRadius();
		Complex r = new Complex(radius, 1.0);
		Complex z = Complex.sub(center, Complex.div(new Complex(radius * radius, 0.0), (Complex.add(center, Complex.div(d, c))).conj()));
		Complex center2 = Complex.div(Complex.add(Complex.mul(a, z), b), Complex.add(Complex.mul(c, z), d));
		double radius2 = Complex.sub(
				center2,
				Complex.div(
						Complex.add(Complex.mul(a, Complex.add(center, r)), b),
						Complex.add(Complex.mul(c, Complex.add(center, r)), d)
				)
		).abs();
		return new Circle(center2, radius2);
	}
}
