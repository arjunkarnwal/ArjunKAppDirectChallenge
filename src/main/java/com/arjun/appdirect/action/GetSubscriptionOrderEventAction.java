package com.arjun.appdirect.action;


import com.arjun.appdirect.handler.AppDirectHandler;
import com.arjun.appdirect.model.event.subscription.SubscriptionOrderEvent;

public class GetSubscriptionOrderEventAction extends AppDirectAction {

    public GetSubscriptionOrderEventAction(final AppDirectHandler handler, final String url, final String token) {
        super(handler, url, token);
    }

    public ActionResult<SubscriptionOrderEvent> execute() {
        return executeAction(SubscriptionOrderEvent.class);
    }
}
