package com.arjun.appdirect.action;

import lombok.experimental.Builder;

import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionOrderEvent;

public class GetSubscriptionOrderEventAction extends GetEventAction {

    public GetSubscriptionOrderEventAction(final AppDirectHandler client) {
        super(client);
    }

    public ActionResult<SubscriptionOrderEvent> execute() {
        return execute(SubscriptionOrderEvent.class);
    }
}
