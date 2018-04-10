package co.sys.concept.adt.context.type;

import java.util.LinkedHashMap;

public abstract class StateSequence extends State{

    private LinkedHashMap<State, StateCompound> states;

    public StateSequence(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
    }

    public StateSequence() {
        this.states = new LinkedHashMap<>();
    }

    public StateSequence(State state) {
        this.states = new LinkedHashMap<>();
        this.states.put(state, null);
    }

    public LinkedHashMap<State, StateCompound> getStates() {
        return states;
    }

    public void setstates(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
    }

    public StateCompound get(State State){
        return states.get(State);
    }
}
