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
@Table(name = "catalogo_servicios")
public class CatalogoServicios implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicioId;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "nombre_servicio", nullable = false)
	private String nombreServicio;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "precio_servicio", nullable = false)
	private String precioServicio;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "descripcion_servicio", nullable = false)
	private String descripcionServicio;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "direccion_recurso", nullable = false)
	private String direccionRecurso;

	public Long getServicioId() {
		return servicioId;
	}

	public void setServicioId(Long servicioId) {
		this.servicioId = servicioId;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getPrecioServicio() {
		return precioServicio;
	}

	public void setPrecioServicio(String precioServicio) {
		this.precioServicio = precioServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public String getDireccionRecurso() {
		return direccionRecurso;
	}

	public void setDireccionRecurso(String direccionRecurso) {
		this.direccionRecurso = direccionRecurso;
	}
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;	
}
