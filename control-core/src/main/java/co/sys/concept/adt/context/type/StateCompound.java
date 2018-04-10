package co.sys.concept.adt.context.type;

import co.sys.concept.adt.event.type.Compound;
import co.sys.concept.adt.state.type.i.Left;
import co.sys.concept.adt.state.type.i.Right;
import co.sys.concept.adt.state.type.i.Sum;

public class StateCompound<State, MultiState> implements Compound<State, MultiState> {

    private Sum<State, Sum<State, MultiState>> stateOrSum;

    @Override
    public Sum<State, Sum<State, MultiState>> getOrGetSum() {
        return stateOrSum;
    }

    @Override
    public Compound set(Compound<State, MultiState> compound) {
        return set(compound);
    }

    @Override
    @Deprecated
    public Compound set(State state, Sum<State, Sum<State, MultiState>> stateOrSum) {
        return set(stateOrSum);
    }


    @Override
    public Compound set(Sum<State, Sum<State, MultiState>> stateOrSum) {
        this.stateOrSum = stateOrSum;
        return this;
    }

    @Override
    public Compound set(State state) {
        return set(true, state);
    }

    public StateCompound set(Boolean left, State state) {
        this.stateOrSum = new Left<>(state);
        return this;
    }


    public StateCompound set(StateCompound<State, MultiState> stateCompound) {
        this.stateOrSum = stateCompound.getOrGetSum();
        return this;
    }


    public StateCompound set(State state, MultiState multiState) {
        set(multiState, true);
        return this;
    }

    public StateCompound set(MultiState multiState, Boolean right) {
        this.stateOrSum = new Right<>(new Right<>(multiState));
        return this;
    }

    //    Constructors
    public StateCompound(State state) {
        set(state);
    }

    public StateCompound(State state, MultiState multiState) {
        set(state, multiState);
    }

    public StateCompound(StateCompound stateCompound) {
        set(stateCompound);
    }

    public StateCompound(Sum<State, Sum<State, MultiState>> stateOrSum) {
        set(stateOrSum);
    }
}
