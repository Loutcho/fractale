package xt.coloralgo;

public class PowerEffect {

	boolean activated;
	double power;

	public PowerEffect(double power) {
		this.activated = true;
		this.power = power;
	}
	
	private PowerEffect() {
		this.activated = false;
	}

	public boolean isActivated() {
		return activated;
	}	
	
	public double getPower() {
		return power;
	}
	
	public static final PowerEffect OFF = new PowerEffect();

}
