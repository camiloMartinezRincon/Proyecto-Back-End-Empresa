package com.api.empresa.models.services;


import com.api.empresa.models.entity.User;


public interface IUserService {
	
	public User findById(Long userId);
	public User save(User user);
	public void delete(Long userId);

    public String authenticate(String corpUserEmail, String userPassword);
}
