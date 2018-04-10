package co.sys.concept.adt.context.type;

import java.util.LinkedHashMap;

public abstract class EventSequence extends Event{

    private LinkedHashMap<Event, EventCompound> events;

    public EventSequence(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
    }

    public EventSequence() {
        this.events = new LinkedHashMap<>();
    }

    public EventSequence(Event event) {
        this.events = new LinkedHashMap<>();
        this.events.put(event, null);
    }

    public LinkedHashMap<Event, EventCompound> getEvents() {
        return events;
    }

    public void setEvents(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
    }

    public EventCompound get(Event event){
        return events.get(event);
    }
}
