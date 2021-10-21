package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.entity.ProjectDelivery;

public interface IProjectDeliveryService {
	
	public List<ProjectDelivery> findAll();
	public ProjectDelivery findById(Long projectDeliveryId);
	public ProjectDelivery save(ProjectDelivery projectDelivery);
	public void delete(Long projectDeliveryId);
}