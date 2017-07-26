package com.arjun.appdirect.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjun.appdirect.model.web.User;
import com.arjun.appdirect.repository.web.BaseRepository;
import com.arjun.appdirect.repository.web.UserRepository;

@Service
public class UserService extends AbstractCrudService<User, Long> {
	
	@Autowired
    private UserRepository repository;

    public User getByOpenID(String openId) {
        return repository.findByOpenId(openId);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    protected BaseRepository<User, Serializable> getRepository() {
        return repository;
    }

}
