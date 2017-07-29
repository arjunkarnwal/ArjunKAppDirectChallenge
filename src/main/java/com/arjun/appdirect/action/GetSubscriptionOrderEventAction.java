package com.arjun.appdirect.action;

import lombok.experimental.Builder;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionOrderEvent;

public class GetSubscriptionOrderEventAction extends GetEventAction {

    public GetSubscriptionOrderEventAction(final AppDirectHandler handler) {
        super(handler);
    }

    public ActionResult<SubscriptionOrderEvent> execute() {
        return executeAction(SubscriptionOrderEvent.class);
    }
}
