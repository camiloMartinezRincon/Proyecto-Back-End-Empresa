package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.entity.Requirement;

public interface IRequirementService {
	
	public List<Requirement> findAll();
	public Requirement findById(Long requirementId);
	public Requirement save(Requirement requirement);
	public void delete(Long requirementId);
}
