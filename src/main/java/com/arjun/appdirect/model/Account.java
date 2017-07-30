package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "account")
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
