package xt.coloralgo;

public class PaletteUtils {

	public static double apply(Palette palette, int iColor, double x) {
		if (x < 0.0 || x > 1.0) {
			throw new IllegalStateException();
		}
		int n = palette.getNbColors();
		int i = ((int)(n * x)) % n;
		int j = (i + 1) % n;
		int shift = (8 * (2 - iColor));
		double t = n * x - i;
		if (t == 2.0) { t = t - 1.0; }
		if (t < 0.0 || t > 1.0) {
			throw new IllegalStateException("t = " + t);
		}
		int mask = getMask(iColor);
		int vali = (palette.getColor(i) & mask) >> shift;
		double alpha = ((double)vali) / 255.0;
		if (alpha < 0.0 || alpha > 1.0) {
			throw new IllegalStateException("alpha = " + alpha);
		}
		int valj = (palette.getColor(j) & mask) >> shift;
		double beta = ((double)valj) / 255.0;
		if (beta < 0.0 || beta > 1.0) {
			throw new IllegalStateException("beta = " + beta);
		}
		double result = (1.0 - t) * alpha + t * beta;
		if (result < 0.0 || result > 1.0) {
			throw new IllegalStateException("result = " + result);
		}
		return result;
	}
	
	public static double cyclicApply(Palette palette, int iColor, double x) {
		x -= Math.floor(x);
		return apply(palette, iColor, x);
	}
	
	private static int getMask(int iColor) {
		switch (iColor) {
		case 0: return 0xFF0000;
		case 1: return 0x00FF00;
		case 2: return 0x0000FF;
		default:
			return 0xFF0000;
		}
	}
}
