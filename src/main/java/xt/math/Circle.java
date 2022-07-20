package xt.math;

public class Circle {

	private Complex center;
	private double radius;
	
	public Circle(Complex center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public Complex getCenter() {
		return center;
	}

	public void setCenter(Complex center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}
}
