package com.arjun.appdirect.action;

public interface IAppDirectAction {
   <T> ActionResult<T> execute(Class<T> resultType);
}
