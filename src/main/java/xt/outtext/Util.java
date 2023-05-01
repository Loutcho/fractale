package xt.outtext;

public class Util {

	private static final double R = 0.1;
	
	public static double nearZero(Double d) {
		if (Math.abs(d) <= R) {
			double x = d / R;
			return Math.sqrt(1.0 - x * x);
		} else {
			return 0.0;
		}
	}
}
