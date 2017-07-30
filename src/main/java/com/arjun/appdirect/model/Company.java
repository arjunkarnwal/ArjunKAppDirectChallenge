package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Company {
    private String uuid;
    private String country;
    private String name;
    private String phoneNumber;
    private String website;
}
