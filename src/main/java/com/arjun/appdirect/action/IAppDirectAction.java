package com.arjun.appdirect.action;

public interface IAppDirectAction {
   <T> ActionResult<T> executeAction(Class<T> resultType);
}
