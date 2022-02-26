package com.api.empresa.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "requirements")
public class Requirement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requirementId;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "requirement_code", nullable = false)
	private String requirementCode;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "requirement_type", nullable = false)
	private String requirementType;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "project_name", nullable = false)
	private String projectName;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "requirement_title", nullable = false)
	private String requirementTitle;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "requirement_priority", nullable = false)
	private String requirementPriority;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "requirement_description", nullable = false)
	private String requirementDescription;

	@Column(name = "requerement_userEmail", nullable = true)
	private String requerement_usermail;

	public Long getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}

	public String getRequirementCode() {
		return requirementCode;
	}

	public void setRequirementCode(String requirementCode) {
		this.requirementCode = requirementCode;
	}

	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRequirementTitle() {
		return requirementTitle;
	}

	public void setRequirementTitle(String requirementTitle) {
		this.requirementTitle = requirementTitle;
	}

	public String getRequirementPriority() {
		return requirementPriority;
	}

	public void setRequirementPriority(String requirementPriority) {
		this.requirementPriority = requirementPriority;
	}

	public String getRequirementDescription() {
		return requirementDescription;
	}

	public void setRequirementDescription(String requirementDescription) {
		this.requirementDescription = requirementDescription;
	}
	public String getRequerement_usermail() {
		return requerement_usermail;
	}
	public void setRequerement_usermail(String requerement_usermail) {
		this.requerement_usermail = requerement_usermail;
	}

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
}
