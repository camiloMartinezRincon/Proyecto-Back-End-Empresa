package com.api.empresa.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "user_name", nullable = false)
	private String userName;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "user_lastname", nullable = false)
	private String userLastname;

	@NotEmpty(message = "No puede estar Vacio")
	@Email(message = "Formato de Email incorrecto")
	@Column(name = "corp_user_email", nullable = false)
	private String corpUserEmail;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "user_password", nullable = false)
	private String userPassword;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Requirement> requirements;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<ProjectDelivery> projectDeliveries;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Project> projects;

	public User() {
		this.requirements = new ArrayList<>();
		this.projectDeliveries = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getCorpUserEmail() {
		return corpUserEmail;
	}

	public void setCorpUserEmail(String corpUserEmail) {
		this.corpUserEmail = corpUserEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
}
