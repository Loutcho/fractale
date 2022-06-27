package xt.coloralgo;

public class GradientWithArgument {

	boolean activated;
	double attenuation[];
	
	public GradientWithArgument(double redAttenuation, double greenAttenuation, double blueAttenuation) {
		activated = true;
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
	
	private GradientWithArgument() {
		activated = false;
	}
	
	public static final GradientWithArgument OFF = new GradientWithArgument();
}
