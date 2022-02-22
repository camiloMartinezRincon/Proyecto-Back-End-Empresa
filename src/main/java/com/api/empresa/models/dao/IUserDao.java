package com.api.empresa.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.corpUserEmail = ?1")
	public User findByEmail(String corpUserEmail);
}
