package xt.coloralgo;

public class GradientWithModulus {

	final boolean activated;
	final double attenuation[];
	
	public GradientWithModulus(boolean activated, double redAttenuation, double greenAttenuation, double blueAttenuation) {
		this.activated = activated;
		attenuation = new double[3];
		attenuation[0] = redAttenuation;
		attenuation[1] = greenAttenuation;
		attenuation[2] = blueAttenuation;
	}

	public boolean isActivated() {
		return activated;
	}

	public double getAttenuation(int iColor) {
		return attenuation[iColor];
	}
	
	private GradientWithModulus() {
		activated = false;
		attenuation = null;
	}
	
	public static final GradientWithModulus NONE = new GradientWithModulus();
}
