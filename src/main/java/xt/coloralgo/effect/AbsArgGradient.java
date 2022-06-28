package xt.coloralgo.effect;

import xt.coloralgo.Effect;
import xt.coloralgo.Palette;
import xt.math.MyMath;

public class AbsArgGradient implements Effect {

	private boolean activated;
	
	public AbsArgGradient() {
		activated = true;
	}
	
	@Override
	public double apply(double x, Palette palette, int iColor, double iReel, double theta, double modifiedDivergence) {
		if (activated) {
			return x * Math.max((1.0 + MyMath.sqcosdemi(theta + iColor * Math.PI / 2.0)) / 2.0, (1.0 + modifiedDivergence) / 2.0);
		} else {
			return x;
		}
		
	}

}
