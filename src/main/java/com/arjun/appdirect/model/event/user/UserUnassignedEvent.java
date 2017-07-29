package com.arjun.appdirect.model.event.user;

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
public class UserUnassignedEvent extends Event {

    private AssignmentPayload payload;

    public AssignmentPayload getPayload() {
		return payload;
	}

	public void setPayload(AssignmentPayload payload) {
		this.payload = payload;
	}

	public UserUnassignedEvent() {
        super(EventType.USER_UNASSIGNED);
    }
}
