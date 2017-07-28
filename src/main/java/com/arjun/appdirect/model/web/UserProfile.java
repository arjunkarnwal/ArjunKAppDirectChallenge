package com.arjun.appdirect.model.web;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserProfile {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String email;
    private String openId;

    private String firstName;
    private String lastName;
    
    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
