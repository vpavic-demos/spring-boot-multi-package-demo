package co.sys.concept.adt.state.type.i;

import java.util.function.Function;

public final class Left<A, B> implements Sum<A, B> {

    private final A value;

    public Left(A value) {
        this.value = value;
    }

    @Override
    public <R> R get(Function<A, R> left, Function<B, R> right) {
        return left.apply(value);
    }
}
