package com.arjun.appdirect.model.event.user;

import com.arjun.appdirect.model.Account;
import com.arjun.appdirect.model.UserAddress;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UnAssignmentPayload {
	Account account;
	UserAddress user;
	
	public UserAddress getUser() {
		return user;
	}
	public void setUser(UserAddress user) {
		this.user = user;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
