package xt.coloralgo;

public class GradientWithIteration {

	private boolean activated;
	private double tau;
	private double iBase;
	
	public GradientWithIteration(double tau, double iBase) {
		this.activated = true;
		this.tau = tau;
		this.iBase = iBase;
	}

	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public double getTau() {
		return tau;
	}

	public double getiBase() {
		return iBase;
	}
	
	private GradientWithIteration() {
		activated = false;
	}
	
	public static final GradientWithIteration OFF = new GradientWithIteration();
}
