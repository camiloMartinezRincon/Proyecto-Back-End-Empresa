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

import com.api.empresa.models.entity.Requirement;
import com.api.empresa.models.services.IRequirementService;

@RestController
@RequestMapping("/api/company")
public class RequirementRestController {
	
	@Autowired
	private IRequirementService requirementService;
	
	@GetMapping("/requirements/info")
	public List<Requirement> allRequirements() {
		return requirementService.findAll();
	}
	
	@GetMapping("/requirements/info/{requirementId}")
	public Requirement showProjectDeliveryInfo(@PathVariable Long requirementId) {
		return requirementService.findById(requirementId);
	}
	
	@PostMapping("/new/requirement")
	@ResponseStatus(HttpStatus.CREATED)
	public Requirement createRequirement(@RequestBody Requirement requirement) {
		return requirementService.save(requirement);
	}
	
	@PutMapping("/requirement/update/info/{requirementId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Requirement updateRequirementInfo(@RequestBody Requirement requirement, @PathVariable Long requirementId) {
		Requirement currentRequirement = requirementService.findById(requirementId);
		
		currentRequirement.setRequirementCode(requirement.getRequirementCode());
		currentRequirement.setRequirementType(requirement.getRequirementType());
		currentRequirement.setProjectName(requirement.getProjectName());
		currentRequirement.setRequirementTitle(requirement.getRequirementTitle());
		currentRequirement.setRequirementPriority(requirement.getRequirementPriority());
		currentRequirement.setRequirementDescription(requirement.getRequirementDescription());
		
		return requirementService.save(currentRequirement);
	}
	
	@DeleteMapping("/requirement/delete/{requirementId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRequirement(@PathVariable Long requirementId) {
		requirementService.delete(requirementId);
	}
}
