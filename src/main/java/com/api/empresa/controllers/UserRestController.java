package com.api.empresa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.empresa.models.entity.User;
import com.api.empresa.models.services.IUserService;

/*
 * CrossOrigin es para darle acceso a la IP
 * y a los metodos que quiera usar, se ponen con la
 * URL del front end 
 * @CrossOrigin()
 */

@RestController
@RequestMapping("/api/company")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/user/info/{userId}")
	public User showInformation(@PathVariable Long userId) {
		return userService.findById(userId);
	}
	
	@PostMapping("/new/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/user/update/info/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public User updateUserInfo(@RequestBody User user, @PathVariable Long userId) {
		User currentUser = userService.findById(userId);
		
		currentUser.setUserName(user.getUserName());
		currentUser.setUserLastname(user.getUserLastname());
		currentUser.setCorpUserEmail(user.getCorpUserEmail());
		
		return userService.save(currentUser);
	}
	
	@PutMapping("/user/update/password/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public User updateUserPassword(@RequestBody User user, @PathVariable Long userId) {
		User currentUserPassword = userService.findById(userId);
		
		currentUserPassword.setUserPassword(user.getUserPassword());
		
		return userService.save(currentUserPassword);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) {
		userService.delete(userId);
	}
}
