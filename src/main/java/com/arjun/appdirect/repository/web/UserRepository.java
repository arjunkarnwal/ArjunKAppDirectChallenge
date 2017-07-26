package com.arjun.appdirect.repository.web;


import java.io.Serializable;

import com.arjun.appdirect.model.web.User;

public interface UserRepository extends BaseRepository<User, Serializable> {
	
	public User findByOpenId(String openId);
	public User findByEmail(String email);
	
}
