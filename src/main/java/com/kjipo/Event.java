package com.kjipo;

import java.util.Objects;

public class Event {
    private String eventId;
    private String eventDt;

    public Event(String eventId, String eventDt) {
        this.eventId = eventId;
        this.eventDt = eventDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId) && Objects.equals(eventDt, event.eventDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventDt);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventDt='" + eventDt + '\'' +
                '}';
    }
}
