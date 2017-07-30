package com.arjun.appdirect.model.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.arjun.appdirect.model.Company;
import com.arjun.appdirect.model.Order;


@XmlRootElement(name = "payload")
public class SubscriptionOrderPayload {
    private Company company;
    private Order order;
}
