package xt.fractale;

public class PixelZone {
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;
	
	public PixelZone(int width, int height) {
		this.xMin = 0;
		this.yMin = 0;
		this.xMax = width - 1;
		this.yMax = height - 1;
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(int yMin) {
		this.yMin = yMin;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
}
