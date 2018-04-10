package co.sys.concept.adt.state.type.i;

import java.util.function.Function;

public interface Sum<A, B> {
    <R> R get(Function<A, R> left, Function<B, R> right);
}


