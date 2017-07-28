package com.arjun.appdirect.model.event.user;

import com.arjun.appdirect.model.Account;
import com.arjun.appdirect.model.UserAddress;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UnAssignmentPayload {
	
	UserAddress userAddress;
	Account account;

}
