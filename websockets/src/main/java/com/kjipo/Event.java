package com.kjipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;
    private String message;

    public Event(String message) {
        this.message = message;
    }

    protected Event() {

    }


    public long getEventId() {
        return eventId;
    }


    public String getMessage() {
        return getMessage();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return eventId == event.eventId && Objects.equals(message, event.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, message);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventDt='" + message + '\'' +
                '}';
    }
}
