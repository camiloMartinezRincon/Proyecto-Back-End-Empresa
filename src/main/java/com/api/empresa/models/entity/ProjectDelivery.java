package com.api.empresa.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "projects_deliveries")
public class ProjectDelivery implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectDeliveryId;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "client_full_name", nullable = false)
	private String clientFullName;

	@NotEmpty(message = "No puede estar Vacio")
	@Email(message = "Formato de Email incorrecto")
	@Column(name = "client_email", nullable = false)
	private String clientEmail;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "project_name", nullable = false)
	private String projectName;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "delivery_date", nullable = false)
	private String deliveryDate;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "delivery_hour", nullable = false)
	private String deliveryHour;

	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "delivery_place", nullable = false)
	private String deliveryPlace;

	public Long getProjectDeliveryId() {
		return projectDeliveryId;
	}

	public void setProjectDeliveryId(Long projectDeliveryId) {
		this.projectDeliveryId = projectDeliveryId;
	}

	public String getClientFullName() {
		return clientFullName;
	}

	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDeliveryHour() {
		return deliveryHour;
	}

	public void setDeliveryHour(String deliveryHour) {
		this.deliveryHour = deliveryHour;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
}
