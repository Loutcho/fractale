package xt.outtext;

import java.util.function.Function;

public class Compose <T, U, V> implements Function<T, V> {
	
	/*
	 *      g           f
	 * T -------> U -------> V
	 * \___________________/
	 *          f o g 
	 */
	
	private Function<T, U> g;
	private Function<U, V> f;

	public Compose(Function<U, V> f, Function<T, U> g) {
		this.f = f;
		this.g = g;
	}

	@Override
	public V apply(T z) {
		return f.apply(g.apply(z));
	}
}
