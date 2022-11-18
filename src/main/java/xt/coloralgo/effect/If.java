package xt.coloralgo.effect;

import xt.coloralgo.booleanexpression.BooleanExpression;
import xt.math.Complex;

public class If implements Effect {

	private BooleanExpression condition;
	private Effect thenEffect;
	private Effect elseEffect;
	
	public static If IF(BooleanExpression condition, Effect thenEffect, Effect elseEffect) {
		return new If(condition, thenEffect, elseEffect);
	}
	
	public If(BooleanExpression condition, Effect thenEffect, Effect elseEffect) {
		this.condition = condition;
		this.thenEffect = thenEffect;
		this.elseEffect = elseEffect;
	}

	@Override
	public double apply(int iColor, Complex z, int i) {
		Effect effect = condition.evaluate(i, z) ? thenEffect : elseEffect; 
		return effect.apply(iColor, z, i);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("if(");
		builder.append(condition);
		builder.append(" then ");
		builder.append(thenEffect);
		builder.append(" else ");
		builder.append(elseEffect);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void multiplyPeriod(double coef) {
		thenEffect.multiplyPeriod(coef);
		elseEffect.multiplyPeriod(coef);
	}

	@Override
	public void incrementPhase(double deltaPhase) {
		thenEffect.incrementPhase(deltaPhase);
		elseEffect.incrementPhase(deltaPhase);
	}

	@Override
	public void multiplyThreshold(double coef) {
		condition.multiplyThreshold(coef);
		thenEffect.multiplyThreshold(coef);
		elseEffect.multiplyThreshold(coef);
	}
}
