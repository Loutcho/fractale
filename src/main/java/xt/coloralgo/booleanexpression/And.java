package xt.coloralgo.booleanexpression;

import java.util.ArrayList;
import java.util.List;

import xt.math.Complex;

public class And implements BooleanExpression {

	private List<BooleanExpression> booleanExpressions;
	
	public And(BooleanExpression... booleanExpressions) {
		this.booleanExpressions = new ArrayList<BooleanExpression>();
		for (int i = 0; i < booleanExpressions.length; i ++) {
			this.booleanExpressions.add(booleanExpressions[i]);
		}
	}

	@Override
	public boolean evaluate(int i, Complex z) {
		for (BooleanExpression e : booleanExpressions) {
			boolean q = e.evaluate(i, z);
			if (! q) {
				return false;
			}
		}
		return true;
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
		builder.append("and(");
		builder.append(booleanExpressions);
		builder.append(")");
		return builder.toString();
	}
}
