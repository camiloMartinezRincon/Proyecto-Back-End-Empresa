package com.api.empresa.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "project_name", nullable = false)
	private String projectName;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "project_code", nullable = false)
	private String projectCode;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "service_type", nullable = false)
	private String serviceType;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "client_name", nullable = false)
	private String clientName;

	@NotEmpty(message = "No puede estar Vacio")
	@Email(message = "Formato de Email incorrecto")
	@Column(name = "client_email", nullable = false)
	private String clientEmail;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "start_date", nullable = false)
	private String startDate;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "end_date", nullable = false)
	private String endDate;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "project_description", nullable = false)
	private String projectDescription;
	
	@Column(name = "owner_mail", nullable = true)
	private String ownerMail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private User user;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private List<Requirement> requirements;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private List<ProjectDelivery> projectDeliveries;

	public Project() {
		this.requirements = new ArrayList<>();
		this.projectDeliveries = new ArrayList<>();
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getOwnerMail() {
		return ownerMail;
	}

	public void setOwnerMail(String ownerMail) {
		this.ownerMail = ownerMail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public List<ProjectDelivery> getProjectDeliveries() {
		return projectDeliveries;
	}

	public void setProjectDeliveries(List<ProjectDelivery> projectDeliveries) {
		this.projectDeliveries = projectDeliveries;
	}

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
}
