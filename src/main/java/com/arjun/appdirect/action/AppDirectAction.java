package com.arjun.appdirect.action;

import com.arjun.appdirect.handler.AppDirectHandler;

public abstract class AppDirectAction implements IAppDirectAction {

    protected AppDirectHandler handler;

    public AppDirectAction(AppDirectHandler handler) {
        this.handler = handler;
    }
}
