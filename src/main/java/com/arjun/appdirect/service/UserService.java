package com.arjun.appdirect.service;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjun.appdirect.model.User;
import com.arjun.appdirect.model.web.UserProfile;
import com.arjun.appdirect.repository.BaseRepository;
import com.arjun.appdirect.repository.UserRepository;

@Service
public class UserService extends AbstractCrudService<UserProfile, Long> {
	
	@Autowired
    private UserRepository repository;

    public UserProfile getByOpenID(String openId) {
        return repository.findByOpenId(openId);
    }

    @Override
    protected BaseRepository<UserProfile, Serializable> getRepository() {
        return repository;
    }
    
    public UserProfile createProfile(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can not be null");
        }
        
        
        if (StringUtils.isEmpty(user.getOpenId())) {
            throw new IllegalArgumentException("User's OpenId can not be empty");
        }
		
        UserProfile profile = this.getByOpenID(user.getOpenId());

        if (profile == null) {
            profile = new UserProfile();
            profile.setFirstName(user.getFirstName());
            profile.setLastName(user.getLastName());
            profile.setEmail(user.getEmail());
            profile.setOpenId(user.getOpenId());

            profile = this.create(profile);
        }

        return profile;
    }

}
