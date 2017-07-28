package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.eheiker.appdirect.domain.appdirect.event.subscription.SubscriptionCancelEvent;

public class GetSubscriptionCancelEventAction extends GetEventAction {

    public GetSubscriptionCancelEventAction(final AppDirectHandler client) {
        super(client);
    }

    public ActionResult<SubscriptionCancelEvent> execute() {
        return execute(SubscriptionCancelEvent.class);
    }
}
