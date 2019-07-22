package xt.coloralgo;

import java.awt.Color;

import xt.math.MyMath;
import xt.math.Complex;

public class HueArg implements FunctionColorAlgo {

	private boolean absGrid;
	private boolean argGrid;
	private boolean absGradient;
	
	public HueArg(boolean absGrid, boolean argGrid, boolean absGradient)
	{
		this.absGrid = absGrid;
		this.argGrid = argGrid;
		this.absGradient = absGradient;
	}
	
	public Color getColor(Complex pixel) {

		double r = Complex.abs(pixel);
		double theta = Complex.arg(pixel);
		double tt = Math.pow(MyMath.sqcosdemi(6.0 * theta), 0.25);
		double rr = Math.pow(MyMath.sqcosdemi(2.0 * Math.PI * Math.log(r)), 0.25);
		//double rr = Math.pow(MyMath.sqcosdemi(2.0 * Math.PI * r), 0.25);

		double[] rvb = new double[3];
		for (int i = 0; i < 3; i ++)
		{
			rvb[i] = MyMath.sqcosdemi(theta + i * 2.0 * Math.PI / 3.0);
			if (absGradient)
			{
				rvb[i] = Math.pow(rvb[i], Math.pow(4.0, - Math.atan(Math.log(r)) / (Math.PI / 2.0)));
				//rvb[i] = Math.pow(rvb[i], Math.pow(4.0, - Math.atan(r) / (Math.PI / 2.0)));
			}
			if (argGrid)
			{
				rvb[i] = MyMath.baryseg(tt, 1.0, rvb[i]);
			}
			if (absGrid)
			{
				rvb[i] = MyMath.baryseg(rr, 0.0, rvb[i]);
			}
		}
		
		return new Color((int)(255.0 * rvb[0]), (int)(255.0 * rvb[1]), (int)(255.0 * rvb[2]));
	}
	
	public void processKeyEvent(int key)
	{
	}
}
