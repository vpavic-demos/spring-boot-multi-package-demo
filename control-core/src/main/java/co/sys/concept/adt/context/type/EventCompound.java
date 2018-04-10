package co.sys.concept.adt.context.type;

import co.sys.concept.adt.event.type.Compound;
import co.sys.concept.adt.state.type.i.Left;
import co.sys.concept.adt.state.type.i.Right;
import co.sys.concept.adt.state.type.i.Sum;

public class EventCompound<Event, MultiEvent> implements Compound<Event, MultiEvent> {

    private Sum<Event, Sum<Event, MultiEvent>> eventOrSum;

    @Override
    public Sum<Event, Sum<Event, MultiEvent>> getOrGetSum() {
        return eventOrSum;
    }

    @Override
    public Compound set(Compound<Event, MultiEvent> compound) {
        return set(compound);
    }

    @Override
    @Deprecated
    public Compound set(Event event, Sum<Event, Sum<Event, MultiEvent>> eventOrSum) {
        return set(eventOrSum);
    }


    @Override
    public Compound set(Sum<Event, Sum<Event, MultiEvent>> eventOrSum) {
        this.eventOrSum = eventOrSum;
        return this;
    }

    @Override
    public Compound set(Event event) {
        return set(true, event);
    }

    public EventCompound set(Boolean left, Event event) {
        this.eventOrSum = new Left<>(event);
        return this;
    }



    public EventCompound set(EventCompound<Event, MultiEvent> eventCompound) {
        this.eventOrSum = eventCompound.getOrGetSum();
        return this;
    }


    public EventCompound set(Event event, MultiEvent multiEvent) {
        set(multiEvent, true);
        return this;
    }

    public EventCompound set(MultiEvent multiEvent, Boolean right) {
        this.eventOrSum = new Right<>(new Right<>(multiEvent));
        return this;
    }

    //    Constructors
    public EventCompound(Event event) {
        set(event);
    }

    public EventCompound(Event event, MultiEvent multiEvent) {
        set(event, multiEvent);
    }

    public EventCompound(EventCompound eventCompound) {
        set(eventCompound);
    }

    public EventCompound(Sum<Event, Sum<Event, MultiEvent>> eventOrSum) {
        set(eventOrSum);
    }
}
