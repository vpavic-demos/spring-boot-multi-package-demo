package co.sys.concept.adt.context.type;

import java.util.LinkedHashMap;

public abstract class MultiEvent extends Event{

    private LinkedHashMap<Event, EventCompound> events;

    public MultiEvent(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
    }

    public MultiEvent() {
        this.events = new LinkedHashMap<>();
    }

    public MultiEvent(Event event) {
        this.events = new LinkedHashMap<>();
        this.events.put(event, new EventCompound(event));
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
