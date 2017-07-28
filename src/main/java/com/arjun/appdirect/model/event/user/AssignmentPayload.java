package com.arjun.appdirect.model.event.user;

import com.arjun.appdirect.model.Account;
import com.arjun.appdirect.model.User;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AssignmentPayload {
    Account account;
    User user;
}
