package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.user.UserAssignedEvent;

public class GetUserAssignedEventAction extends GetEventAction {

    public GetUserAssignedEventAction(final AppDirectHandler handler) {
        super(handler);
    }

    public ActionResult<UserAssignedEvent> execute() {
        return super.executeAction(UserAssignedEvent.class);
    }
}
