package com.api.empresa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

}
