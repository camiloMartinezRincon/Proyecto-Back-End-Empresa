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
@Table(name = "cotizaciones")
public class Cotizacion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cotizacionId;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "cliente_nombre_apellido", nullable = false)
	private String clienteNombreApellido;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Email(message = "Formato de Email incorrecto")
	@Column(name = "corp_email", nullable = false)
	private String corpEmail;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "fecha_inicio", nullable = false)
	private String fechaInicio;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "fecha_entrega", nullable = false)
	private String fechaEntrega;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "tipo_servicio", nullable = false)
	private String tipoServicio;
	
	@NotEmpty(message = "No puede estar Vacio")
	@Column(name = "cotizacion_descripcion", nullable = false)
	private String cotizacionDescripcion;
	
	@Column(name = "owner_mail", nullable = true)
	private String ownerMail;

	public String getOwnerMail() {
		return ownerMail;
	}

	public void setOwnerMail(String ownerMail) {
		this.ownerMail = ownerMail;
	}

	public Long getCotizacionId() {
		return cotizacionId;
	}

	public void setCotizacionId(Long cotizacionId) {
		this.cotizacionId = cotizacionId;
	}

	public String getClienteNombreApellido() {
		return clienteNombreApellido;
	}

	public void setClienteNombreApellido(String clienteNombreApellido) {
		this.clienteNombreApellido = clienteNombreApellido;
	}

	public String getCorpEmail() {
		return corpEmail;
	}

	public void setCorpEmail(String corpEmail) {
		this.corpEmail = corpEmail;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCotizacionDescripcion() {
		return cotizacionDescripcion;
	}

	public void setCotizacionDescripcion(String cotizacionDescripcion) {
		this.cotizacionDescripcion = cotizacionDescripcion;
	}
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
}
