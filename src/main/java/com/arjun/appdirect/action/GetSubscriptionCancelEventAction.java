package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionCancelEvent;


public class GetSubscriptionCancelEventAction extends GetEventAction {

    public GetSubscriptionCancelEventAction(final AppDirectHandler handler) {
        super(handler);
    }

    public ActionResult<SubscriptionCancelEvent> execute() {
        return execute(SubscriptionCancelEvent.class);
    }
}
