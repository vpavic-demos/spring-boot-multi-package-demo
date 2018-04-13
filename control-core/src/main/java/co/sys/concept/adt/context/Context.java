package co.sys.concept.adt.context;

import co.sys.concept.adt.state.type.Sum;

import java.util.Optional;

public abstract class Context {

	public abstract Sum getMapOrSum();

	public abstract Optional getAtomicEvent();

	public abstract Optional getAtomicState();
}
