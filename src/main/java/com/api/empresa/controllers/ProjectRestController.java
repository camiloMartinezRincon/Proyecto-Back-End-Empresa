package com.api.empresa.controllers;

import java.util.List;

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

import com.api.empresa.models.entity.Project;
import com.api.empresa.models.services.IProjectService;

@RestController
@RequestMapping("/api/company")
public class ProjectRestController {
	
	@Autowired
	private IProjectService projectService;
	
	@GetMapping("/projects/info")
	public List<Project> allProjects() {
		return projectService.findAll();
	}
	
	@GetMapping("/project/info/{projectId}")
	public Project showProjectInformation(@PathVariable Long projectId) {
		return projectService.findById(projectId);
	}
	
	@PostMapping("/new/project")
	@ResponseStatus(HttpStatus.CREATED)
	public Project createProject(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@PutMapping("/project/update/info/{projectId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Project updateProjectInfo(@RequestBody Project project, @PathVariable Long projectId) {
		Project currentProject = projectService.findById(projectId);
		
		currentProject.setProjectName(project.getProjectName());
		currentProject.setProjectCode(project.getProjectCode());
		currentProject.setServiceType(project.getServiceType());
		currentProject.setClientName(project.getClientName());
		currentProject.setClientEmail(project.getClientEmail());
		currentProject.setStartDate(project.getStartDate());
		currentProject.setEndDate(project.getEndDate());
		currentProject.setProjectDescription(project.getProjectDescription());
		
		return projectService.save(currentProject);
	}
	
	@DeleteMapping("/project/delete/{projectId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProject(@PathVariable Long projectId) {
		projectService.delete(projectId);
	}
}
