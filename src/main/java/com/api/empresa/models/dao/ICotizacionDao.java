package com.api.empresa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.Cotizacion;

public interface ICotizacionDao extends CrudRepository<Cotizacion, Long> {
	
}
