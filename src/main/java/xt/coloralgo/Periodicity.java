package xt.coloralgo;

public class Periodicity {
	boolean activated;
	double period[];
	double phase[];
	
	public Periodicity(
			double redPeriod, double redPhase,
			double greenPeriod, double greenPhase,
			double bluePeriod, double bluePhase) {
		activated = true;
		period = new double[3];
		phase = new double[3];
		period[0] = redPeriod;
		period[1] = greenPeriod;
		period[2] = bluePeriod;
		phase[0] = redPhase;
		phase[1] = greenPhase;
		phase[2] = bluePhase;
	}
	
	public Periodicity(double period) {
		activated = true;
		this.period = new double[3];
		phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		phase[0] = 0.0;
		phase[1] = 0.0;
		phase[2] = 0.0;
	}
	
	public Periodicity(double period, double phase) {
		activated = true;
		this.period = new double[3];
		this.phase = new double[3];
		this.period[0] = period;
		this.period[1] = period;
		this.period[2] = period;
		this.phase[0] = phase;
		this.phase[1] = phase;
		this.phase[2] = phase;
	}

	private Periodicity() {
		activated = false;
	}
	
	public static final Periodicity OFF = new Periodicity();
	
	public boolean isActivated() {
		return activated;
	}
	
	public double getPeriod(int iColor) {
		return period[iColor];
	}
	
	public double getPhase(int iColor) {
		return phase[iColor];
	}
}
