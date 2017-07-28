package com.arjun.appdirect.model.event;

import com.arjun.appdirect.model.Marketplace;
import com.arjun.appdirect.model.User;

import lombok.Data;

@Data
public abstract class Event {
    private EventType type;
    public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	private Marketplace marketplace;
    private User creator;

    public Event(EventType type) {
        this.type = type;
    }
}
