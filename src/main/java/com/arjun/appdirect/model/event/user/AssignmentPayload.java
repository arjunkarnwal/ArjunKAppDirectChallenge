package com.arjun.appdirect.model.event.user;

import javax.xml.bind.annotation.XmlRootElement;

import com.arjun.appdirect.model.Account;
import com.arjun.appdirect.model.User;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlRootElement(name = "payload")
public class AssignmentPayload {
    Account account;
    User user;
    
    public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
