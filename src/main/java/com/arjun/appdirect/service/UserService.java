package com.arjun.appdirect.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjun.appdirect.model.Account;
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
    
    UserProfile getByOpenID(Long ids) {
    		return repository.findById(ids);
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
    
    public UserProfile createUser(Account account, User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can not be null");
        }
        
        if (account == null) {
            throw new IllegalArgumentException("Account can not be null");
        }
        
        if (StringUtils.isEmpty(user.getOpenId())) {
            throw new IllegalArgumentException("User's OpenId can not be empty");
        }
        
        if (StringUtils.isEmpty(String.valueOf(account.getAccountIdentifier()))) {
            throw new IllegalArgumentException("User's account identifier can not be empty");
        }
        UserProfile profile = null;
        List<Long> idList = new ArrayList<Long>();
		idList.add(account.getAccountIdentifier());
		List<UserProfile> userList = this.getByOpenID(idList);
		if(userList.size() >= 1) {
		//profile = this.getByOpenID(user.getOpenId());
        if (profile == null) {
            profile = new UserProfile();
            profile.setFirstName(String.valueOf(userList.size()));
            profile.setLastName(user.getLastName());
            profile.setEmail(user.getEmail());
            profile.setOpenId(user.getOpenId());

            profile = this.create(profile);
        }
		}

        return profile;
    }

}
