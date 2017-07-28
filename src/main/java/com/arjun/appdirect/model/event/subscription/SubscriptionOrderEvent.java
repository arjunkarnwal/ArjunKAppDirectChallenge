package com.arjun.appdirect.model.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.arjun.appdirect.model.event.Event;
import com.arjun.appdirect.model.event.EventType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "event")
public class SubscriptionOrderEvent extends Event {

    private SubscriptionOrderPayload payload;

    public SubscriptionOrderEvent() {
        super(EventType.SUBSCRIPTION_ORDER);
    }
}
