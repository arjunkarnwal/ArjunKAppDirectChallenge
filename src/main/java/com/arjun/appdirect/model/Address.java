package com.arjun.appdirect.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@XmlRootElement
public class Address {
	private String city;
	private String country;
	private String firstName;
	private String fullName;
	private String lastName;
	private String phone;
	private String state;
	private String street1;
	private String zip;
}
