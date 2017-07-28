package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;

public abstract class AppDirectAction implements IAppDirectAction {

    protected AppDirectHandler client;

    public AppDirectAction(AppDirectHandler client) {
        this.client = client;
    }
}
