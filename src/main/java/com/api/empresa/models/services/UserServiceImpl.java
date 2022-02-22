package com.api.empresa.models.services;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.empresa.models.dao.IUserDao;
import com.api.empresa.models.entity.User;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
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

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String corpUserEmail) throws UsernameNotFoundException {
		
		User user = userDao.findByEmail(corpUserEmail);
		
		if(user == null) {
			logger.error("Error in login: User doesn't exists, with email '" + corpUserEmail + "' in the system!!");
			throw new UsernameNotFoundException("Error in login: User doesn't exists, with email '" + corpUserEmail + "' in the system!!");
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.peek(authority -> logger.info("User role:" + authority.getAuthority()))
				.collect(Collectors.toList());
				
		return new org.springframework.security.core.userdetails.User(user.getCorpUserEmail(), user.getUserPassword(), user.getEnabled(), true, true, true, authorities);
	}

}
