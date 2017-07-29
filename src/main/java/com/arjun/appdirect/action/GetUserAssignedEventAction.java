package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.user.UserAssignedEvent;

public class GetUserAssignedEventAction extends AppDirectAction {

    public GetUserAssignedEventAction(final String url, final String token) {
        super(url, token);
    }

    public ActionResult<UserAssignedEvent> execute() {
        return super.executeAction(UserAssignedEvent.class);
    }
}
