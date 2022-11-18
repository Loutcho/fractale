package xt.coloralgo.booleanexpression;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;

public class Or implements BooleanExpression {

	private List<BooleanExpression> booleanExpressions;
	
	public static Or OR(BooleanExpression... booleanExpressions) {
		return new Or(booleanExpressions);
	}
	
	public Or(BooleanExpression... booleanExpressions) {
		this.booleanExpressions = new ArrayList<BooleanExpression>();
		for (int i = 0; i < booleanExpressions.length; i ++) {
			this.booleanExpressions.add(booleanExpressions[i]);
		}
	}

	@Override
	public boolean evaluate(int i, Complex z) {
		for (BooleanExpression e : booleanExpressions) {
			boolean q = e.evaluate(i, z);
			if (q) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void multiplyThreshold(double coef) {
		for (int i = 0; i < booleanExpressions.size(); i ++) {
			booleanExpressions.get(i).multiplyThreshold(coef);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("or(");
		builder.append(booleanExpressions);
		builder.append(")");
		return builder.toString();
	}
}
