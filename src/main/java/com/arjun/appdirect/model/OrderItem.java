package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.ToString;

@XmlRootElement(name = "item")
@Data
@ToString
public class OrderItem {
    private int quantity;
    private String unit;
}
