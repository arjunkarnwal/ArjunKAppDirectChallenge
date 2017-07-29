package com.arjun.appdirect.repository;


import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.arjun.appdirect.model.web.UserProfile;

@Repository
public interface UserRepository extends BaseRepository<UserProfile, Serializable> {
	
	public UserProfile findByOpenId(String openId);
	
}
