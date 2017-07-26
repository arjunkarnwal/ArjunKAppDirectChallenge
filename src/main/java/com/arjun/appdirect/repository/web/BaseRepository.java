package com.arjun.appdirect.repository.web;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
	
	@Override
    List<T> findAll();
}