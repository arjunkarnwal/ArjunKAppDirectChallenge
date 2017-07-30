package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "item")
public class OrderItem {
    private int quantity;
    private String unit;
}
