package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.user.UserAssignedEvent;

public class GetUserAssignedEventAction extends GetEventAction {

    public GetUserAssignedEventAction(final AppDirectHandler client) {
        super(client);
    }

    public ActionResult<UserAssignedEvent> execute() {
        return super.execute(UserAssignedEvent.class);
    }
}
