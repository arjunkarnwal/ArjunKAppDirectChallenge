package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlRootElement
public class Company {
    private String uuid;
    private String country;
    private String name;
    private String phoneNumber;
    private String website;
}
