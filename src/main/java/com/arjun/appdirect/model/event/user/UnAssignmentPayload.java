package com.arjun.appdirect.model.event.user;

import com.arjun.appdirect.model.Account;
import com.arjun.appdirect.model.UserAddress;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UnAssignmentPayload {
	
	UserAddress userAddress;
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	Account account;

}
