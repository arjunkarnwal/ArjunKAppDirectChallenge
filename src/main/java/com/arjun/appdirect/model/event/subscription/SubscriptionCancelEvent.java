package com.arjun.appdirect.model.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.arjun.appdirect.model.event.Event;
import com.arjun.appdirect.model.event.EventType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "event")
public class SubscriptionCancelEvent extends Event {

    private SubscriptionCancelPayload payload;

    public SubscriptionCancelEvent() {
        super(EventType.SUBSCRIPTION_CANCEL);
    }
    
    public SubscriptionCancelPayload getPayload() {
		return payload;
	}

	public void setPayload(SubscriptionCancelPayload payload) {
		this.payload = payload;
	}

}
