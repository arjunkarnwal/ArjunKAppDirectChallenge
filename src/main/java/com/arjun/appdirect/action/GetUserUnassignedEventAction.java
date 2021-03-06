package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.user.UserUnassignedEvent;

public class GetUserUnassignedEventAction extends AppDirectAction {

    public GetUserUnassignedEventAction(final AppDirectHandler handler, final String url, final String token) {
        super(handler, url, token);
    }

    public ActionResult<UserUnassignedEvent> execute() {
        return super.executeAction(UserUnassignedEvent.class);
    }
}
