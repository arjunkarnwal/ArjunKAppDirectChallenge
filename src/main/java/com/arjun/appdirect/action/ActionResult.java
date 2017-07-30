package com.arjun.appdirect.action;


public class ActionResult<T> {

	private T entity;
    private boolean success;
    private String errorMessage;

    public ActionResult() {}

    public ActionResult(T entity) {
        this.entity = entity;
    }
    
    public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
