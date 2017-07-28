package com.arjun.appdirect.model.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.arjun.appdirect.model.Account;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlRootElement(name = "payload")
public class SubscriptionCancelPayload {
    Account account;
}
