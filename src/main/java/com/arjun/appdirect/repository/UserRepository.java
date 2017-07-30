package com.arjun.appdirect.repository;


import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arjun.appdirect.model.web.UserProfile;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<UserProfile, Serializable> {
	
	public UserProfile findByOpenId(String openId);
	
	public List<UserProfile> findByIdIn(List<Long> ids);
	
}
