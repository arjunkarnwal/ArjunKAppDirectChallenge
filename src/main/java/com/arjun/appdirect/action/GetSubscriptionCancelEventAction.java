package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionCancelEvent;


public class GetSubscriptionCancelEventAction extends AppDirectAction {

    public GetSubscriptionCancelEventAction(final String url, final String token) {
        super(url, token);
    }

    public ActionResult<SubscriptionCancelEvent> execute() {
        return executeAction(SubscriptionCancelEvent.class);
    }
}
