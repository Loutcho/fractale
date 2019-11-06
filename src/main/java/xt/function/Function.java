package xt.function;

import xt.math.Complex;

public interface Function {
	Complex apply(Complex z);
	String getHumanReadableFormula();
}
