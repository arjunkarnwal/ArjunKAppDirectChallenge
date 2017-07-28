package com.arjun.appdirect.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement
    private String editionCode;
    
    @XmlElement
    private String pricingDuration;

    @XmlElement(name = "items")
    private List<OrderItem> orderItem;

}
