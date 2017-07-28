package com.arjun.appdirect.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Account {
    private Long accountIdentifier;
    private String status;
}
