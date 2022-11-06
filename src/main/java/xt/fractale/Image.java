package xt.fractale;

import xt.coloralgo.ColorAlgo;

public class Image {

	private ColorAlgo colorAlgo;
	private MathZone mathZone;
	
	public Image(ColorAlgo colorAlgo, MathZone mathZone) {
		this.colorAlgo = colorAlgo;
		this.mathZone = mathZone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image(");
		builder.append(colorAlgo);
		builder.append(", ");
		builder.append(mathZone);
		builder.append(")");
		return builder.toString();
	}
	
	public ColorAlgo getColorAlgo() {
		return colorAlgo;
	}

	public MathZone getMathZone() {
		return mathZone;
	}

	public void setMathZone(MathZone mathZone) {
		this.mathZone = mathZone;
	}
	
	public void multiplyPeriod(double coef) {
		colorAlgo.multiplyPeriod(coef);
	}
	
	public void incrementPhase(double deltaPhase) {
		colorAlgo.incrementPhase(deltaPhase);
	}
	
	public void multiplyThreshold(double d) {
		colorAlgo.multiplyThreshold(d);
	}
}
