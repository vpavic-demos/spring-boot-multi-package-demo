package co.sys.concept.adt.context.type;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class MultiState extends State{

    private LinkedHashMap<State, StateCompound> states;

    public MultiState(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
    }

    public MultiState() {
        this.states = new LinkedHashMap<>();
    }

    public LinkedHashMap<State, StateCompound> getStates() {
        return states;
    }

    public void setStates(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
    }

    public StateCompound get(State state) {
        return this.states.get(state);
    }
}
