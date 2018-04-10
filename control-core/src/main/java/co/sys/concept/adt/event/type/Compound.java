package co.sys.concept.adt.event.type;

import co.sys.concept.adt.state.type.i.Sum;

import java.util.Map;
import java.util.Optional;

public interface Compound<E, M> {

    Compound set(Compound<E, M> compound);

    Compound set(Map<E, M> m);

    Compound set(Sum<Map<E, M>, Sum<E, M>> f);

    Optional<? super E> getAtom();

    Optional<? super Map<E, M>> getCompound();

}
