package co.sys.concept.adt.event.type;

import co.sys.concept.adt.state.type.i.Sum;

public interface Compound<E, M> {

    Sum<E, Sum<E, M>> getOrGetSum();

    Compound set(Compound<E, M> compound);

    Compound set(E o, Sum<E, Sum<E, M>> c);

    Compound set(E o);

    Compound set(Sum<E, Sum<E, M>> c);

}
