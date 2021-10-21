package com.api.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.empresa.models.entity.ProjectDelivery;
import com.api.empresa.models.services.IProjectDeliveryService;

@RestController
@RequestMapping("/api/company")
public class ProjectDeliveryRestController {
	
	@Autowired
	private IProjectDeliveryService projectDeliveryService;
	
	@GetMapping("/project/deliveries/info")
	public List<ProjectDelivery> allProjectDeliveries() {
		return projectDeliveryService.findAll();
	}
	
	@GetMapping("/project/delivery/info/{projectDeliveryId}")
	public ProjectDelivery showProjectDeliveryInformation(@PathVariable Long projectDeliveryId) {
		return projectDeliveryService.findById(projectDeliveryId);
	}
	
	@PostMapping("/new/project/delivery")
	@ResponseStatus(HttpStatus.CREATED)
	public ProjectDelivery createProjectDelivery(@RequestBody ProjectDelivery projectDelivery) {
		return projectDeliveryService.save(projectDelivery);
	}
	
	@PutMapping("/project/delivery/update/info/{projectDeliveryId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProjectDelivery updateProjectDeliveryInfo(@RequestBody ProjectDelivery projectDelivery, @PathVariable Long projectDeliveryId) {
		ProjectDelivery currentProjectDelivery = projectDeliveryService.findById(projectDeliveryId);
		
		currentProjectDelivery.setClientFullName(projectDelivery.getClientFullName());
		currentProjectDelivery.setClientEmail(projectDelivery.getClientEmail());
		currentProjectDelivery.setProjectName(projectDelivery.getProjectName());
		currentProjectDelivery.setDeliveryDate(projectDelivery.getDeliveryDate());
		currentProjectDelivery.setDeliveryHour(projectDelivery.getDeliveryHour());
		currentProjectDelivery.setDeliveryPlace(projectDelivery.getDeliveryPlace());
		
		return projectDeliveryService.save(currentProjectDelivery);
	}
	
	@RequestMapping("/project/delivery/delete/{projectDeliveryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProjectDelivery(@PathVariable Long projectDeliveryId) {
		projectDeliveryService.delete(projectDeliveryId);
	}
}
