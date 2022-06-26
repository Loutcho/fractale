package xt.coloralgo;

public class GradientBubble {

	private boolean activated;
	private double[] attenuation;
	
	public GradientBubble(boolean activated, double redAttenuation, double greenAttenuation, double blueAttenuation) {
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
}
