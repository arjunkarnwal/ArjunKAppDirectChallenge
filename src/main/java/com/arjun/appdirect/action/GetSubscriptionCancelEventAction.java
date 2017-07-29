package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionCancelEvent;


public class GetSubscriptionCancelEventAction extends AppDirectAction {

    public GetSubscriptionCancelEventAction(final AppDirectHandler handler, final String url, final String token) {
        super(handler, url, token);
    }

    public ActionResult<SubscriptionCancelEvent> execute() {
        return executeAction(SubscriptionCancelEvent.class);
    }
}
