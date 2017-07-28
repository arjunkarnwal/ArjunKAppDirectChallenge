package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.user.UserUnassignedEvent;

public class GetUserUnassignedEventAction extends GetEventAction {

    public GetUserUnassignedEventAction(final AppDirectHandler client) {
        super(client);
    }

    public ActionResult<UserUnassignedEvent> execute() {
        return super.execute(UserUnassignedEvent.class);
    }
}
