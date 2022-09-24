package xt.coloralgo;

public class Color extends java.awt.Color { // extends: just to overload toString()

	private static final long serialVersionUID = 1L;

	public Color(int rgb) {
		super(rgb);
	}
	
	public Color(int r, int g, int b) {
		super(r, g, b);
	}
	
	public static final Color BLACK = new Color(0x000000);
	public static final Color WHITE = new Color(0xFFFFFF);
	public static final Color BLUE  = new Color(0x0000FF);

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("0x%06X", getRGB() & 0xFFFFFF));
		return builder.toString();
	}
}
