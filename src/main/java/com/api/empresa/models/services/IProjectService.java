package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.entity.Project;

public interface IProjectService {
	
	public List<Project> findAll();
	public Project findById(Long projectId);
	public Project save(Project project);
	public void delete(Long projectId);
}
