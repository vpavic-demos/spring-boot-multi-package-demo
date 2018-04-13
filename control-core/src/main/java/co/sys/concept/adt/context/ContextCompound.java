package co.sys.concept.adt.context;

import co.sys.concept.adt.event.type.i.Compound;
import co.sys.concept.adt.state.type.Sum;

import java.util.Map;
import java.util.Optional;

public class ContextCompound<Event, State> extends Context implements Compound<Event, State>{

	private Sum<Map<Event, State>, Sum<Event, State>> mapOrSum;

	@Override
	public Sum<Map<Event, State>, Sum<Event, State>> getMapOrSum() {
		return mapOrSum;
	}

	public void setMapOrSum(Sum<Map<Event, State>, Sum<Event, State>> mapOrSum) {
		this.mapOrSum = mapOrSum;
	}

	@Override
	public Optional<? super Event> getAtomicEvent() {
		return mapOrSum.fromRight()
				.map(e -> {
					if (e.isLeft()) {
						return Optional.of(e);
					} else {
						return Optional.empty();
					}
				});
	}

	@Override
	public Optional<? super Event> getAtom() {
		return this.getAtomicEvent();
	}

	@Override
	public Optional<? super State> getAtomicState() {
		return mapOrSum.fromRight()
				.map(s -> {
					if (s.isRight()) {
						return Optional.of(s);
					} else {
						return Optional.empty();
					}
				});
	}


	@Override
	public Optional<? super Map<Event, State>> getCompound() {
		return mapOrSum.fromLeft();
	}

	@Override
	public Compound set(Compound<Event, State> compound) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Compound set(Map<Event, State> m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Compound set(Sum<Map<Event, State>, Sum<Event, State>> f) {
		throw new UnsupportedOperationException();
	}


}
