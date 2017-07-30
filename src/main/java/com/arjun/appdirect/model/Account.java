package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
    private Long accountIdentifier;
    public Long getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(Long accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
