package xt.coloralgo;

public class GradientWithModulus {

	boolean activated;
	double attenuation[];
	
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

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public double getAttenuation(int iColor) {
		return attenuation[iColor];
	}
}
