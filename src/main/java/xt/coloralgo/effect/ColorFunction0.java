package xt.coloralgo.effect;

import xt.coloralgo.Palette;
import xt.math.Complex;

public class ColorFunction0 implements Effect {

	Palette palette;
	ArgPalette a;
	
	public ColorFunction0(double phase) {
		palette = new Palette(0xFF2222, 0x22FF22, 0x2222FF);
		a = new ArgPalette(palette, 1.0, phase);
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		return a.apply(iColor, z, i);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ColorFunction0");
		return builder.toString();
	}
}
