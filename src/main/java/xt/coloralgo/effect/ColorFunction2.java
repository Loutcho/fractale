package xt.coloralgo.effect;

import xt.math.Complex;

public class ColorFunction2 implements Effect {

	private static final double THRESHOLD = 0.995;
	private boolean radialSeparation;
	private boolean angularSeparation;
	
	public ColorFunction2(boolean radialSeparation, boolean angularSeparation) {
		this.radialSeparation = radialSeparation;
		this.angularSeparation = angularSeparation;
	}
	
	private static int nbBits(int n) {
		if (n == 0) {
			return 1;
		} else {
			int i = 0;
			while (n != 0) {
				n = (n >> 1);
				i ++;
			}
			return i;
		}
	}
	
	private static boolean isBitSet(int n, int b) {
		return (n & (1 << b)) != 0;
	}
	
	@Override
	public double apply(int iColor, Complex z, double iReel) {
		double rr = z.abs();
		if (radialSeparation && Math.abs(Math.sin(Math.PI * rr)) >= THRESHOLD) {
			return 1.0;
		}
		int r = (int) Math.rint(rr);
		double n = (double) nbBits(r);
		double theta = z.arg();
		if (theta < 0.0) {
			theta += 2.0 * Math.PI;
		}
		if (angularSeparation && Math.cos(theta) >= THRESHOLD) {
			return 1.0;
		}
		int b = (int) Math.floor(n * theta / (2.0 * Math.PI));
		return (isBitSet(r, b) && (r % 3 == iColor) ? 1.0 : 0.0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("new ColorFunction2()");
		return builder.toString();
	}
}
