package com.arjun.appdirect.model.event;

import com.arjun.appdirect.model.Marketplace;
import com.arjun.appdirect.model.User;

import lombok.Data;

@Data
public abstract class Event {
    private EventType type;
    private Marketplace marketplace;
    private User creator;

    public Event(EventType type) {
        this.type = type;
    }
}
