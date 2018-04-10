package co.sys.concept.adt.state.type.i;

import java.util.function.Function;

public class Right<A, B> implements Sum<A,B> {

    private final B value;

    public Right(B value) {
        this.value = value;
    }

    @Override
    public <R> R get(Function<A, R> left, Function<B, R> right) {
        return right.apply(value);
    }
}
