package com.api.empresa.models.services;


import com.api.empresa.models.entity.User;
import org.springframework.transaction.annotation.Transactional;


public interface IUserService {
	
	public User findById(Long userId);

	@Transactional(readOnly = true)
	User findByCorpUserEmail(String userEmail);
	public User save(User user);
	public void delete(Long userId);

    public User authenticate(String corpUserEmail, String userPassword);
}
