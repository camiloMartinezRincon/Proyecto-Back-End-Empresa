package com.api.empresa.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.empresa.models.dao.IUserDao;
import com.api.empresa.models.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public User findById(Long userId) {
		return userDao.findById(userId).orElse(null);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional
	public void delete(Long userId) {
		userDao.deleteById(userId);
	}

	@java.lang.Override
	public String authenticate(String corpUserEmail, String userPassword) {
		User authenticatedUser = new User();
		authenticatedUser = userDao.findByCorpUserEmail(corpUserEmail);
		if(userPassword.equals(authenticatedUser.getUserPassword())){
			return "Correct";
		}else{
			return "Incorrect";
		}
	}

}
