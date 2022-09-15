package xt.function;

import xt.math.Complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class NaiveZeta implements Function<Complex, Complex> {

	RationalFraction r;

	public NaiveZeta() {
		Map<Integer, List<Complex>> p = new HashMap<Integer, List<Complex>>();
		List<Complex> l;

		l = new ArrayList<Complex>();
		// triviaux :
		for (int n = 1; n <= 12; n ++) {
			l.add(new Complex(-2.0 * n, 0));
		}
		// non triviaux :
		l.add(new Complex(0.5, +14.134725141734693790457251983562470270784257115699243175685567460149));
		l.add(new Complex(0.5, -14.134725141734693790457251983562470270784257115699243175685567460149));
		l.add(new Complex(0.5, +21.022039638771554992628479593896902777334340524902781754629520403587));
		l.add(new Complex(0.5, -21.022039638771554992628479593896902777334340524902781754629520403587));
		l.add(new Complex(0.5, +25.010857580145688763213790992562821818659549672557996672496542006745));
		l.add(new Complex(0.5, -25.010857580145688763213790992562821818659549672557996672496542006745));
		l.add(new Complex(0.5, +30.424876125859513210311897530584091320181560023715440180962146036993));
		l.add(new Complex(0.5, -30.424876125859513210311897530584091320181560023715440180962146036993));
		l.add(new Complex(0.5, +32.935061587739189690662368964074903488812715603517039009280003440784));
		l.add(new Complex(0.5, -32.935061587739189690662368964074903488812715603517039009280003440784));
		l.add(new Complex(0.5, +37.586178158825671257217763480705332821405597350830793218333001113622));
		l.add(new Complex(0.5, -37.586178158825671257217763480705332821405597350830793218333001113622));
		p.put(0, l);

		l = new ArrayList<Complex>();
		l.add(new Complex(1.0, 0.0));
		p.put(1, l);
		
		r = new RationalFraction(p.get(0), p.get(1));
	}
	
	public Complex apply(Complex z) {
		return r.apply(z);
	}
}
